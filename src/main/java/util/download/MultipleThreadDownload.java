package util.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static util.download.Commons.*;

/**
 * 多线程下载
 * 2019年7月13日
 */
class MultipleThreadDownload {

    /**
     * 下载的链接
     */
    private String url;

    /**
     * 下载的目标位置
     */
    private File outputFile;

    /**
     * 请求头
     */
    private Map<String, String> header;

    /**
     * 下载监听
     */
    private DownloadListener downloadListener;

    /**
     * 记录响应码，默认为-1
     */
    private int responseCode = -1;

    /**
     * 下载文件大小
     */
    private long contentLength;

    /**
     * 当前下载的大小，实时更新
     */
    private AtomicLong currentDownloadSize = new AtomicLong(0);

    /**
     * 下载服务线程
     */
    private ExecutorService downloadService;

    /**
     * 记录开始点的数组
     */
    private long[] starts;

    /**
     * 记录结束点的数组
     */
    private long[] ends;

    /**
     * 断点Map
     */
    private TreeMap<Long, Long> breakPoint;

    /**
     * 用来统计下载时长
     */
    private long totalDownloadTime;

    /**
     * 单线程下载器带请求头和监听器
     *
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    MultipleThreadDownload(Map<String, String> header, DownloadListener downloadListener) {
        this.header = header;
        this.downloadListener = downloadListener;
    }

    /**
     * 多线程下载 OK
     *
     * @param url        要下载的URL，不允许用户手动定义，必须是程序内部处理的URL
     * @param outputFile 输出文件
     */
    @SuppressWarnings("all")
    void download(String url, File outputFile) {
        this.url = url;
        this.outputFile = outputFile;
        // 已经下载的字节（用来计算下载速度）
        currentDownloadSize.set(getLastDownloadSize());
        if (downloadListener != null) downloadListener.connecting(url, currentDownloadSize.get());
        // 检查URL
        HttpURLConnection urlConnection = checkUrlAndReturnHttpURLConnection();
        if (urlConnection == null) return;

        // =========做点准备==========
        contentLength = urlConnection.getContentLengthLong(); // 网络文件大小
        if (outputFile.length() == contentLength) { // 如果文件已经存在
            getBreakPointFile(outputFile).delete(); // 预防上次停止程序没有来得及删除断点
            if (downloadListener != null) downloadListener.over(0, 0); // 下载完成回调
            return;
        }

        // 预防报错，建个文件夹
        mkdirs(outputFile);

        // ==== 开始下载逻辑 ======
        long blockSize = (long) (SEGMENT_SIZE * 1024 * 1024); // 计算一块文件的大小
        int segmentNum = (int) (contentLength / blockSize); // 计算要把文件分为几块
        boolean isNeedBreakPointResume = breakPoint != null && breakPoint.size() > 0; // 是否需要断点续传
        // 如果文件过小，或者不支持多线程下载，就使用单线程下载
        if (segmentNum < 1 || responseCode != 206) {
            new SingleThreadDownload(header, downloadListener).download(url, outputFile);
            return;
        }
        if (isNeedBreakPointResume) segmentNum = breakPoint.size();
        // 开启一个线程池，控制这些段文件
        downloadService =
                Executors.newFixedThreadPool((int) (segmentNum > MAX_THREAD ? MAX_THREAD : segmentNum));
        totalDownloadTime = System.currentTimeMillis();
        if (downloadListener != null) downloadListener.start(contentLength);
        starts = new long[segmentNum];
        ends = new long[segmentNum];

        if (isNeedBreakPointResume) {
            AtomicInteger i = new AtomicInteger(0);
            breakPoint.forEach((start, end) -> {
                startDownload(start, end, i.getAndIncrement());
            });
        } else {
            for (int i = 0; i < segmentNum; i++) {
                // 计算文件块开始和结束的位置
                /* ========== 每个线程负责下载的位置通用公式 ====
                    i * blockSize ~ (i + 1) * blockSize - 1
                    最后一个线程 (i == segmentNum - 1)
                    i * blockSize ~ fileSize - 1
                ====================================== */
                long start = i * blockSize; // 本次文件的开始
                long end = (i + 1) * blockSize - 1; // 本次文件的结束
                if (i == segmentNum - 1) {
                    end = contentLength; // 如果最后一次任务则下载全部
                }
                startDownload(start, end, i);
            }
        }
        downloadService.shutdown();
        // ========记录网速==========
        downloadSpeedAndBreakPointListenerAndDownloadOverCallback();
    }

    /**
     * 检查URL的有效性，并且返回链接对象 OK
     *
     * @return HttpURLConnection对象
     */
    private HttpURLConnection checkUrlAndReturnHttpURLConnection() {
        try {
            HttpURLConnection urlConnection = getHttpUrlConnection(url, header); // 如果URL格式错误抛出异常
            urlConnection.setRequestProperty("Range", "bytes=0-");
            responseCode = urlConnection.getResponseCode(); // 响应码
            if (responseCode > 400) { // 链接无效
                if (downloadListener != null) downloadListener.downloadError(responseCode,
                        new DownloadException("服务端错误, 请检查你的请求头和链接地址, 响应码为:" + responseCode)); // 下载失败回调
                return null;
            }
            return urlConnection;
        } catch (IOException e) { // 链接不存在
            if (downloadListener != null) downloadListener.downloadError(responseCode,
                    new DownloadException("连接出现了问题, 请检查你的请求头和链接地址, 响应码为:" + responseCode)); // 下载失败回调
            return null;
        }
    }

    /**
     * 开始下载方法 OK
     *
     * @param start 该段开始的位置
     * @param end   该段结束的位置
     * @param order 该段属于第几段
     */
    private void startDownload(long start, long end, int order) {
        downloadService.submit(() -> {
            try {
                downloadPartFileWithRetry(start, end, order, new AtomicInteger(0));
            } catch (IOException e) {
                if (downloadListener != null) downloadListener.downloadError(responseCode, e);
                // 如果某一段重试了规定的次数，却不能下载完成，就停止整个线程的下载
                downloadService.shutdownNow();
            }
        });
    }

    /**
     * 下载文件的一部分 OK
     *
     * @param start 部分文件的开始点
     * @param end   部分文件的结束点
     * @param order 该段文件在总文件中属于第几段
     */
    private void downloadPartFileWithRetry(long start, long end, int order, AtomicInteger retryCountControl) throws IOException {
        starts[order] = start;
        ends[order] = end;
        // 进行分段下载
        try {
            // 新建立一个连接
            URLConnection segmentConnection = getHttpUrlConnection(url, header);
            // 设置下载范围
            segmentConnection.setRequestProperty("Range", "bytes=" + start + "-" + end);
            // 进行本段文件的写入
            InputStream input = segmentConnection.getInputStream();
            // 输出
            RandomAccessFile output = new RandomAccessFile(outputFile, "rw"); // 建立文件
            // 寻找本次写入文件的起点
            output.seek(start);
            int length;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            while (EOF != (length = input.read(buffer))) {
                currentDownloadSize.addAndGet(length);
                starts[order] += length;
                output.write(buffer, 0, length);
            }
            output.close();
            input.close();
        } catch (IOException e) {
            // 自动重试规定的次数
            if (retryCountControl.getAndIncrement() < RETRY_NUM) {
                // 虽然这里重新开始，但是也不会让实时下载尺寸减少，如果实时下载尺寸一直累加可能会造成进度超过100%
                // 但是不用担心这种问题，因为一旦开始写文件，就不可能走这里了
                downloadPartFileWithRetry(start, end, order, retryCountControl);
                return;
            }
            throw e;
        }
    }

    /**
     * 同时进行监视下载速度，写入下载断点，下载结束的回调 OK
     */
    @SuppressWarnings("all")
    private void downloadSpeedAndBreakPointListenerAndDownloadOverCallback() {
        // 用来记录上一秒的文件尺寸
        AtomicLong lastSecondFileSize = new AtomicLong(currentDownloadSize.get());
        // 记录临时的文件大小
        ArrayList<Long> speedList = new ArrayList<>(); // 记录每秒钟的速度
        // 断点文件
        File breakPointFile = getBreakPointFile(outputFile);
        // 用来记录断点的Map
        TreeMap<Long, Long> breakPointMap = new TreeMap<>();
        // 定时任务
        ScheduledExecutorService downloadSpeedScheduleService =
                Executors.newSingleThreadScheduledExecutor();
        // 执行定时任务
        downloadSpeedScheduleService.scheduleAtFixedRate(() -> {
            // 获取当前已经下载了多少
            long currentFileSize = currentDownloadSize.get();
            // 记录断点
            if (starts.length == ends.length) {
                breakPointMap.clear();
                for (int i = 0; i < starts.length; i++) {
                    if (starts[i] < ends[i]) breakPointMap.put(starts[i], ends[i]);
                }
                new BreakPointResumeService(url, breakPointMap).writeBreakPointInfo(breakPointFile);
            }
            // 下载速度 = 当前文件大小 - 一秒前文件大小
            long currentSpeed = currentFileSize - lastSecondFileSize.get();
            // 记录下载速度
            if (currentSpeed != 0) speedList.add(currentSpeed);
            // 下载中回调
            if (downloadListener != null) {
                downloadListener.downloading(
                        contentLength < 0 ? 0 : (double) currentFileSize / contentLength,
                        currentSpeed,
                        contentLength < 0 ? -1 : currentSpeed == 0 ? -1 : (contentLength - currentFileSize) / currentSpeed
                );
            }
            // 下载完成
            if (downloadService.isTerminated()) {
                // 下载完成回调
                if (downloadListener != null) downloadListener.over(
                        (System.currentTimeMillis() - totalDownloadTime) / 1000,
                        speedList.stream().mapToLong(value -> value).average().orElse(Double.NaN)
                );
                breakPointFile.delete();
                // 下载完成后结束定时任务
                downloadSpeedScheduleService.shutdownNow();
            }
            // 设置新的大小到tempSize中
            lastSecondFileSize.set(currentFileSize);
        }, 1, 1, TimeUnit.SECONDS);
    }


    /**
     * 获取上次文件已经下载的大小 OK
     * 比如说断点的形式是：
     * 3-5
     * 7-8
     * 计算出一共8B，上次已经下载了5B
     *
     * @return 上次文件已经下载的大小
     */
    private long getLastDownloadSize() {
        breakPoint = readBreakPoint();
        if (breakPoint == null) return 0;
        AtomicLong lastDownloadSize = new AtomicLong(0); // 用来累加
        // 用来记录上一个Map的值
        AtomicLong lastValue = new AtomicLong(0);
        breakPoint.forEach((key, value) -> {
            lastDownloadSize.addAndGet(key - lastValue.get()); // 用这次的键减去上次的值
            lastValue.set(value); // 存储当前的值，下次循环使用
        });
        return lastDownloadSize.get();
    }

    /**
     * 读取多线程断点 OK
     *
     * @return 断点Map
     */
    private TreeMap<Long, Long> readBreakPoint() {
        if (outputFile.exists()) {
            File tempFilePath = getBreakPointFile(outputFile);
            BreakPointResumeService breakPointResumeService = BreakPointResumeService.readBreakPointInfo(tempFilePath);
            if (breakPointResumeService != null) {
                // 正在下载的文件和断点文件是同一个链接
                if (url.equals(breakPointResumeService.getUrl())) {
                    TreeMap<Long, Long> breakPoint = breakPointResumeService.getBreakPoint();
                    if (breakPoint != null) {
                        return breakPoint;
                    }
                }
            }
        }
        return null;
    }
}
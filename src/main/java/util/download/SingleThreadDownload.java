package util.download;

import java.io.*;
import java.net.HttpURLConnection;
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
 * 单线程下载器
 * 2019年7月12日
 */
class SingleThreadDownload {

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
     * 该文件是否支持断点续传
     */
    private boolean isSupportBreakPointResume;

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
    private ExecutorService downloadService = Executors.newSingleThreadExecutor();

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
    SingleThreadDownload(Map<String, String> header, DownloadListener downloadListener) {
        this.header = header;
        this.downloadListener = downloadListener;
    }

    /**
     * 单线程下载 OK
     *
     * @param url        要下载的URL
     * @param outputFile 输出文件
     */
    @SuppressWarnings("all")
    void download(String url, File outputFile) {
        this.url = url;
        this.outputFile = outputFile;
        // 已经下载的字节（用来做断点续传和计算下载速度）
        currentDownloadSize.set(readBreakPoint().get());
        if (downloadListener != null) downloadListener.connecting(url, currentDownloadSize.get());
        // 检查URL
        HttpURLConnection urlConnection = checkUrlAndReturnHttpURLConnection();
        if (urlConnection == null) return;

        // =========做点准备==========
        contentLength = urlConnection.getContentLengthLong(); // 网络文件大小
        if (outputFile.length() == contentLength) { // 如果文件已经存在，就不下载了
            getBreakPointFile(outputFile).delete(); // 预防上次停止程序没有来得及删除断点
            if (downloadListener != null) downloadListener.over(0, 0);// 下载完成回调
            return;
        }
        // 预防报错，新建文件夹
        mkdirs(outputFile);

        // =========开始一个线程下载==========
        downloadService.submit(() -> {
            totalDownloadTime = System.currentTimeMillis();
            // 下载开始回调
            if (downloadListener != null) downloadListener.start(contentLength); // 开始下载了
            try {
                // 如果下载失败自动重试规定的次数，如果还不行，就提示下载失败
                downloadWithRetry(new AtomicInteger(0));
            } catch (IOException e) {
                // 下载失败回调
                if (downloadListener != null) downloadListener.downloadError(responseCode, e);
                downloadService.shutdownNow();
            }
        });
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
            isSupportBreakPointResume = responseCode == 206; // 是否支持断点续传
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
     * 带有自动重试的单线程下载 OK
     */
    private void downloadWithRetry(AtomicInteger retryCountControl) throws IOException {
        try {
            HttpURLConnection urlConnection = getHttpUrlConnection(url, header);
            long start = currentDownloadSize.get();
            if (start > 0) { // 需要断点续传
                urlConnection.setRequestProperty("Range", "bytes=" + start + "-");
                InputStream input = urlConnection.getInputStream();
                RandomAccessFile output = new RandomAccessFile(outputFile, "rw");
                output.seek(start);
                copy(input, output);
            } else {
                InputStream input = urlConnection.getInputStream();
                FileOutputStream output = new FileOutputStream(outputFile);
                copy(input, output);
            }
        } catch (Exception e) {
            if (retryCountControl.getAndIncrement() < RETRY_NUM) { // 自动重试规定的次数
                // 这里不用考虑可能会出现负网速的情况
                // 为什么说会出现负网速，因为每一秒都要获取上一秒文件的尺寸，如果这里突然置为零
                // 那么当前的尺寸减去上一秒文件的尺寸就是负网速了
                // 为什么不用担心，因为一旦开始写文件就不可能走这里了，所以不用担心
                currentDownloadSize.set(0); // 重置当前下载尺寸
                downloadWithRetry(retryCountControl);
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
            if (isSupportBreakPointResume) {
                breakPointMap.clear();
                // 因为是记录断点所以这里再次调用currentDownloadBytes.get()获取最新的实时下载量
                breakPointMap.put(currentDownloadSize.get(), contentLength);
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
     * 读取单线程下载的断点 OK
     *
     * @return 断点值
     */
    private AtomicLong readBreakPoint() {
        if (outputFile.exists()) {
            File tempFilePath = getBreakPointFile(outputFile);
            BreakPointResumeService breakPointResumeService =
                    BreakPointResumeService.readBreakPointInfo(tempFilePath);
            if (breakPointResumeService != null) {
                if (url.equals(breakPointResumeService.getUrl())) { // 正在下载的文件和断点文件是同一个链接
                    TreeMap<Long, Long> breakPoint = breakPointResumeService.getBreakPoint();
                    if (breakPoint != null && breakPoint.size() == 1) {
                        return new AtomicLong((Long) breakPoint.keySet().toArray()[0]);
                    }
                }
            }
        }
        return new AtomicLong(0);
    }


    /**
     * 将输入流拷贝到输出流 OK
     *
     * @param input  输入流
     * @param output 输出流
     * @throws IOException #
     */
    private void copy(InputStream input, RandomAccessFile output) throws IOException {
        int length;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        while (EOF != (length = input.read(buffer))) {
            currentDownloadSize.addAndGet(length); // 累加
            output.write(buffer, 0, length);
        }
        output.close();
        input.close();
    }

    /**
     * 将输入流拷贝到输出流 OK
     *
     * @param input  输入流
     * @param output 输出流
     * @throws IOException #
     */
    private void copy(InputStream input, FileOutputStream output) throws IOException {
        int length;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        while (EOF != (length = input.read(buffer))) {
            currentDownloadSize.addAndGet(length); // 累加
            output.write(buffer, 0, length);
        }
        output.close();
        input.close();
    }
}
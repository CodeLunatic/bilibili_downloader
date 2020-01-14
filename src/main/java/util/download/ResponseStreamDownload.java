package util.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static util.download.Commons.*;

/**
 * 响应流下载
 * 2019年7月13日
 */
class ResponseStreamDownload {

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
     * 当前下载的大小，实时更新
     */
    private AtomicLong currentDownloadSize = new AtomicLong(0);

    /**
     * 用来统计下载时长
     */
    private long totalDownloadTime;

    /**
     * 响应流下载
     *
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    ResponseStreamDownload(Map<String, String> header, DownloadListener downloadListener) {
        this.header = header;
        this.downloadListener = downloadListener;
    }

    /**
     * 下载响应流 OK
     *
     * @param url        下载链接
     * @param outputFile 输出流
     */
    void download(String url, File outputFile) {
        new SingleThreadDownload(header, downloadListener).download(url, outputFile);
    }

    /**
     * 下载响应流，追加到上次下载 OK
     *
     * @param url        下载链接
     * @param outputFile 输出流
     * @deprecated 不推荐使用该方法，因为该方法会造成文件的损坏
     */
    @Deprecated
    void downloadAppendToFile(String url, File outputFile) {
        this.url = url;
        this.outputFile = outputFile;
        if (downloadListener != null) downloadListener.connecting(url, outputFile.length());
        // 检查URL
        HttpURLConnection urlConnection = checkUrlAndReturnHttpURLConnection();
        if (urlConnection == null) return;
        if (urlConnection.getContentLengthLong() != -1) { // 如果不是响应流，使用单线程下载
            new SingleThreadDownload(header, downloadListener).download(url, outputFile);
            return;
        }
        ExecutorService downloadService = Executors.newSingleThreadExecutor();
        downloadService.submit(() -> {
            totalDownloadTime = System.currentTimeMillis();
            if (downloadListener != null) downloadListener.start(-1);
            try {
                // 下载失败后重试规定次数
                downloadWithRetry(new AtomicInteger(0));
            } catch (IOException e) {
                if (downloadListener != null) downloadListener.downloadError(responseCode, e);
                downloadService.shutdownNow();
            }
        });
        // 定时任务
        ScheduledExecutorService downloadSpeedScheduleService =
                Executors.newSingleThreadScheduledExecutor();
        // 用来记录上一秒的文件尺寸
        AtomicLong lastSecondFileSize = new AtomicLong(currentDownloadSize.get());
        // 记录临时的文件大小
        ArrayList<Long> speedList = new ArrayList<>(); // 记录每秒钟的速度
        // 执行定时任务
        downloadSpeedScheduleService.scheduleAtFixedRate(() -> {
            long currentFileSize = currentDownloadSize.get();
            long currentSpeed = currentFileSize - lastSecondFileSize.get();
            // 记录下载速度
            if (currentSpeed != 0) speedList.add(currentSpeed);
            if (downloadListener != null) downloadListener.downloading(
                    0,
                    currentSpeed,
                    -1
            );
            // 下载完成
            if (downloadService.isTerminated()) {
                // 下载完成回调
                if (downloadListener != null) downloadListener.over(
                        (System.currentTimeMillis() - totalDownloadTime) / 1000,
                        speedList.stream().mapToLong(value -> value).average().orElse(Double.NaN)
                );
                // 下载完成后结束定时任务
                downloadSpeedScheduleService.shutdownNow();
            }
            // 设置新的大小到tempSize中
            lastSecondFileSize.set(currentFileSize);
        }, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * 带有自动重试的单线程下载 OK
     */
    private void downloadWithRetry(AtomicInteger retryCountControl) throws IOException {
        try {
            // 这里为什么不复用URL连接呢，因为一次getInputStream后这个连接就不能进行第二次getInputStream了
            // 因为第二次的InputStream里面不包含第一次已经写入的信息，也就相当于内容缺失了。
            InputStream input = getHttpUrlConnection(url, header).getInputStream();
            RandomAccessFile output = new RandomAccessFile(outputFile, "rw");
            output.seek(outputFile.length());
            int length;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            while (EOF != (length = input.read(buffer))) {
                currentDownloadSize.addAndGet(length); // 累加
                output.write(buffer, 0, length);
            }
            output.close();
            input.close();
        } catch (Exception e) {
            if (retryCountControl.getAndIncrement() < RETRY_NUM) { // 自动重试规定的次数
                // 因为响应流是没有百分比的，所以重试的时候不用操作任何的数值，继续正常的记录网速就好了
                downloadWithRetry(retryCountControl);
                return;
            }
            throw e;
        }
    }

    /**
     * 检查URL的有效性，并且返回链接对象 OK
     *
     * @return HttpURLConnection对象
     */
    private HttpURLConnection checkUrlAndReturnHttpURLConnection() {
        try {
            HttpURLConnection urlConnection = getHttpUrlConnection(url, header); // 如果URL格式错误抛出异常
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
}
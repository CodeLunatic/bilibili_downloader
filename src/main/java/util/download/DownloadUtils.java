package util.download;

import util.StringUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 一个下载工具类
 * 2019年7月13日
 */
@SuppressWarnings("all")
public class DownloadUtils {

    /**
     * 如果没有规定文件的位置，默认下载到用户的下载目录下
     */
    private static final String DEFAULT_PATH = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;

    // ===================单线程同步下载======================

    /**
     * 单线程下载 OK
     *
     * @param url 下载链接
     */
    public static void downloadWithSingleThreadSync(String url) {
        downloadWithSingleThreadSync(url, null);
    }

    /**
     * 单线程下载 OK
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadWithSingleThreadSync(String url, File outputFile) {
        downloadWithSingleThreadSync(url, outputFile, null);
    }

    /**
     * 单线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadWithSingleThreadSync(String url, File outputFile, Map<String, String> header) {
        downloadWithSingleThreadSync(url, outputFile, header, null);
    }

    /**
     * 单线程下载
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadWithSingleThreadSync(String url, File outputFile, Map<String, String> header,
                                                    DownloadListener downloadListener) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new SingleThreadDownload(header,
                getSyncDownloadListener(countDownLatch, downloadListener))
                .download(url, outputFile);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ===================多线程同步下载======================

    /**
     * 多线程下载
     *
     * @param url 下载链接
     */
    public static void downloadWithMultipleThreadSync(String url) {
        downloadWithMultipleThreadSync(url, null);
    }

    /**
     * 多线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadWithMultipleThreadSync(String url, File outputFile) {
        downloadWithMultipleThreadSync(url, outputFile, null);
    }

    /**
     * 多线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadWithMultipleThreadSync(String url, File outputFile, Map<String, String> header) {
        downloadWithMultipleThreadSync(url, outputFile, header, null);
    }

    /**
     * 多线程下载
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadWithMultipleThreadSync(String url, File outputFile, Map<String, String> header,
                                                      DownloadListener downloadListener) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new MultipleThreadDownload(header,
                getSyncDownloadListener(countDownLatch, downloadListener))
                .download(url, outputFile);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ===================响应流同步下载======================

    /**
     * 下载响应流
     *
     * @param url 下载链接
     */
    public static void downloadResponseStreamSync(String url) {
        downloadResponseStreamSync(url, null);
    }

    /**
     * 下载响应流
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadResponseStreamSync(String url, File outputFile) {
        downloadResponseStreamSync(url, outputFile, null);
    }

    /**
     * 下载响应流
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadResponseStreamSync(String url, File outputFile, Map<String, String> header) {
        downloadResponseStreamSync(url, outputFile, header, null);
    }

    /**
     * 下载响应流
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadResponseStreamSync(String url, File outputFile, Map<String, String> header,
                                                  DownloadListener downloadListener) {
        downloadResponseStreamSync(url, outputFile, header, downloadListener, false);
    }

    /**
     * 下载响应流
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     * @param isAppend         是否在原来的文件上追加下载
     */
    public static void downloadResponseStreamSync(String url, File outputFile, Map<String, String> header,
                                                  DownloadListener downloadListener, boolean isAppend) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ResponseStreamDownload responseStreamDownload = new ResponseStreamDownload(header,
                getSyncDownloadListener(countDownLatch, downloadListener));
        if (isAppend) {
            responseStreamDownload.downloadAppendToFile(url, outputFile);
        } else {
            responseStreamDownload.download(url, outputFile);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ===================单线程异步下载======================

    /**
     * 单线程下载
     *
     * @param url 下载链接
     */
    public static void downloadWithSingleThreadAsync(String url) {
        downloadWithSingleThreadAsync(url, null);
    }

    /**
     * 单线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadWithSingleThreadAsync(String url, File outputFile) {
        downloadWithSingleThreadAsync(url, outputFile, null);
    }

    /**
     * 单线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadWithSingleThreadAsync(String url, File outputFile, Map<String, String> header) {
        downloadWithSingleThreadAsync(url, outputFile, header, null);
    }

    /**
     * 单线程下载
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadWithSingleThreadAsync(String url, File outputFile, Map<String, String> header,
                                                     DownloadListener downloadListener) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        new SingleThreadDownload(header, downloadListener).download(url, outputFile);
    }

    // ===================多线程异步下载======================

    /**
     * 多线程下载
     *
     * @param url 下载链接
     */
    public static void downloadWithMultipleThreadAsync(String url) {
        downloadWithMultipleThreadAsync(url, null);
    }

    /**
     * 多线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadWithMultipleThreadAsync(String url, File outputFile) {
        downloadWithMultipleThreadAsync(url, outputFile, null);
    }

    /**
     * 多线程下载
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadWithMultipleThreadAsync(String url, File outputFile, Map<String, String> header) {
        downloadWithMultipleThreadAsync(url, outputFile, header, null);
    }

    /**
     * 多线程下载
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadWithMultipleThreadAsync(String url, File outputFile, Map<String, String> header,
                                                       DownloadListener downloadListener) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        new MultipleThreadDownload(header, downloadListener).download(url, outputFile);
    }

    // ===================响应流异步下载======================

    /**
     * 下载响应流
     *
     * @param url 下载链接
     */
    public static void downloadResponseStreamAsync(String url) {
        downloadResponseStreamAsync(url, null);
    }

    /**
     * 下载响应流
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     */
    public static void downloadResponseStreamAsync(String url, File outputFile) {
        downloadResponseStreamAsync(url, outputFile, null);
    }

    /**
     * 下载响应流
     *
     * @param url        下载链接
     * @param outputFile 文件输出位置
     * @param header     请求头
     */
    public static void downloadResponseStreamAsync(String url, File outputFile, Map<String, String> header) {
        downloadResponseStreamAsync(url, outputFile, header, null);
    }

    /**
     * 下载响应流
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     */
    public static void downloadResponseStreamAsync(String url, File outputFile, Map<String, String> header,
                                                   DownloadListener downloadListener) {
        downloadResponseStreamAsync(url, outputFile, header, downloadListener, false);
    }

    /**
     * 下载响应流
     *
     * @param url              下载链接
     * @param outputFile       文件输出位置
     * @param header           请求头
     * @param downloadListener 下载监听
     * @param isAppend         是否在原来的文件上追加下载
     */
    public static void downloadResponseStreamAsync(String url, File outputFile, Map<String, String> header,
                                                   DownloadListener downloadListener, boolean isAppend) {
        if (!StringUtils.isNotEmpty(url)) return;
        if (outputFile == null) outputFile = new File(DEFAULT_PATH + Commons.getFileName(url));
        if (header == null) header = getDefaultHeader(url);
        ResponseStreamDownload responseStreamDownload = new ResponseStreamDownload(header, downloadListener);
        if (isAppend) {
            responseStreamDownload.downloadAppendToFile(url, outputFile);
        } else {
            responseStreamDownload.download(url, outputFile);
        }
    }

    /**
     * 获取默认的请求头 OK
     *
     * @param url 链接地址
     * @return 默认请求头
     */
    private static HashMap<String, String> getDefaultHeader(String url) {
        HashMap<String, String> header = new HashMap<>();
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        header.put("Referer", url);
        header.put("Connection", "keep-alive");
        try {
            header.put("Host", new URL("http://www.baidu.com").getHost());
        } catch (MalformedURLException ignored) {
        }
        return header;
    }

    /**
     * 获取同步的监听器
     *
     * @param countDownLatch   闭锁
     * @param downloadListener 用户的下载监听器
     * @return 同步的下载监听器
     */
    private static DownloadListener getSyncDownloadListener(CountDownLatch countDownLatch, DownloadListener downloadListener) {
        return new DownloadListener() {
            @Override
            public void connecting(String url, long lastDownloadSize) {
                if (downloadListener != null) downloadListener.connecting(url, lastDownloadSize);
            }

            @Override
            public void start(long contentLength) {
                if (downloadListener != null) downloadListener.start(contentLength);
            }

            @Override
            public void downloading(double currentProcess, double currentSpeed, long remainingTime) {
                if (downloadListener != null) downloadListener.downloading(currentProcess, currentSpeed, remainingTime);
            }

            @Override
            public void over(long totalDownloadTime, double avgSpeed) {
                if (downloadListener != null) downloadListener.over(totalDownloadTime, avgSpeed);
                countDownLatch.countDown();
            }

            @Override
            public void downloadError(int responseCode, Exception e) {
                if (downloadListener != null) downloadListener.downloadError(responseCode, e);
                countDownLatch.countDown();
            }
        };
    }
}
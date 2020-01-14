package bilibili.download.downloader;

import bilibili.data.BaseData;
import bilibili.download.BiliBiliDownloadService;
import bilibili.download.download_list.download_item.AudioDownloadItem;
import bilibili.download.download_list.download_item.DownloadItem;
import util.FileUtils;
import util.StringUtils;
import util.TimeUtils;
import util.download.DownloadListener;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class AudioDownloader {

    public static void download(DownloadItem downloadItem) {
        AudioDownloadItem audioDownloadItem = (AudioDownloadItem) downloadItem;
        // 备份地址下标控制
        AtomicInteger backUpIndex = new AtomicInteger(0);
        // 获取备用的URL
        String[] audioUrls = audioDownloadItem.audioUrl;
        if (audioUrls == null || audioUrls.length < 1) return;
        // 数字格式化
        DecimalFormat percentFormat = new DecimalFormat("0.00");
        // 下载一段视频
        BiliBiliDownloadService.download(
                audioUrls[0],
                audioDownloadItem.musicOutputFile,
                new DownloadListener() {
                    @Override
                    public void connecting(String url, long lastDownloadSize) {
                        System.out.println("连接中: " + url + ", 上次已下载" + FileUtils.fileLength(lastDownloadSize));
                    }

                    @Override
                    public void start(long contentLength) {
                        System.out.println("下载已经开始, 文件大小为: " + FileUtils.fileLength(contentLength));
                    }

                    @Override
                    public void downloading(double currentProcess, double currentSpeed, long remainingTime) {
                        System.out.println("下载中, 当前进度: " + percentFormat.format(currentProcess * 100) +
                                "%, 速度为: " + FileUtils.fileLength(currentSpeed) + "/S, 剩余时长" +
                                TimeUtils.timeFormat(remainingTime));
                    }

                    @Override
                    public void over(long totalDownloadTime, double avgSpeed) {
                        System.out.println("下载完成...耗时：" + TimeUtils.timeFormat(totalDownloadTime) +
                                ", 平均速度为: " + FileUtils.fileLength(avgSpeed) + "/S");
                    }

                    @Override
                    public void downloadError(int responseCode, Exception exception) {
                        System.out.println("下载异常...响应码为：" + responseCode +
                                ", 异常信息: " + exception.getMessage() + "正在尝试备用链接");
                        if (backUpIndex.incrementAndGet() < audioUrls.length) {
                            BiliBiliDownloadService.download(
                                    audioUrls[backUpIndex.get()],
                                    audioDownloadItem.musicOutputFile,
                                    this
                            );
                        }
                    }
                }
        );

        if (!BaseData.isDownloadLrc ||
                audioDownloadItem.lrcOutputFile == null ||
                !StringUtils.isNotEmpty(audioDownloadItem.lrcUrl)
        ) return;

        BiliBiliDownloadService.download(
                audioDownloadItem.lrcUrl,
                audioDownloadItem.lrcOutputFile,
                null
        );
    }
}

package bilibili.download.downloader;

import bilibili.download.BiliBiliDownloadService;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.download_list.download_item.LiveDownloadItem;
import bilibili.download.enums.VideoType;
import util.FileUtils;
import util.StringUtils;
import util.TimeUtils;
import util.download.DownloadListener;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 直播下载器
 * <p>
 * Todo 当live_status = 1的时候是直播
 * Todo 当live_status = 2的时候是轮播
 * Todo 当live_status = 0的时候是主播不在
 * Todo 该类还有一种轮播的情况，已经获取到接口https://api.live.bilibili.com/live/getRoundPlayVideo?room_id=13566&a=1563122188621&type=flv
 *
 * @author CY
 */
public class LiveDownloader {

    public static void download(DownloadItem downloadItem) {

        LiveDownloadItem liveDownloadItem = (LiveDownloadItem) downloadItem;
        if (liveDownloadItem.videoType == VideoType.LIVE_PLAY) {
            downloadLivePlay(liveDownloadItem);
        } else if (liveDownloadItem.videoType == VideoType.ROUND_PLAY) {
            downloadRoundPlay(liveDownloadItem);
        }
    }


    /**
     * 下载轮播
     *
     * @param liveDownloadItem 下载项
     */
    private static void downloadRoundPlay(LiveDownloadItem liveDownloadItem) {
        // 获取备用的URL
        String videoUrl = liveDownloadItem.videoUrl;
        if (!StringUtils.isNotEmpty(videoUrl)) return;
        // 数字格式化
        DecimalFormat percentFormat = new DecimalFormat("0.00");
        // 下载一段视频
        BiliBiliDownloadService.download(
                videoUrl,
                liveDownloadItem.outputFile,
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
                    }
                }
        );
    }

    /**
     * 下载直播
     *
     * @param liveDownloadItem 下载项
     */
    private static void downloadLivePlay(LiveDownloadItem liveDownloadItem) {
        // 备份地址下标控制
        AtomicInteger backUpIndex = new AtomicInteger(0);
        // 获取备用的URL
        List<String> liveUrls = liveDownloadItem.liveUrls;
        if (liveUrls == null || liveUrls.size() < 1) return;
        // 数字格式化
        DecimalFormat percentFormat = new DecimalFormat("0.00");
        // 下载一段视频
        BiliBiliDownloadService.download(
                liveUrls.get(0),
                liveDownloadItem.outputFile,
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
                                "平均速度为: " + FileUtils.fileLength(avgSpeed) + "/S");
                    }

                    @Override
                    public void downloadError(int responseCode, Exception exception) {
                        System.out.println("下载异常...响应码为：" + responseCode +
                                ", 异常信息: " + exception.getMessage() + "正在尝试备用链接");
                        if (backUpIndex.incrementAndGet() < liveUrls.size()) {
                            BiliBiliDownloadService.download(
                                    liveUrls.get(backUpIndex.get()),
                                    liveDownloadItem.outputFile,
                                    this
                            );
                        }
                    }
                }
        );

    }
}

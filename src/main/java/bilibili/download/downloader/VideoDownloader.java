package bilibili.download.downloader;

import bilibili.data.BaseData;
import bilibili.download.BiliBiliDownloadService;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.download_list.download_item.VideoDownloadItem;
import bilibili.download.enums.VideoType;
import ffmpeg.FFMpegUtils;
import ffmpeg.listener.FFMpegListener;
import util.FileUtils;
import util.StringUtils;
import util.TimeUtils;
import util.download.DownloadListener;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoDownloader {

    public static void download(DownloadItem downloadItem) {
        VideoDownloadItem videoDownloadItem = (VideoDownloadItem) downloadItem;

        if (videoDownloadItem.videoType == VideoType.DASH) {
            downloadDashVideo(videoDownloadItem);
        } else if (videoDownloadItem.videoType == VideoType.DURL) {
            downloadDurlVideo(videoDownloadItem);
        }
    }

    /**
     * 下载Dash视频
     *
     * @param downloadItem 下载项
     */
    @SuppressWarnings("all")
    private static void downloadDashVideo(VideoDownloadItem downloadItem) {
        File outputFile = downloadItem.outputFile;
        String videoUrl = downloadItem.videoUrl;
        String[] videoBackUpUrls = downloadItem.videoBackUpUrls;
        String audioUrl = downloadItem.audioUrl;
        String[] audioBackUpUrls = downloadItem.audioBackUpUrls;
        File videoTempFile = new File(BaseData.APP_TEMP_FILE_PATH + StringUtils.md5(videoUrl) + BaseData.VIDEO_EXTENSION);
        File audioTempFile = new File(BaseData.APP_TEMP_FILE_PATH + StringUtils.md5(audioUrl) + BaseData.AUDIO_EXTENSION);
        downloading(videoUrl, videoBackUpUrls, videoTempFile);
        downloading(audioUrl, audioBackUpUrls, audioTempFile);

        try {
            FFMpegUtils.mergeVideoAndAudio(
                    videoTempFile,
                    audioTempFile,
                    outputFile,
                    new FFMpegListener() {
                        @Override
                        public void over() {
                            System.out.println("合并完成");
                            new Thread(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                videoTempFile.delete();
                                audioTempFile.delete();
                            }).start();
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloading(String url, String[] backUpUrls, File outputFile) {
        // 备份地址下标控制
        AtomicInteger backUpIndex = new AtomicInteger(0);
        // 数字格式化
        DecimalFormat percentFormat = new DecimalFormat("0.00");
        // 下载一段视频
        BiliBiliDownloadService.download(
                url,
                outputFile,
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
                        if (backUpUrls != null && backUpIndex.incrementAndGet() < backUpUrls.length) {
                            BiliBiliDownloadService.download(
                                    backUpUrls[backUpIndex.get()],
                                    outputFile,
                                    this
                            );
                        }
                    }
                }
        );
    }


    /**
     * 下载Durl视频
     *
     * @param downloadItem 下载项
     */
    @SuppressWarnings("all")
    private static void downloadDurlVideo(VideoDownloadItem downloadItem) {
        List<String> flvUrls = downloadItem.flvUrls;
        List<String[]> flvBackUpUrls = downloadItem.flvBackUpUrls;
        List<File> tempFiles = new ArrayList<>();
        for (int i = 0; i < flvUrls.size(); i++) {
            String url = flvUrls.get(i);
            String[] backUpUrl = flvBackUpUrls.get(i);
            File flvTempFile = new File(BaseData.APP_TEMP_FILE_PATH + StringUtils.md5(url) + BaseData.VIDEO_EXTENSION);
            tempFiles.add(flvTempFile);
            downloading(
                    url,
                    backUpUrl,
                    flvTempFile
            );
        }

        try {
            FFMpegUtils.mergeVideo(
                    tempFiles,
                    downloadItem.outputFile,
                    new FFMpegListener() {
                        @Override
                        public void over() {
                            System.out.println("合并完成");
                            new Thread(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                for (File tempFile : tempFiles) {
                                    tempFile.delete();
                                }
                            }).start();
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

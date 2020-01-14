package util.download;

import bilibili.data.BaseData;
import util.FileUtils;
import util.TimeUtils;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * 下载工具的测试类，与该程序无关
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, String> header = new HashMap<>();
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        header.put("Origin", BaseData.HOME_URL);
        header.put("Referer", BaseData.HOME_URL);
        header.put("SESSDATA", BaseData.sessionData);
        header.put("CURRENT_QUALITY", BaseData.currentQuality);
        DownloadUtils.downloadWithMultipleThreadAsync("http://cn-hbcd2-cu-v-12.acgvideo.com/upgcxcode/68/91/102779168/102779168_nb2-1-30280.m4s?expires=1564845600&platform=pc&ssig=ECZtF4f-sWRr7uOPgCbZpg&oi=1021207738&trid=95c49db8f1b8467188e5c3595bde12b2u&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1",
                null,
                header,
                new DownloadListener() {
                    DecimalFormat percentFormat = new DecimalFormat("0.00");

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
                        System.out.println("下载中, 当前进度: " +
                                percentFormat.format(currentProcess * 100) +
                                "%, 速度为: " + FileUtils.fileLength(currentSpeed) + "/S, 剩余时间为: " + TimeUtils.timeFormat(remainingTime));
                    }

                    @Override
                    public void over(long totalDownloadTime, double avgSpeed) {
                        System.out.println("下载完成...耗时: " + TimeUtils.timeFormat(totalDownloadTime) + ", 平均速度为: " + FileUtils.fileLength(avgSpeed) + "/S");
                    }

                    @Override
                    public void downloadError(int responseCode, Exception exception) {
                        System.out.println("下载异常...响应码为：" + responseCode +
                                ", 异常信息: " + exception.getMessage());
                    }
                });
    }
}

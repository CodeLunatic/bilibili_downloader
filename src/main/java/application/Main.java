package application;

import bilibili.BiliBiliDownloader;
import bilibili.data.BaseData;
import util.download.DownloadListener;
import util.download.DownloadUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 程序的入口
 * 2019年7月15日
 * Todo 当前程序可用，仅此而已
 * Todo 需要改进的耗时操作
 * Todo 1、获取下载列表的时候耗时
 * Todo 2、下载批量文件的时候耗时
 * Todo 3、下载DASH的时候先下载视频，再下载音频，耗时
 * Todo 4、下载FLV的时候一个一个下载耗时
 */
public class Main {

    /**
     * 程序的数据目录
     */
    private static final String APP_DATA_PATH = System.getProperty("user.home") +
            File.separator + "AppData" + File.separator + "Local" + File.separator +
            "CySoftware" + File.separator;

    /**
     * 程序的Commons目录
     */
    private static final String COMMONS_PATH = APP_DATA_PATH + "Commons" + File.separator;

    /**
     * FFMpeg的下载路径
     */
    private static final File FFMPEG_ZIP = new File(COMMONS_PATH + "ffmpeg.zip");


    /**
     * FFMPEG EXE路径
     */
    private static final File FFMPEG = new File(COMMONS_PATH + "ffmpeg.exe");

    /**
     * FFMPEG的下载地址（官方太慢，所以使用了第三方）
     */
    private static final String FFMPEG_URL = "https://dl-sh-ctc-2.pchome.net/3v/xm/ffmpeg-20180723-d134b8d-win64-static.zip?key=bb6113725faaa40066b5618feb04b12c&tmp=" + System.currentTimeMillis();

    /**
     * 开始下载
     *
     * @param args 程序入口函数
     */
    public static void main(String[] args) {
        if (!FFMPEG.exists()) {
            System.out.println("初次使用程序，正在下载FFMpeg...");
            downloadFFMpeg();
        }
        try {
            commandLine(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("暂不支持下载该链接");
        }
    }

    /**
     * 下载FFMpeg OK
     */
    private static void downloadFFMpeg() {
        DownloadUtils.downloadWithMultipleThreadSync(
                FFMPEG_URL,
                FFMPEG_ZIP,
                null,
                new DownloadListener() {
                    @Override
                    @SuppressWarnings("all")
                    public void over(long totalDownloadTime, double avgSpeed) {
                        unZip(FFMPEG_ZIP, FFMPEG, "ffmpeg.exe");
                        FFMPEG_ZIP.delete();
                    }
                }
        );
    }


    /**
     * 解压文件中的指定文件到指定目录中 OK
     *
     * @param zipFile    压缩文件
     * @param outputFile 输出路径
     * @param fileName   文件名
     * @throws IOException #
     */
    @SuppressWarnings("all")
    private static void unZip(File zipFile, File outputFile, String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(zipFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ZipInputStream input = new ZipInputStream(bufferedInputStream);
            OutputStream output = new FileOutputStream(outputFile);
            ZipEntry zipEntry;
            while ((zipEntry = input.getNextEntry()) != null) {
                if (zipEntry.getName().contains(fileName)) {
                    byte[] buffer = new byte[1024 * 4];
                    int len;
                    while ((len = input.read(buffer)) != -1) {
                        output.write(buffer, 0, len);
                    }
                    output.close();
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 命令行控制
     */
    private static void commandLine(String[] args) throws Exception {
        if (checkParam(args)) return; // 检查参数
        BaseData.url = args[0]; // 开始下载
        BiliBiliDownloader.startDownload(BaseData.url);
    }

    /**
     * 检查参数
     *
     * @param args 用户参数
     * @return 是否成功
     */
    private static boolean checkParam(String[] args) {
        if (args.length < 1) {
            System.err.println("缺少URL，例如：https://www.bilibili.com/video/av39718511");
            return true;
        }
        if (!args[0].contains("bilibili.com")) {
            System.out.println("连接地址必须是BiliBili的地址");
            System.out.println("例如：https://www.bilibili.com/video/av39718511");
            return true;
        }
        try {
            new URL(args[0]);
        } catch (MalformedURLException e) {
            System.err.println("非法的URL格式, 参考：协议://用户名:密码@子域名.域名.顶级域名:端口号/目录/文件名.文件后缀?参数=值#标志");
            return true;
        }
        return false;
    }
}

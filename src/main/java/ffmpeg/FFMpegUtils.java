package ffmpeg;

import ffmpeg.command.FFMpegCommand;
import ffmpeg.listener.FFMpegListener;
import util.FileUtils;
import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FFMpeg工具类
 * 注意：在电脑性能依然不可能同时处理规定个数视频合并的今天
 * 请务必要加上synchronized关键字，否则后造成电脑卡爆的情况
 *
 * @author CY
 */
public class FFMpegUtils {

    /**
     * 解析M3U8下载视频
     * 【不会产生临时文件】
     *
     * @param m3u8URL    M3U8的URL可以是File
     * @param outputFile 输出的路径
     * @param listener   监听器
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static void downloadM3U8(String m3u8URL, File outputFile, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        // 判断参数是否正确
        if (!StringUtils.isNotEmpty(m3u8URL) || outputFile == null) throw new IllegalArgumentException("参数异常!");
        // 先删除后下载
        if (outputFile.exists()) outputFile.delete();
        // 建立目标文件夹
        FileUtils.mkdirs(outputFile);
        // 获取命令
        List<String> downloadM3U8Command = FFMpegCommand.getDownloadM3U8Command(m3u8URL, outputFile);
        // 执行命令
        executeCommand(listener, downloadM3U8Command);
    }

    /**
     * 合并视频和音频
     * 【源文件不会被删除】
     *
     * @param videoFile  视频文件
     * @param audioFile  音频文件
     * @param outputFile 输出文件
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static void mergeVideoAndAudio(File videoFile, File audioFile, File outputFile, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        // 检查参数
        if (videoFile == null || audioFile == null || outputFile == null) throw new IllegalArgumentException("参数异常!");
        // 先删除后下载
        if (outputFile.exists()) outputFile.delete();
        // 建立目标文件夹
        FileUtils.mkdirs(outputFile);
        // 获取命令
        List<String> mergeVideoAndAudioCommand = FFMpegCommand.getMergeVideoAndAudioCommand(videoFile, audioFile, outputFile);
        // 执行命令
        executeCommand(listener, mergeVideoAndAudioCommand);
    }

    /**
     * 合并多个视频文件到一个视频文件中（这个方法只支持TS或者FLV的合并，所以合并之前一定要先转换为TS或FLV文件）
     * 【源文件不会被删除】
     *
     * @param videos     视频文件列表
     * @param outputFile 文件输出位置
     * @param listener   监听器
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static void mergeTSVideo(List<File> videos, File outputFile, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        // 检查参数
        if (videos == null || videos.size() == 0 || outputFile == null) throw new IllegalArgumentException("参数异常!");
        // 先删除后下载
        if (outputFile.exists()) outputFile.delete();
        // 建立目标文件夹
        FileUtils.mkdirs(outputFile);
        // 获取命令
        List<String> mergeVideoCommand = FFMpegCommand.getMergeTSVideoCommand(videos, outputFile);
        // 执行命令
        executeCommand(listener, mergeVideoCommand);
    }

    /**
     * 合并视频文件
     * 【会产生大量ts文件，合并成功后会自动删除】
     *
     * @param videos     视频文件列表
     * @param outputFile 文件输出的位置
     * @param listener   监听器
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static void mergeVideo(List<File> videos, File outputFile, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        // 检查参数
        if (videos == null || videos.size() == 0 || outputFile == null) throw new IllegalArgumentException("参数异常!");
        // 先删除后下载
        if (outputFile.exists()) outputFile.delete();
        // 建立目标文件夹
        FileUtils.mkdirs(outputFile);
        // 转换原来的文件格式为TS
        ArrayList<File> files = convertVideoToTS(videos, new FFMpegListener() {

            @Override
            public void commandLine(String line) {
                if (listener != null) listener.commandLine(line);
            }

            @Override
            public void over() {
                if (listener != null) listener.commandLine("已经将所有的视频文件转换为TS文件");
            }
        });
        // 合并文件
        mergeTSVideo(files, outputFile, listener);
        // 删除合并文件临时产生的TS文件
        deleteTempFile(files);
    }

    /**
     * 转换视频文件到TS格式
     * 【支持单文件的转换】
     *
     * @param video      视频文件
     * @param outputFile 输出路径
     * @param listener   监听器
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static void convertVideoToTs(File video, File outputFile, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        // 检查参数
        if (video == null || outputFile == null) throw new IllegalArgumentException("参数异常!");
        // 先删除后下载
        if (outputFile.exists()) outputFile.delete();
        // 建立目标文件夹
        FileUtils.mkdirs(outputFile);
        // 获取命令
        List<String> convertVideoToTSCommand = FFMpegCommand.getConvertVideoToTSCommand(video, outputFile);
        // 执行命令
        executeCommand(listener, convertVideoToTSCommand);
    }

    /**
     * 将视频文件转换为TS文件
     * 【支持多文件的转换】
     *
     * @param videos 视频文件列表
     * @throws IOException #
     */
    @SuppressWarnings("all")
    public synchronized static ArrayList<File> convertVideoToTS(List<File> videos, FFMpegListener listener) throws IOException {
        if (listener != null) listener.start();
        ArrayList<File> newFiles = new ArrayList<>(); // 用来存放已经被转换完成的文件
        for (File video : videos) {
            String fileName = video.getName();
            String extensionName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
            if (".ts".equalsIgnoreCase(extensionName)) continue; // 如果文件列表中存在ts后缀的文件，就跳过该文件
            File newFile = new File(video.getAbsolutePath().replaceAll(extensionName, ".ts"));
            newFiles.add(newFile);
            if (newFile.exists()) newFile.delete(); // 如果原来就存在ts文件则删除
            convertVideoToTs(video, newFile, new FFMpegListener() {
                @Override
                public void start() {
                    if (listener != null) listener.commandLine(video.getAbsolutePath() + "开始转换!");
                }

                @Override
                public void commandLine(String line) {
                    if (listener != null) listener.commandLine(line);
                }

                @Override
                public void over() {
                    if (listener != null) listener.commandLine(video.getAbsolutePath() + "转换结束!");
                }
            });
        }
        if (listener != null) listener.over();
        return newFiles;
    }

    /**
     * 执行命令
     *
     * @param listener 监听器
     * @param commands 命令
     * @throws IOException #
     */
    private synchronized static void executeCommand(FFMpegListener listener, List<String> commands) throws IOException {
        // 获取控制台实时内容
        Scanner scanner = getScannerByCommand(commands);
        // 打印控制台的回调
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (listener != null) listener.commandLine(line);
        }
        // 关流
        scanner.close();
        // 下载结束回调
        if (listener != null) listener.over();
    }

    /**
     * 通过要执行的命令得到Scanner对象
     *
     * @param command 命令
     * @return Scanner对象
     * @throws IOException #
     */
    private static Scanner getScannerByCommand(List<String> command) throws IOException {
        return new Scanner(new ProcessBuilder(command).redirectErrorStream(true).start().getInputStream(), "GBK");
    }

    /**
     * 删除产生的临时文件
     *
     * @param files 文件列表
     */
    @SuppressWarnings("all")
    private static void deleteTempFile(List<File> files) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (File file : files) if (file.exists()) file.delete();
        }).start();
    }
}
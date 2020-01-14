package ffmpeg.command;


import util.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 产生FFMpeg的命令
 *
 * @author CY
 */
public class FFMpegCommand {

    /**
     * ffmpeg所在的路径 Todo
     */
    private static final String PATH = System.getProperty("user.home") +
            File.separator + "AppData" + File.separator + "Local" + File.separator +
            "CySoftware" + File.separator + "Commons" + File.separator + "ffmpeg.exe";

    /**
     * 音频和视频文件合并在一起的命令
     *
     * @param videoFile  视频文件
     * @param audioFile  音频文件
     * @param outputFile 输出文件
     * @return 命令
     */
    public static List<String> getMergeVideoAndAudioCommand(File videoFile, File audioFile, File outputFile) {
        ArrayList<String> command = new ArrayList<String>();
        command.add(PATH);
        command.add("-i");
        command.add("\"" + videoFile.getAbsolutePath() + "\"");
        command.add("-i");
        command.add("\"" + audioFile.getAbsolutePath() + "\"");
        command.add("-c:v");
        command.add("copy");
        command.add("-c:a");
        command.add("aac");
        command.add("-strict");
        command.add("experimental");
        command.add("-map");
        command.add("0:v:0?");
        command.add("-map");
        command.add("1:a:0?");
        command.add("\"" + outputFile.getAbsolutePath() + "\"");
        return command;
    }

    /**
     * 下载M3U8文件到视频的命令
     *
     * @return 命令
     */
    public static List<String> getDownloadM3U8Command(String m3u8URL, File outputFile) {
        ArrayList<String> command = new ArrayList<String>();
        command.add(PATH);
        command.add("-allowed_extensions");
        command.add("ALL");
        command.add("-protocol_whitelist");
        command.add("\"file,http,https,rtp,udp,tcp,tls,crypto\"");
        command.add("-i");
        command.add("\"" + m3u8URL + "\"");
        command.add("-c");
        command.add("copy");
        command.add("\"" + outputFile.getAbsolutePath() + "\"");
        return command;
    }

    /**
     * 合并视频文件命令（该命令使用了concat的方式，所以只能合并TS文件）
     *
     * @return 命令
     */
    public static List<String> getMergeTSVideoCommand(List<File> videos, File outputFile) {
        ArrayList<String> command = new ArrayList<String>();
        command.add(PATH);
        command.add("-i");
        command.add("\"concat:" + CollectionUtils.join(videos, "|") + "\"");
        command.add("-c");
        command.add("copy");
        command.add("-bsf:a");
        command.add("aac_adtstoasc");
        command.add("\"" + outputFile.getAbsolutePath() + "\"");
        return command;
    }

    /**
     * 将视频转为TS格式的命令
     *
     * @return 命令
     */
    public static List<String> getConvertVideoToTSCommand(File video, File outputFile) {
        ArrayList<String> command = new ArrayList<>();
        command.add(PATH);
        command.add("-i");
        command.add("\"" + video.getAbsolutePath() + "\"");
        command.add("-vcodec");
        command.add("copy");
        command.add("-acodec");
        command.add("copy");
        command.add("-vbsf");
        command.add("h264_mp4toannexb");
        String outputPath = outputFile.getAbsolutePath();
        String extension = outputPath.substring(outputPath.lastIndexOf("."));
        command.add("\"" + (extension.equalsIgnoreCase(".ts") ? outputPath : outputPath.replaceAll(extension, ".ts")) + "\"");
        return command;
    }
}
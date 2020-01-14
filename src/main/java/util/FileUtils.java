package util;

import java.io.File;
import java.text.DecimalFormat;

public class FileUtils {

    /**
     * 可读性好的文件大小
     *
     * @param fileLength 文件大小为 单位B
     * @return 可读性好的文件的大小（字符串）
     */
    public static String fileLength(double fileLength) {
        // 存储单位
        String[] units = {"KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB", "BB", "NB", "DB", "CB", "XB"};
        for (String unit : units) {
            if (fileLength < 1024) return (int) fileLength + "B"; // 如果文件小于1024
            if ((fileLength /= 1024) < 1024) // 如果大于等于1KB
                return new DecimalFormat("#.##").format(fileLength) + unit;
        }
        throw new IllegalArgumentException("存储空间格式化异常，传入的数字过大!");
    }

    /**
     * 得到可用的文件名（通用性一般不包含特殊的字符，因为范围广，并且太复杂 比如说\U000E字符）
     *
     * @param fileName 文件名
     * @return 可用的文件名
     */
    public static String getPrettyFileName(String fileName) {
        if (fileName == null) return "临时文件名"; // 无文件名
        if (fileName.length() > 255) return fileName.substring(0, 10); // 裁剪一部分文件名
        if (!fileName.matches("[^\\s\\\\/:*?\"<>|](\\x20|[^\\s\\\\/:*?\"<>|])*[^\\s\\\\/:*?\"<>|.]$")) // 文件名合法验证
            return fileName.replaceAll("[\\\\/:*?\"<>|]", ""); // 替换文件名中非法字符
        return fileName; // 原文件名
    }

    /**
     * 创建目录
     *
     * @param file 文件
     */
    @SuppressWarnings("all")
    public static void mkdirs(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }
}
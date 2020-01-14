package util.download;

import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 下载工具的公共参数和方法
 * 2019年7月13日
 */
class Commons {

    /**
     * 设置多线程一段的尺寸，单位: M
     */
    static final double SEGMENT_SIZE = 20;

    /**
     * 下载失败后的重试次数
     */
    static final int RETRY_NUM = 5;

    /**
     * 默认buffer尺寸, 单位 byte
     */
    static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    /**
     * 文件的结尾
     */
    static final int EOF = -1;

    /**
     * 多线程下载允许使用的最大线程数量
     */
    static final int MAX_THREAD = 5;

    /**
     * 断点文件的后缀名
     */
    private static final String BREAK_POINT_FILE_EXTENSION = ".cfg";

    /**
     * 获取文件名
     *
     * @param url 下载链接
     * @return 文件【文件名自动获取，文件保存在运行路径】
     * @deprecated TODO 此方法不健壮，暂不推荐使用
     */
    @Deprecated
    static String getFileName(String url) {
        if (!StringUtils.isNotEmpty(url)) return "未知文件.unknown";
        try {
            URL urlObj = new URL(url);
            // 使用响应头中的文件名
            String fileName = urlObj.openConnection().getHeaderField("Content-Disposition");
            if (fileName != null && !"".equals(fileName.trim()) && fileName.contains("filename")) {
                fileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                if (fileName.contains("\"")) {
                    fileName = fileName.substring(fileName.indexOf('"') + 1, fileName.length() - 1);
                } else {
                    String prefix = "filename=";
                    fileName = fileName.substring(fileName.indexOf(prefix) + prefix.length());
                }
            } else {
                // 使用URL中的文件名
                fileName = URLDecoder.decode(new File(urlObj.getPath()).getName(), "UTF-8");
            }
            return getPrettyFileName(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "未知文件.unknown";
    }

    /**
     * 得到可用的文件名（通用性一般不包含特殊的字符，因为范围广，并且太复杂 比如说\U000E字符）
     *
     * @param fileName 文件名
     * @return 可用的文件名
     */
    private static String getPrettyFileName(String fileName) {
        if (fileName == null) return "临时文件名"; // 无文件名
        if (fileName.length() > 255) return fileName.substring(0, 10); // 裁剪一部分文件名
        if (!fileName.matches("[^\\s\\\\/:*?\"<>|](\\x20|[^\\s\\\\/:*?\"<>|])*[^\\s\\\\/:*?\"<>|.]$")) // 文件名合法验证
            return fileName.replaceAll("[\\\\/:*?\"<>|]", ""); // 替换文件名中非法字符
        return fileName; // 原文件名
    }

    /**
     * 得到临时断点文件路径
     *
     * @param outputFile 源文件路径
     * @return 临时断点文件路径
     */
    static File getBreakPointFile(File outputFile) {
        return new File(outputFile.getAbsolutePath() + BREAK_POINT_FILE_EXTENSION);
    }

    /**
     * 将URL字符串转换成HttpURLConnection对象 OK
     *
     * @param url    URL字符串
     * @param header 请求头
     * @return URLConnection对象
     * @throws IOException 异常
     */
    static HttpURLConnection getHttpUrlConnection(String url,
                                                  Map<String, String> header) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        if (header != null) header.forEach(urlConnection::setRequestProperty);
        return urlConnection;
    }

    /**
     * 新建一个文件夹
     *
     * @param file 文件目录
     */
    @SuppressWarnings("all")
    static void mkdirs(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }
}
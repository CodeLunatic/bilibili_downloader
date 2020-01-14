package bilibili.util;

import bilibili.data.BaseData;
import util.StringUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载器的公用方法类
 * 2019年7月15日
 */
public class CommonsUtils {

    /**
     * 根据URL得到一个临时文件路径 OK
     * 比如说：工作空间\temp\c62c993436debd0a68494ca78c860336.mp4
     *
     * @param url       URL
     * @param extension 扩展名
     * @return 文件名
     */
    public static File getTempFilePathByUrl(String url, String extension) {
        // 临时文件路径
        String tempFilePath = BaseData.path + "temp" + File.separator;
        try {
            // 具体的临时文件名算法，使用该下载链接的唯一标识的MD5值
            tempFilePath += StringUtils.md5(new URL(url).getPath());
        } catch (MalformedURLException e) {
            // 如果上面出现了异常则备用随机的UUID
            tempFilePath += StringUtils.getUUID();
        }
        if (!extension.startsWith(".")) extension = "." + extension;
        return new File(tempFilePath + extension);
    }

    /**
     * 获取播放的ID OK
     *
     * @param prefix 播放的类型比如说：av,ep,如果是直播或小视频传入参数"/"
     * @return 播放ID
     */
    public static String getPlayId(String url, String prefix) {
        // 获取视频的aid
        String path;
        try {
            path = new URL(url).getPath();
        } catch (MalformedURLException e) {
            return null;
        }
        // 从规定的位置开始截取
        String aid = path.substring(path.lastIndexOf(prefix) + prefix.length());
        // 去掉最后的 /
        if (aid.endsWith("/")) {
            aid = aid.substring(0, aid.length() - 1);
        }
        return aid;
    }
}

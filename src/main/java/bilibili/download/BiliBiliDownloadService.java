package bilibili.download;

import bilibili.data.BaseData;
import util.download.DownloadListener;
import util.download.DownloadUtils;

import java.io.File;
import java.util.HashMap;

/**
 * BiliBili的下载工具类
 */
public class BiliBiliDownloadService {

    /**
     * BiliBili下载需要使用到的请求头
     */
    private static final HashMap<String, String> header = new HashMap<>();

    static {
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        header.put("Origin", BaseData.HOME_URL);
        header.put("Referer", BaseData.url);
        header.put("SESSDATA", BaseData.sessionData);
        header.put("CURRENT_QUALITY", BaseData.currentQuality);
    }

    /**
     * 下载普通的BiliBili内容
     *
     * @param url              URL
     * @param downloadListener 下载监听器
     */
    public static void download(String url, File outputFile, DownloadListener downloadListener) {
        DownloadUtils.downloadWithMultipleThreadSync(url, outputFile, header, downloadListener);
    }
}

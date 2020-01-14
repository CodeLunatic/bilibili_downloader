package bilibili.util;

import bilibili.data.BaseData;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * 做连接B站的HTTP操作
 * B站的所有的连接必须使用Referer=https://xxx.bilibili.com/xxxx
 * 否则大部分情况下不能进行访问
 * 2019年7月15日
 */
public class HttpUtils {

    /**
     * 获取URL对应的JSON
     *
     * @param urlString URL
     * @return JSON字符串
     * @throws IOException 异常
     */
    public static String urlJson(String urlString) throws IOException {
        return urlDocument(urlString).text();
    }

    /**
     * 获取URL的HTML
     *
     * @param urlString URL
     * @return HTML
     * @throws IOException 异常
     */
    public static String urlHtml(String urlString) throws IOException {
        return urlDocument(urlString).html();
    }

    /**
     * 访问URL得到Document对象
     * Todo 经过大量的测试，该方法可能会存在一些问题，比如说会把&quot;自动转换成'"'然后造成JSON解析错误
     *
     * @param urlString URL
     * @return Document对象
     * @throws IOException #
     */
    private static Document urlDocument(String urlString) throws IOException {
        Connection connect = Jsoup.connect(urlString).ignoreContentType(true);
        connect.header("Origin", BaseData.HOME_URL);
        connect.header("Referer", BaseData.url);
        connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        connect.cookie("SESSDATA", BaseData.sessionData);
        connect.cookie("CURRENT_QUALITY", BaseData.currentQuality);
        return connect.get();
    }
}

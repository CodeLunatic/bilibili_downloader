package bilibili;

import bilibili.download.download_list.download_item.*;
import bilibili.download.downloader.AudioDownloader;
import bilibili.download.downloader.LiveDownloader;
import bilibili.download.downloader.SmallVideoDownloader;
import bilibili.download.downloader.VideoDownloader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.util.List;

/**
 * BiliBili下载器
 */
public class BiliBiliDownloader {

    /**
     * 使用用户的链接来区分要下载的页面属于什么类型，av，ep等
     * 然后使用对应的下载器进行下载
     *
     * @throws IOException #
     */
    public static void startDownload(String url) throws IOException {
        // 获取下载列表
        List<DownloadItem> downloadList = DownloadListService.getDownloadList(url);
        // 遍历下载列表
        for (DownloadItem downloadItem : downloadList) {
            // 分类下载
            if (downloadItem instanceof SmallVideoDownloadItem) { // 小视频
                SmallVideoDownloader.download(downloadItem);
            } else if (downloadItem instanceof LiveDownloadItem) { // 直播
                LiveDownloader.download(downloadItem);
            } else if (downloadItem instanceof VideoDownloadItem) { // 视频
                VideoDownloader.download(downloadItem);
            } else if (downloadItem instanceof AudioDownloadItem) { // 音频
                AudioDownloader.download(downloadItem);
            } else { // 其他
                throw new IllegalArgumentException("无法下载该URL");
            }
        }
    }
}

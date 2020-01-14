package bilibili;

import bilibili.download.download_list.*;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.downloader.VideoDownloader;
import bilibili.download.enums.DownloadType;

import java.io.IOException;
import java.util.List;

/**
 * 下载列表服务，根据用户输入的URL获取下载列表
 */
public class DownloadListService {

    public static List<DownloadItem> getDownloadList(String url) throws IOException {
        // 下载普通UP主的视频
        if (url.contains(DownloadType.AV.getUrlPrefix())) {
            return VideoDownloadList.getAVDownloadList(url);
        }
        // 下载BiliBili音频去的整张专辑
        if (url.contains(DownloadType.AM.getUrlPrefix())) {
            return AudioDownloadList.getAMDownloadList(url);
        }
        // 下载BiliBili的音频
        if (url.contains(DownloadType.AU.getUrlPrefix())) {
            return AudioDownloadList.getAUDownloadList(url);
        }
        // 下载BiliBili的电视剧，电影，纪录片等
        if (url.contains(DownloadType.EP.getUrlPrefix())) {
            return VideoDownloadList.getEPDownloadList(url);
        }
        // 下载BiliBili的直播
        if (url.contains(DownloadType.LIVE.getUrlPrefix())) {
            return LiveDownloadList.getLiveDownloadList(url);
        }
        // 下载BiliBili的番剧
        if (url.contains(DownloadType.SS.getUrlPrefix())) {
            return VideoDownloadList.getSSDownloadList(url);
        }
        // 下载BiliBili的小视频
        if (url.contains(DownloadType.VC.getUrlPrefix())) {
            return SmallVideoDownloadList.getVCDownloadList(url);
        }
        throw new IllegalArgumentException("暂时不支持该URL");
    }
}

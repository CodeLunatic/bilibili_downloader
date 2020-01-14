package bilibili.download.download_list;

import bilibili.api.LiveApi;
import bilibili.api.model.live.neptune_is_my_waifu.PageLiveUrl;
import bilibili.api.model.live.neptune_is_my_waifu.PlayUrlRes;
import bilibili.api.model.live.neptune_is_my_waifu.RoomInitRes;
import bilibili.data.BaseData;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.download_list.download_item.LiveDownloadItem;
import bilibili.download.enums.VideoType;
import bilibili.util.CommonsUtils;
import util.FileUtils;
import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取直播的下载项
 * @author CY
 */
public class LiveDownloadList {

    /**
     * 根据URL获取直播/轮播的下载链接
     *
     * @param url URL
     * @return 直播/轮播的下载链接列表
     * @throws IOException #
     */
    public static List<DownloadItem> getLiveDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        LiveDownloadItem downloadItem = new LiveDownloadItem();
        // 获取直播间号码
        String liveId = CommonsUtils.getPlayId(url, "/");
        if (!StringUtils.isNotEmpty(liveId) || StringUtils.isNotNumber(liveId)) return new ArrayList<>();
        // 获取直播线路
        downloadItem.liveId = liveId;
        PageLiveUrl liveUrlByLiveId = LiveApi.getLiveUrlByLiveId(liveId);
        RoomInitRes roomInitRes = liveUrlByLiveId.getRoomInitRes();
        // 没有这个直播间!
        if (roomInitRes == null) return new ArrayList<>();
        if (roomInitRes.getData() == null) return new ArrayList<>();
        String liveStatus = roomInitRes.getData().getLiveStatus();
        downloadItem.liveStatus = liveStatus;
        // 主播当前正在思考人生!
        if ("0".equals(liveStatus)) return new ArrayList<>();
        // 获取当前直播的标题
        String title = FileUtils.getPrettyFileName(liveUrlByLiveId.getBaseInfoRes().getData().getTitle());
        downloadItem.title = title;
        // 直播文件存放路径
        downloadItem.outputFile = new File(BaseData.path + title + BaseData.FLV_EXTENSION);
        // 直播
        if ("1".equals(liveStatus)) {
            downloadItem.videoType = VideoType.LIVE_PLAY;
            PlayUrlRes playUrlRes = liveUrlByLiveId.getPlayUrlRes();
            List<bilibili.api.model.live.neptune_is_my_waifu.DurlItem> durl = playUrlRes.getData().getDurl();
            ArrayList<String> liveUrls = new ArrayList<>(); // 直播线路
            for (bilibili.api.model.live.neptune_is_my_waifu.DurlItem durlItem : durl) {
                liveUrls.add(durlItem.getUrl());
            }
            downloadItem.liveUrls = liveUrls;
        }
        // 轮播
        if ("2".equals(liveStatus)) {
            downloadItem.videoType = VideoType.ROUND_PLAY;
            downloadItem.outputFile = new File(BaseData.path + title + BaseData.VIDEO_EXTENSION);
            String roundPlayUrl = LiveApi.getRoundPlayUrl(roomInitRes.getData().getRoomId());
            if (roundPlayUrl == null) return new ArrayList<>();
            downloadItem.videoUrl = roundPlayUrl;
        }
        list.add(downloadItem);
        return list;
    }

    /**
     * 更新下载项中的URL
     *
     * @param downloadItem 下载项
     */
    public static void refreshUrlOfItem(LiveDownloadItem downloadItem) throws IOException {
        PageLiveUrl liveUrlByLiveId = LiveApi.getLiveUrlByLiveId(downloadItem.liveId);
        RoomInitRes roomInitRes = liveUrlByLiveId.getRoomInitRes();
        // 主播当前正在思考人生!
        if ("0".equals(downloadItem.liveStatus)) return;
        // 直播
        if ("1".equals(downloadItem.liveStatus)) {
            PlayUrlRes playUrlRes = liveUrlByLiveId.getPlayUrlRes();
            List<bilibili.api.model.live.neptune_is_my_waifu.DurlItem> durl = playUrlRes.getData().getDurl();
            ArrayList<String> liveUrls = new ArrayList<>(); // 直播线路
            for (bilibili.api.model.live.neptune_is_my_waifu.DurlItem durlItem : durl) {
                liveUrls.add(durlItem.getUrl());
            }
            downloadItem.liveUrls = liveUrls;
        }
        // 轮播
        if ("2".equals(downloadItem.liveStatus)) {
            String roundPlayUrl = LiveApi.getRoundPlayUrl(roomInitRes.getData().getRoomId());
            if (roundPlayUrl == null) return;
            downloadItem.videoUrl = roundPlayUrl;
        }
    }
}

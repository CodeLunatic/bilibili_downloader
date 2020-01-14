package bilibili.download.download_list;

import bilibili.api.VcApi;
import bilibili.api.model.vc.play_detail.Item;
import bilibili.api.model.vc.play_detail.PlayDetail;
import bilibili.data.BaseData;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.download_list.download_item.SmallVideoDownloadItem;
import bilibili.util.CommonsUtils;
import util.FileUtils;
import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类用来获取小视频的下载列表项
 * 封装数据到SmallVideoDownloadItem类中
 * 小视频下载列表服务
 *
 * @author CY
 */
public class SmallVideoDownloadList {

    /**
     * 根据URL获取小视频的下载链接 OK
     *
     * @param url URL
     * @return 小视频的下载链接
     * @throws IOException #
     */
    public static List<DownloadItem> getVCDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        SmallVideoDownloadItem downloadItem = new SmallVideoDownloadItem();
        // 获取小视频ID
        String vcId = CommonsUtils.getPlayId(url, "/");
        // 如果id是一个空串活着id不是一个数字
        if (!StringUtils.isNotEmpty(vcId) || StringUtils.isNotNumber(vcId)) return new ArrayList<>(0);
        downloadItem.vcId = vcId;
        // 获取小视频详情信息
        PlayDetail playDetail = VcApi.getPlayDetail(vcId);
        // 获取小视频的标题描述
        Item item = playDetail.getData().getItem();
        // 没有这个小视频
        if (item == null) return new ArrayList<>(0);
        String title = FileUtils.getPrettyFileName(item.getDescription());
        downloadItem.title = title;
        // 构造小视频存储的位置
        downloadItem.outputFile = new File(BaseData.path + title + BaseData.VIDEO_EXTENSION);
        // 获取小视频的默认播放链接
        downloadItem.videoUrl = item.getVideoPlayurl();
        downloadItem.videoBackUpUrls = item.getBackupPlayurl().toArray(new String[0]);
        list.add(downloadItem);
        return list;
    }

    /**
     * 更新下载项中的URL
     *
     * @param downloadItem 下载项
     */
    public static void refreshUrlOfItem(SmallVideoDownloadItem downloadItem) throws IOException {
        // 获取小视频详情信息
        PlayDetail playDetail = VcApi.getPlayDetail(downloadItem.vcId);
        // 获取小视频的标题描述
        Item item = playDetail.getData().getItem();
        // 没有这个小视频
        if (item == null) return;
        // 获取小视频的默认播放链接
        downloadItem.videoUrl = item.getVideoPlayurl();
        downloadItem.videoBackUpUrls = item.getBackupPlayurl().toArray(new String[0]);
    }
}

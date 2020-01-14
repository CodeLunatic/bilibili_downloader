package bilibili.download.download_list.download_item;

import bilibili.api.model.common.video_detail.PagesItem;
import bilibili.download.enums.DownloadType;
import bilibili.download.enums.VideoType;

import java.io.File;
import java.util.List;

/**
 * 一个下载项
 */
public class VideoDownloadItem extends DownloadItem {

    /**
     * 下载类型
     */
    public DownloadType downloadType;

    /**
     * 视频的类型
     * 新版视频DASH
     * 老视频DURL
     */
    public VideoType videoType;

    /**
     * 下载的标题
     */
    public String title;

    /**
     * 视频的链接
     */
    public String videoUrl;

    /**
     * 音频的链接
     */
    public String audioUrl;

    /**
     * FLV的链接集合
     */
    public List<String> flvUrls;

    /**
     * 视频备用链接集合
     */
    public String[] videoBackUpUrls;

    /**
     * 音频备用链接集合
     */
    public String[] audioBackUpUrls;

    /**
     * FLV的这用链接
     */
    public List<String[]> flvBackUpUrls;

    /**
     * 该文件输出的目标位置
     */
    public File outputFile;

    /**
     * AV号
     */
    public String aid;

    /**
     * P号
     */
    public PagesItem page;

    /**
     * 用于EP的Cid还可用来做弹幕ID
     */
    public String cid;

    /**
     * EPID
     */
    public String epId;
}

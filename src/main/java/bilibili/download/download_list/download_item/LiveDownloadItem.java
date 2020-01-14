package bilibili.download.download_list.download_item;

import bilibili.download.enums.VideoType;

import java.io.File;
import java.util.List;

/**
 * 一个下载项
 */
public class LiveDownloadItem extends DownloadItem {

    /**
     * 直播的ID
     */
    public String liveId;

    /**
     * 直播状态
     */
    public String liveStatus;

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
     * 直播线路
     */
    public List<String> liveUrls;

    /**
     * 该文件输出的目标位置
     */
    public File outputFile;


}

package bilibili.download.download_list.download_item;

import java.io.File;

/**
 * 一个下载项
 */
public class SmallVideoDownloadItem extends DownloadItem{

    /**
     * 小视频的ID
     */
    public String vcId;

    /**
     * 下载的标题
     */
    public String title;

    /**
     * 视频的链接
     */
    public String videoUrl;

    /**
     * 视频备用链接集合
     */
    public String[] videoBackUpUrls;

    /**
     * 该文件输出的目标位置
     */
    public File outputFile;
}

package bilibili.download.download_list.download_item;

import java.io.File;

/**
 * 一个下载项
 */
public class AudioDownloadItem extends DownloadItem {

    /**
     * 单曲ID
     */
    public String sid;

    /**
     * 下载的标题
     */
    public String title;

    /**
     * 音频的链接
     */
    public String[] audioUrl;

    /**
     * 歌词的URL
     */
    public String lrcUrl;

    /**
     * 该文件输出的目标位置
     */
    public File musicOutputFile;

    /**
     * 歌词文件输出路径
     */
    public File lrcOutputFile;
}

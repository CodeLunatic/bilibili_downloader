package bilibili.download.download_list.download_item;

import java.util.Date;

/**
 * 一个下载项
 *
 * @author CY
 */
public abstract class DownloadItem {

    /**
     * 下载项的创建时间
     */
    public Date createTime;

    /**
     * 下载项的更新时间
     */
    public Date updateTime;

    /**
     * 下载项是否被暂停
     */
    public boolean isPause;
}

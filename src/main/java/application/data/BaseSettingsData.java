package application.data;

import bilibili.data.BaseData;
import util.SerializationUtil;

import java.io.Serializable;

/**
 * 应用程序初始化设置数据
 */
public class BaseSettingsData implements Serializable {

    private static final long serialVersionUID = -8296332170304591062L;

    /**
     * 设置文件保存的路径
     */
    private static transient final String settingsFilePath = ApplicationInfo.APP_CONFIG_PATH + "settings.conf";

    /**
     * 开启线程的数量，默认为5
     */
    private int threadNum = BaseData.threadNum;

    /**
     * 文件默认保存的路径
     * Todo 这里会不会造成放置到CySoftware目录下时目录错误问题
     */
    private String path = BaseData.path;

    /**
     * 默认清晰度
     */
    private String currentQuality = BaseData.currentQuality;

    /**
     * 是否下载文本
     */
    private boolean isDownloadLrc = BaseData.isDownloadLrc;

    /**
     * 是否下载弹幕
     */
    private boolean isDownloadDanmu = BaseData.isDownloadDanmu;

    /**
     * 初始化程序设置 OK
     */
    public static void initializeSettings() {
        // 涉及硬盘的读
        new Thread(() -> {
            BaseSettingsData baseSettingsData = SerializationUtil.deserialize(settingsFilePath, BaseSettingsData.class);
            if (baseSettingsData == null) return;
            BaseData.threadNum = baseSettingsData.threadNum == 0 ? BaseData.threadNum : baseSettingsData.threadNum;
            BaseData.path = baseSettingsData.path == null ? BaseData.path : baseSettingsData.path;
            BaseData.currentQuality = baseSettingsData.currentQuality == null ? BaseData.currentQuality : baseSettingsData.currentQuality;
            BaseData.isDownloadLrc = baseSettingsData.isDownloadLrc;
            BaseData.isDownloadDanmu = baseSettingsData.isDownloadDanmu;
        }).start();
    }

    /**
     * 刷新设置 OK
     */
    public static void refreshSettings() {
        // 涉及硬盘的写
        new Thread(() -> {
            BaseSettingsData baseSettingsData = new BaseSettingsData();
            baseSettingsData.threadNum = BaseData.threadNum;
            baseSettingsData.path = BaseData.path;
            baseSettingsData.isDownloadLrc = BaseData.isDownloadLrc;
            baseSettingsData.isDownloadDanmu = BaseData.isDownloadDanmu;
            SerializationUtil.serialize(baseSettingsData, settingsFilePath);
        }).start();
    }
}
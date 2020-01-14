package bilibili.data;

import bilibili.api.model.common.user_info.UserInfo;
import javafx.scene.image.Image;

import java.io.File;

/**
 * 程序中使用到的基本数据
 *
 * @author CY
 * 2019年7月15日
 */
public class BaseData {

    /**
     * BiliBili的主页，用来进行链接处理、做Referer的值
     */
    public static final String HOME_URL = "https://www.bilibili.com";

    /**
     * 默认的视频扩展名
     */
    public static final String VIDEO_EXTENSION = ".mp4";

    /**
     * FLV视频的扩展名
     */
    public static final String FLV_EXTENSION = ".flv";

    /**
     * 默认的音频扩展名
     */
    public static final String AUDIO_EXTENSION = ".mp3";

    /**
     * 默认的歌词格式
     */
    public static final String LYRIC_EXTENSION = ".lrc";

    /**
     * 默认的弹幕格式
     */
    public static final String DANMU_EXTENSION = ".xml";

    /**
     * 需要下载的URL，就是用户在输入框中输入的链接
     */
    public static String url;
    /**
     * 默认的下载路径，当前软件所处的运行路径
     * 图形化界面程序使用：System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
     */
    public static String path = System.getProperty("user.dir") + File.separator;

    /**
     * 是否已经登录
     */
    public static boolean isLogin = false;

    /**
     * 保持B站的登陆状态使用的Session
     */
    public static String sessionData = "";

    /**
     * 用户信息
     */
    public static UserInfo userInfo;

    /**
     * 头像
     */
    public static Image faceImage;

    /**
     * 默认最高的视频质量，如果程序需要做视频质量的支持，请修改这里
     * 112 : 高清 1080P+
     * 80  : 高清 1080P
     * 64  : 高清 720P
     * 32  : 清晰 480P
     * 16  : 流畅 360P
     */
    public static String currentQuality = "112";

    /**
     * 同时下载的文件的数量
     */
    public static int threadNum = 5;

    // Todo 下面的这些数据可能属于应用的公共数据，所以要写到应用的公共数据去，而不是在bilibili包下

    /**
     * 是否要下载视频的弹幕
     */
    public static boolean isDownloadDanmu = true;

    /**
     * 是否要下载音乐的歌词
     */
    public static boolean isDownloadLrc = true;

    /**
     * CY软件专用的文件夹
     */
    private transient static final String CY_DIRECTION = "CySoftware";

    /**
     * 临时文件保存的路径
     */
    public transient static final String APP_TEMP_FILE_PATH = System.getProperty("java.io.tmpdir") +
            CY_DIRECTION + File.separator;
}

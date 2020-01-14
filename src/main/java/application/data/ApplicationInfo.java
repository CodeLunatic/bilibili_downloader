package application.data;

import java.io.File;
import java.io.Serializable;
import java.util.UUID;

/**
 * 应用的信息，包含应用的基本信息和应用持久化信息
 * 应用的持久化信息例如：用户的个人设置，加载上次的使用进度等
 */
public class ApplicationInfo implements Serializable {

    private static final long serialVersionUID = -6795413777015542958L;

    /**
     * 该软件的ID，使用程序生成，不允许修改
     */
    private transient static final String APP_ID = "fbdaf00122894448aea7f4cb9307a6e8";

    /**
     * 软件名称 Todo
     */
    private transient static final String APP_NAME = "Imooc Downloader";

    /**
     * 软件版本 Todo
     */
    private transient static final String APP_VERSION = "v1.0-bate";

    /**
     * CY软件专用的文件夹
     */
    private transient static final String CY_DIRECTION = "CySoftware";

    /**
     * 序列化文件保存的路径
     * 默认在用户应用数据文件的Local下面的CySoft中的应用名文件夹中
     */
    public transient static final String APP_CONFIG_PATH = System.getProperty("user.home") +
            File.separator + "AppData" + File.separator + "Local" + File.separator +
            CY_DIRECTION + File.separator + APP_ID + File.separator;

    /**
     * 临时文件保存的路径
     */
    public transient static final String APP_TEMP_FILE_PATH = System.getProperty("java.io.tmpdir") +
            ApplicationInfo.CY_DIRECTION + File.separator;


    // Todo ======= 除上述的应用基本信息外，请在这里补充其他需要持久化的数据 ======
}
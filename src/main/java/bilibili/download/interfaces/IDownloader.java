package bilibili.download.interfaces;

import java.io.IOException;

/**
 * 下载总接口
 * 2019年7月15日
 */
public interface IDownloader {

    /**
     * 下载用的的核心方法
     *
     * @throws IOException #
     */
    void download() throws IOException;
}

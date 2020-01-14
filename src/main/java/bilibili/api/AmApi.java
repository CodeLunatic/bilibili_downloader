package bilibili.api;

import bilibili.api.model.am.album_info.AlbumInfo;
import bilibili.api.model.am.album_list.AlbumList;
import bilibili.api.model.am.hot_album_list.HotAlbumList;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * 歌曲专辑的API
 *
 * @author CY
 * @apiNote BiliBili AM API 音频专辑
 * 2019年7月15日
 */
public class AmApi {

    /**
     * 获取专辑信息
     *
     * @param sid 专辑ID
     * @return 专辑信息
     * @throws IOException #
     */
    public static AlbumInfo getAlbumInfo(String sid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/menu/info?sid=" + sid);
        return JSON.parseObject(json, AlbumInfo.class);
    }

    /**
     * 获取专辑列表
     *
     * @param sid 专辑ID
     * @return 专辑列表
     * @throws IOException #
     */
    public static AlbumList getAlbumList(String sid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/song/of-menu?sid=" + sid + "&pn=1&ps=1000000");
        return JSON.parseObject(json, AlbumList.class);
    }

    /**
     * 获取36个热门歌单
     *
     * @throws IOException #
     */
    public static HotAlbumList getHotAlbumList() throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/menu/hit?pn=1&ps=1000000");
        return JSON.parseObject(json, HotAlbumList.class);
    }
}

package bilibili.api;

import bilibili.api.model.au.music_detail.MusicDetail;
import bilibili.api.model.au.music_url.MusicUrl;
import bilibili.api.model.au.similar_music.SimilarMusic;
import bilibili.api.model.au.upper_base_info.UpperBaseInfo;
import bilibili.api.model.au.upper_hot_music.UpperHotMusic;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * 歌曲的API
 *
 * @author CY
 * @apiNote BiliBili AU API 音乐
 * 2019年7月15日
 */
public class AuApi {

    /**
     * 获取音乐详情（歌词文件的链接在里面）
     *
     * @param sid 歌曲的ID
     * @return 音乐的详情信息
     * @throws IOException #
     */
    public static MusicDetail getMusicDetail(String sid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/song/info?sid=" + sid);
        return JSON.parseObject(json, MusicDetail.class);
    }

    /**
     * 获取相似音乐
     *
     * @param sid 歌曲的ID
     * @return 相似音乐
     * @throws IOException #
     */
    public static SimilarMusic getSimilarMusic(String sid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/song/similar?sid=" + sid);
        return JSON.parseObject(json, SimilarMusic.class);
    }

    /**
     * 获取播放音乐的链接
     *
     * @param sid 歌曲的ID
     * @return 播放音乐链接信息
     * @throws IOException #
     */
    public static MusicUrl getMusicUrl(String sid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/url?sid=" + sid + "&privilege=127&quality=127");
        return JSON.parseObject(json, MusicUrl.class);
    }

    /**
     * 获取Upper的热歌列表
     *
     * @param uid Upper的ID
     * @return Upper的热歌列表
     * @throws IOException #
     */
    public static UpperHotMusic getUpperHotMusic(String uid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/song/upper-hit?uid=" + uid + "&pn=1&ps=6");
        return JSON.parseObject(json, UpperHotMusic.class);
    }

    /**
     * 获取Upper的基本信息
     *
     * @param uid Upper的ID
     * @return Upper的基本信息，用户名头像签名
     * @throws IOException #
     */
    public static UpperBaseInfo getUpperBaseInfo(String uid) throws IOException {
        String json = HttpUtils.urlJson("https://www.bilibili.com/audio/music-service-c/web/user/info?uid=" + uid);
        return JSON.parseObject(json, UpperBaseInfo.class);
    }
}

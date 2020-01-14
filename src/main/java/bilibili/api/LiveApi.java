package bilibili.api;

import bilibili.api.model.live.live_url.ApiLiveUrl;
import bilibili.api.model.live.live_user_info.LiveUserInfo;
import bilibili.api.model.live.neptune_is_my_waifu.PageLiveUrl;
import bilibili.api.model.live.play_url.PlayUrl;
import bilibili.api.model.live.round_play_url.RoundPlayUrl;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;
import util.StringUtils;

import java.io.IOException;

/**
 * 直播相关的API
 *
 * @author CY
 * @apiNote BiliBili直播API
 * 2019年7月15日
 */
public class LiveApi {

    /**
     * 获取直播的地址，直播是不可能得知下载进度的
     *
     * @param cid 直播间所对应的room_id
     * @return 直播信息
     * @throws IOException #
     */
    public static ApiLiveUrl getLiveUrlByRoomId(String cid) throws IOException {
        String json = HttpUtils.urlJson("https://api.live.bilibili.com/room/v1/Room/playUrl?cid=" + cid + "&quality=1000&platform=web");
        return JSON.parseObject(json, ApiLiveUrl.class);
    }

    /**
     * 通过用户给的链接中的ID，获取直播视频的链接
     *
     * @param liveId 直播ID
     * @return 直播信息
     * @throws IOException #
     */
    public static PageLiveUrl getLiveUrlByLiveId(String liveId) throws IOException {
        String html = HttpUtils.urlHtml("https://live.bilibili.com/" + liveId);
        String json = StringUtils.getPartString(html,
                "<script>window.__NEPTUNE_IS_MY_WAIFU__=",
                "</script>");
        return JSON.parseObject(json, PageLiveUrl.class);
    }

    /**
     * 获取直播状态下用户的信息
     *
     * @return 用户直播状态下的信息
     * @throws IOException #
     */
    public static LiveUserInfo getLiveUserInfo() throws IOException {
        String json = HttpUtils.urlJson("https://api.live.bilibili.com/xlive/web-ucenter/user/get_user_info");
        return JSON.parseObject(json, LiveUserInfo.class);
    }

    /**
     * 获取轮播的URL
     *
     * @throws IOException #
     */
    public static String getRoundPlayUrl(String room_id) throws IOException {
        String json = HttpUtils.urlJson("https://api.live.bilibili.com/live/getRoundPlayVideo?room_id=" + room_id);
        RoundPlayUrl roundPlayUrl = JSON.parseObject(json, RoundPlayUrl.class);
        String playUrl = roundPlayUrl.getData().getPlayUrl();
        if (StringUtils.isNotEmpty(playUrl)) {
            String playUrlJson = HttpUtils.urlJson(playUrl);
            PlayUrl realPlayUrl = JSON.parseObject(playUrlJson, PlayUrl.class);
            return realPlayUrl.getDurl().get(0).getUrl();

        }
        return null;
    }
}

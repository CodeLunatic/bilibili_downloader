package bilibili.api;

import bilibili.api.model.common.VideoUrl;
import bilibili.api.model.ep.initial_state.InitialState;
import bilibili.api.model.ep.new_video_url.EpNewVideoUrl;
import bilibili.api.model.ep.old_video_url.EpOldVideoUrl;
import bilibili.data.BaseData;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;
import util.StringUtils;

import java.io.IOException;

/**
 * EP的API
 *
 * @author CY
 * @apiNote BiliBili EP API 电影，电视剧，纪录片等
 * 2019年7月15日
 */
public class EpApi extends CommonApi {

    /**
     * 获取视频的播放链接,获取的结果不确定是NewVideoUrl还是OldVideoUrl
     * 使用的时候需要使用 object instanceof EpNewVideoUrl | EpOldVideoUrl 来判断
     * 注意如果为Null那么意味着这个文件需要使用大会员才能下载
     *
     * @param avid AV号
     * @param cid  弹幕号
     * @return 视频播放链接列表
     * @throws IOException #
     */
    public static VideoUrl getVideoUrl(String avid, String cid, String epid) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/pgc/player/web/playurl?avid=" + avid + "&cid=" + cid + "&qn=" + BaseData.currentQuality + "&type=json&otype=json&ep_id=" + epid + "&fnver=0&fnval=16");
        if (json.contains("\"dash\"")) {
            return JSON.parseObject(json, EpNewVideoUrl.class);
        } else if (json.contains("\"durl\"")) {
            return JSON.parseObject(json, EpOldVideoUrl.class);
        } else {
            return null;
        }
    }

    /**
     * 得到EP的页面初始化清单列表
     *
     * @param epid Ep的ID
     * @return Ep的初始化列表
     * @throws IOException #
     */
    public static InitialState getEpInitialState(String epid) throws IOException {
        String html = HttpUtils.urlHtml("https://www.bilibili.com/bangumi/play/ep" + epid);
        String json = StringUtils.getPartString(html,
                "<script>window.__INITIAL_STATE__=",
                ";(function(){var s;(s=document.currentScript||document.scripts[document.scripts.length-1]).parentNode.removeChild(s);}());</script>");
        return JSON.parseObject(json, InitialState.class);
    }
}

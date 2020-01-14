package bilibili.api;

import bilibili.api.model.common.default_search.DefaultSearch;
import bilibili.api.model.common.upper_info.UpperInfo;
import bilibili.api.model.common.user_info.UserInfo;
import bilibili.api.model.common.video_describe.VideoDescribe;
import bilibili.api.model.common.video_detail.VideoDetail;
import bilibili.api.model.common.video_tag.VideoTag;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * BiliBili的公用Api
 *
 * @author CY
 * 2019年7月15日
 */
public class CommonApi {

    /**
     * 获取当前登陆的用户信息
     *
     * @return 用户信息
     * @throws IOException #
     */
    public static UserInfo getUserInfo() throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/web-interface/nav");
        return JSON.parseObject(json, UserInfo.class);
    }

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = getUserInfo();
        System.out.println(JSON.toJSONString(userInfo, true));
    }

    /**
     * 获取视频的详细信息
     *
     * @param aid 视频的AV号
     * @return 视频的详细信息
     * @throws IOException #
     */
    public static VideoDetail getVideoDetail(String aid) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/web-interface/view/detail?aid=" + aid);
        return JSON.parseObject(json, VideoDetail.class);
    }

    /**
     * 获取视频的标签
     *
     * @param aid 视频的AV号
     * @return 视频标签
     * @throws IOException #
     */
    public static VideoTag getVideoTag(String aid) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/tag/archive/tags?aid=" + aid);
        return JSON.parseObject(json, VideoTag.class);
    }

    /**
     * 获取视频的描述信息
     *
     * @param aid  视频的AV号
     * @param page 视频的P
     * @return 视频的描述信息
     * @throws IOException #
     */
    public static VideoDescribe getVideoDescribe(String aid, String page) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/web-interface/archive/desc?aid=" + aid + "&page=" + page);
        return JSON.parseObject(json, VideoDescribe.class);
    }

    /**
     * 获取弹幕XML字符串
     *
     * @param oid 弹幕ID
     * @throws IOException #
     */
    public static String getVideoDanmu(String oid) throws IOException {
        return HttpUtils.urlJson("https://api.bilibili.com/x/v1/dm/list.so?oid=" + oid);
    }

    /**
     * Upper的个人信息
     *
     * @param mid Upper的Id
     * @throws IOException #
     */
    public static UpperInfo getUpperInfo(String mid) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/web-interface/card?mid=" + mid + "&photo=1");
        return JSON.parseObject(json, UpperInfo.class);
    }

    /**
     * 获取B站今日的默认搜索
     *
     * @return 今日搜索框
     * @throws IOException #
     */
    public static DefaultSearch getDefaultSearch() throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/web-interface/search/default");
        return JSON.parseObject(json, DefaultSearch.class);
    }
}

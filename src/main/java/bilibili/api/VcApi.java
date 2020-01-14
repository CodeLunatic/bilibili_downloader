package bilibili.api;

import bilibili.api.model.vc.play_detail.PlayDetail;
import bilibili.api.model.vc.recommend.Recommend;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * 小视频API
 *
 * @author CY
 * @apiNote vc.bilibili.com站点的小视频API
 * 2019年7月15日
 */
public class VcApi {

    /**
     * 获取小视频的播放详情（包含播放地址）
     *
     * @param video_id 视频Id
     * @return 播放详情
     * @throws IOException #
     */
    public static PlayDetail getPlayDetail(String video_id) throws IOException {
        String json = HttpUtils.urlJson("http://api.vc.bilibili.com/clip/v1/video/detail?video_id=" + video_id + "&need_playurl=1");
        return JSON.parseObject(json, PlayDetail.class);
    }

    /**
     * 获取小视频精彩推荐
     *
     * @return 推荐列表
     * @throws IOException #
     */
    public static Recommend getRecommend() throws IOException {
        String json = HttpUtils.urlJson("http://api.vc.bilibili.com/clip/v1/video/index?platform=pc&page_size=9&need_playurl=0");
        return JSON.parseObject(json, Recommend.class);
    }
}

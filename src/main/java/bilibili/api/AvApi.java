package bilibili.api;

import bilibili.api.model.av.new_video_url.AvNewVideoUrl;
import bilibili.api.model.av.old_video_url.AvOldVideoUrl;
import bilibili.api.model.common.VideoUrl;
import bilibili.data.BaseData;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * AV的API
 *
 * @author CY
 * @apiNote BiliBili AV API UP主们
 * 2019年7月15日
 */
public class AvApi extends CommonApi {

    /**
     * 获取视频的播放链接,获取的结果不确定是NewVideoUrl还是OldVideoUrl
     * 使用的时候需要使用 object instanceof AvNewVideoUrl | AvOldVideoUrl 来判断
     *
     * @param avid AV号
     * @param cid  弹幕号
     * @return 视频播放链接列表
     * @throws IOException #
     */
    public static VideoUrl getVideoUrl(String avid, String cid) throws IOException {
        String json = HttpUtils.urlJson("https://api.bilibili.com/x/player/playurl?avid=" + avid + "&cid=" + cid + "&qn=" + BaseData.currentQuality + "&type=json&otype=json&fnver=0&fnval=16");
        if (json.contains("\"dash\"")) {
            return JSON.parseObject(json, AvNewVideoUrl.class);
        } else if (json.contains("\"durl\"")) {
            return JSON.parseObject(json, AvOldVideoUrl.class);
        } else {
            throw new IllegalStateException("AV号中获取视频链接出现了新的类型：" + json);
        }
    }
}

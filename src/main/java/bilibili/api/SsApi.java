package bilibili.api;

import bilibili.api.model.ep.initial_state.InitialState;
import bilibili.util.HttpUtils;
import com.alibaba.fastjson.JSON;
import util.StringUtils;

import java.io.IOException;

/**
 * SS的API
 *
 * @author CY
 * @apiNote BiliBili SS API 番剧等
 * 2019年7月15日
 */
public class SsApi extends EpApi {

    /**
     * 获取初始化清单
     * 获取了该初始化清单之后需要使用EpApi类中的获取播放地址来执行下一步操作
     *
     * @param ssid ss的id
     * @return 初始化清单
     * @throws IOException #
     */
    public static InitialState getSsInitialState(String ssid) throws IOException {
        String html = HttpUtils.urlHtml("https://www.bilibili.com/bangumi/play/ss" + ssid);
        String json = StringUtils.getPartString(html,
                "<script>window.__INITIAL_STATE__=",
                ";(function(){var s;(s=document.currentScript||document.scripts[document.scripts.length-1]).parentNode.removeChild(s);}());</script>");
        return JSON.parseObject(json, InitialState.class);
    }
}

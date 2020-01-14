package bilibili.download.enums;

/**
 * 用来记录视频的类型
 */
public enum VideoType {
    /**
     * AV和EP的新视频
     */
    DASH,
    /**
     * AV和EP的老视频
     */
    DURL,
    /**
     * LIVE中的轮播
     */
    ROUND_PLAY,
    /**
     * LIVE中的直播
     */
    LIVE_PLAY
}

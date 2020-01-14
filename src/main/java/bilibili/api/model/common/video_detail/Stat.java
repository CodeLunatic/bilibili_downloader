package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Stat {

    @JSONField(name = "now_rank")
    private String nowRank;

    @JSONField(name = "view")
    private String view;

    @JSONField(name = "like")
    private String like;

    @JSONField(name = "dislike")
    private String dislike;

    @JSONField(name = "danmaku")
    private String danmaku;

    @JSONField(name = "share")
    private String share;

    @JSONField(name = "reply")
    private String reply;

    @JSONField(name = "his_rank")
    private String hisRank;

    @JSONField(name = "aid")
    private String aid;

    @JSONField(name = "favorite")
    private String favorite;

    @JSONField(name = "coin")
    private String coin;

    public String getNowRank() {
        return nowRank;
    }

    public void setNowRank(String nowRank) {
        this.nowRank = nowRank;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(String danmaku) {
        this.danmaku = danmaku;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getHisRank() {
        return hisRank;
    }

    public void setHisRank(String hisRank) {
        this.hisRank = hisRank;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return
                "Stat{" +
                        "now_rank = '" + nowRank + '\'' +
                        ",view = '" + view + '\'' +
                        ",like = '" + like + '\'' +
                        ",dislike = '" + dislike + '\'' +
                        ",danmaku = '" + danmaku + '\'' +
                        ",share = '" + share + '\'' +
                        ",reply = '" + reply + '\'' +
                        ",his_rank = '" + hisRank + '\'' +
                        ",aid = '" + aid + '\'' +
                        ",favorite = '" + favorite + '\'' +
                        ",coin = '" + coin + '\'' +
                        "}";
    }
}
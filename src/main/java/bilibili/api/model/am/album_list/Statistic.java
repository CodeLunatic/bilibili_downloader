package bilibili.api.model.am.album_list;

import com.alibaba.fastjson.annotation.JSONField;

public class Statistic {

    @JSONField(name = "play")
    private String play;

    @JSONField(name = "comment")
    private String comment;

    @JSONField(name = "share")
    private String share;

    @JSONField(name = "collect")
    private String collect;

    @JSONField(name = "sid")
    private String sid;

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return
                "Statistic{" +
                        "play = '" + play + '\'' +
                        ",comment = '" + comment + '\'' +
                        ",share = '" + share + '\'' +
                        ",collect = '" + collect + '\'' +
                        ",sid = '" + sid + '\'' +
                        "}";
    }
}
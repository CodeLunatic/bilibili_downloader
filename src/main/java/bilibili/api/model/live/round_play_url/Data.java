package bilibili.api.model.live.round_play_url;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "sequence")
    private String sequence;

    @JSONField(name = "play_url")
    private String playUrl;

    @JSONField(name = "pid")
    private String pid;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "aid")
    private String aid;

    @JSONField(name = "cid")
    private String cid;

    @JSONField(name = "play_time")
    private String playTime;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "sequence = '" + sequence + '\'' +
                        ",play_url = '" + playUrl + '\'' +
                        ",pid = '" + pid + '\'' +
                        ",title = '" + title + '\'' +
                        ",aid = '" + aid + '\'' +
                        ",cid = '" + cid + '\'' +
                        ",play_time = '" + playTime + '\'' +
                        "}";
    }
}
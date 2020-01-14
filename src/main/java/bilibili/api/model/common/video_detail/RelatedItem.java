package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class RelatedItem {

    @JSONField(name = "owner")
    private Owner owner;

    @JSONField(name = "copyright")
    private String copyright;

    @JSONField(name = "stat")
    private Stat stat;

    @JSONField(name = "mission_id")
    private String missionId;

    @JSONField(name = "tname")
    private String tname;

    @JSONField(name = "videos")
    private String videos;

    @JSONField(name = "pic")
    private String pic;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "tid")
    private String tid;

    @JSONField(name = "duration")
    private String duration;

    @JSONField(name = "rights")
    private Rights rights;

    @JSONField(name = "ctime")
    private String ctime;

    @JSONField(name = "dynamic")
    private String dynamic;

    @JSONField(name = "state")
    private String state;

    @JSONField(name = "attribute")
    private String attribute;

    @JSONField(name = "aid")
    private String aid;

    @JSONField(name = "dimension")
    private Dimension dimension;

    @JSONField(name = "pubdate")
    private String pubdate;

    @JSONField(name = "desc")
    private String desc;

    @JSONField(name = "cid")
    private String cid;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return
                "RelatedItem{" +
                        "owner = '" + owner + '\'' +
                        ",copyright = '" + copyright + '\'' +
                        ",stat = '" + stat + '\'' +
                        ",mission_id = '" + missionId + '\'' +
                        ",tname = '" + tname + '\'' +
                        ",videos = '" + videos + '\'' +
                        ",pic = '" + pic + '\'' +
                        ",title = '" + title + '\'' +
                        ",tid = '" + tid + '\'' +
                        ",duration = '" + duration + '\'' +
                        ",rights = '" + rights + '\'' +
                        ",ctime = '" + ctime + '\'' +
                        ",dynamic = '" + dynamic + '\'' +
                        ",state = '" + state + '\'' +
                        ",attribute = '" + attribute + '\'' +
                        ",aid = '" + aid + '\'' +
                        ",dimension = '" + dimension + '\'' +
                        ",pubdate = '" + pubdate + '\'' +
                        ",desc = '" + desc + '\'' +
                        ",cid = '" + cid + '\'' +
                        "}";
    }
}
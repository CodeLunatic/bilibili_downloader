package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class View {

    @JSONField(name = "owner")
    private Owner owner;

    @JSONField(name = "copyright")
    private String copyright;

    @JSONField(name = "stat")
    private Stat stat;

    @JSONField(name = "tname")
    private String tname;

    @JSONField(name = "videos")
    private String videos;

    @JSONField(name = "pic")
    private String pic;

    @JSONField(name = "label")
    private Label label;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "tid")
    private String tid;

    @JSONField(name = "duration")
    private String duration;

    @JSONField(name = "pages")
    private List<PagesItem> pages;

    @JSONField(name = "no_cache")
    private String noCache;

    @JSONField(name = "rights")
    private Rights rights;

    @JSONField(name = "subtitle")
    private Subtitle subtitle;

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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
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

    public List<PagesItem> getPages() {
        return pages;
    }

    public void setPages(List<PagesItem> pages) {
        this.pages = pages;
    }

    public void setNoCache(String noCache) {
        this.noCache = noCache;
    }

    public String isNoCache() {
        return noCache;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
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
                "View{" +
                        "owner = '" + owner + '\'' +
                        ",copyright = '" + copyright + '\'' +
                        ",stat = '" + stat + '\'' +
                        ",tname = '" + tname + '\'' +
                        ",videos = '" + videos + '\'' +
                        ",pic = '" + pic + '\'' +
                        ",label = '" + label + '\'' +
                        ",title = '" + title + '\'' +
                        ",tid = '" + tid + '\'' +
                        ",duration = '" + duration + '\'' +
                        ",pages = '" + pages + '\'' +
                        ",no_cache = '" + noCache + '\'' +
                        ",rights = '" + rights + '\'' +
                        ",subtitle = '" + subtitle + '\'' +
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
package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class PagesItem {

    @JSONField(name = "duration")
    private String duration;

    @JSONField(name = "vid")
    private String vid;

    @JSONField(name = "part")
    private String part;

    @JSONField(name = "weblink")
    private String weblink;

    @JSONField(name = "from")
    private String from;

    @JSONField(name = "page")
    private String page;

    @JSONField(name = "dimension")
    private Dimension dimension;

    @JSONField(name = "cid")
    private String cid;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
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
                "PagesItem{" +
                        "duration = '" + duration + '\'' +
                        ",vid = '" + vid + '\'' +
                        ",part = '" + part + '\'' +
                        ",weblink = '" + weblink + '\'' +
                        ",from = '" + from + '\'' +
                        ",page = '" + page + '\'' +
                        ",dimension = '" + dimension + '\'' +
                        ",cid = '" + cid + '\'' +
                        "}";
    }
}
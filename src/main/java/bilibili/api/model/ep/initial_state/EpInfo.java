package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class EpInfo {

    @JSONField(name = "releaseDate")
    private String releaseDate;

    @JSONField(name = "i")
    private String I;

    @JSONField(name = "hasNext")
    private String hasNext;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "loaded")
    private String loaded;

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "vid")
    private String vid;

    @JSONField(name = "badge")
    private String badge;

    @JSONField(name = "badgeType")
    private String badgeType;

    @JSONField(name = "titleFormat")
    private String titleFormat;

    @JSONField(name = "from")
    private String from;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "sectionType")
    private String sectionType;

    @JSONField(name = "aid")
    private String aid;

    @JSONField(name = "epStatus")
    private String epStatus;

    @JSONField(name = "cid")
    private String cid;

    @JSONField(name = "longTitle")
    private String longTitle;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getI() {
        return I;
    }

    public void setI(String I) {
        this.I = I;
    }

    public void setHasNext(String hasNext) {
        this.hasNext = hasNext;
    }

    public String isHasNext() {
        return hasNext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public String isLoaded() {
        return loaded;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getTitleFormat() {
        return titleFormat;
    }

    public void setTitleFormat(String titleFormat) {
        this.titleFormat = titleFormat;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getEpStatus() {
        return epStatus;
    }

    public void setEpStatus(String epStatus) {
        this.epStatus = epStatus;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    @Override
    public String toString() {
        return
                "EpInfo{" +
                        "releaseDate = '" + releaseDate + '\'' +
                        ",i = '" + I + '\'' +
                        ",hasNext = '" + hasNext + '\'' +
                        ",title = '" + title + '\'' +
                        ",loaded = '" + loaded + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",vid = '" + vid + '\'' +
                        ",badge = '" + badge + '\'' +
                        ",badgeType = '" + badgeType + '\'' +
                        ",titleFormat = '" + titleFormat + '\'' +
                        ",from = '" + from + '\'' +
                        ",id = '" + id + '\'' +
                        ",sectionType = '" + sectionType + '\'' +
                        ",aid = '" + aid + '\'' +
                        ",epStatus = '" + epStatus + '\'' +
                        ",cid = '" + cid + '\'' +
                        ",longTitle = '" + longTitle + '\'' +
                        "}";
    }
}
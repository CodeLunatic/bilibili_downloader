package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class SsListItem {

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "badge")
    private String badge;

    @JSONField(name = "badgeType")
    private String badgeType;

    @JSONField(name = "epCover")
    private String epCover;

    @JSONField(name = "follows")
    private String follows;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "pgcType")
    private String pgcType;

    @JSONField(name = "views")
    private String views;

    @JSONField(name = "desc")
    private String desc;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public String getEpCover() {
        return epCover;
    }

    public void setEpCover(String epCover) {
        this.epCover = epCover;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPgcType() {
        return pgcType;
    }

    public void setPgcType(String pgcType) {
        this.pgcType = pgcType;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return
                "SsListItem{" +
                        "cover = '" + cover + '\'' +
                        ",badge = '" + badge + '\'' +
                        ",badgeType = '" + badgeType + '\'' +
                        ",epCover = '" + epCover + '\'' +
                        ",follows = '" + follows + '\'' +
                        ",id = '" + id + '\'' +
                        ",title = '" + title + '\'' +
                        ",type = '" + type + '\'' +
                        ",pgcType = '" + pgcType + '\'' +
                        ",views = '" + views + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
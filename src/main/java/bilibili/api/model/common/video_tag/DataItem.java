package bilibili.api.model.common.video_tag;

import com.alibaba.fastjson.annotation.JSONField;

public class DataItem {

    @JSONField(name = "head_cover")
    private String headCover;

    @JSONField(name = "is_atten")
    private String isAtten;

    @JSONField(name = "tag_name")
    private String tagName;

    @JSONField(name = "count")
    private Count count;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "hates")
    private String hates;

    @JSONField(name = "liked")
    private String liked;

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "short_content")
    private String shortContent;

    @JSONField(name = "tag_id")
    private String tagId;

    @JSONField(name = "ctime")
    private String ctime;

    @JSONField(name = "state")
    private String state;

    @JSONField(name = "attribute")
    private String attribute;

    @JSONField(name = "hated")
    private String hated;

    @JSONField(name = "likes")
    private String likes;

    public String getHeadCover() {
        return headCover;
    }

    public void setHeadCover(String headCover) {
        this.headCover = headCover;
    }

    public String getIsAtten() {
        return isAtten;
    }

    public void setIsAtten(String isAtten) {
        this.isAtten = isAtten;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHates() {
        return hates;
    }

    public void setHates(String hates) {
        this.hates = hates;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
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

    public String getHated() {
        return hated;
    }

    public void setHated(String hated) {
        this.hated = hated;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "head_cover = '" + headCover + '\'' +
                        ",is_atten = '" + isAtten + '\'' +
                        ",tag_name = '" + tagName + '\'' +
                        ",count = '" + count + '\'' +
                        ",type = '" + type + '\'' +
                        ",content = '" + content + '\'' +
                        ",hates = '" + hates + '\'' +
                        ",liked = '" + liked + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",short_content = '" + shortContent + '\'' +
                        ",tag_id = '" + tagId + '\'' +
                        ",ctime = '" + ctime + '\'' +
                        ",state = '" + state + '\'' +
                        ",attribute = '" + attribute + '\'' +
                        ",hated = '" + hated + '\'' +
                        ",likes = '" + likes + '\'' +
                        "}";
    }
}
package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Activity {

    @JSONField(name = "pendantOpsImg")
    private String pendantOpsImg;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "pendantOpsLink")
    private String pendantOpsLink;

    public String getPendantOpsImg() {
        return pendantOpsImg;
    }

    public void setPendantOpsImg(String pendantOpsImg) {
        this.pendantOpsImg = pendantOpsImg;
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

    public String getPendantOpsLink() {
        return pendantOpsLink;
    }

    public void setPendantOpsLink(String pendantOpsLink) {
        this.pendantOpsLink = pendantOpsLink;
    }

    @Override
    public String toString() {
        return
                "Activity{" +
                        "pendantOpsImg = '" + pendantOpsImg + '\'' +
                        ",id = '" + id + '\'' +
                        ",title = '" + title + '\'' +
                        ",pendantOpsLink = '" + pendantOpsLink + '\'' +
                        "}";
    }
}
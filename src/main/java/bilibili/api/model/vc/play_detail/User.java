package bilibili.api.model.vc.play_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class User {

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "head_url")
    private String headUrl;

    @JSONField(name = "level")
    private List<Object> level;

    @JSONField(name = "is_vip")
    private String isVip;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "upload_count")
    private String uploadCount;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public List<Object> getLevel() {
        return level;
    }

    public void setLevel(List<Object> level) {
        this.level = level;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadCount() {
        return uploadCount;
    }

    public void setUploadCount(String uploadCount) {
        this.uploadCount = uploadCount;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "uid = '" + uid + '\'' +
                        ",head_url = '" + headUrl + '\'' +
                        ",level = '" + level + '\'' +
                        ",is_vip = '" + isVip + '\'' +
                        ",name = '" + name + '\'' +
                        ",upload_count = '" + uploadCount + '\'' +
                        "}";
    }
}
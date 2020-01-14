package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class UpInfo {

    @JSONField(name = "pendantId")
    private String pendantId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "mid")
    private String mid;

    @JSONField(name = "pendantName")
    private String pendantName;

    @JSONField(name = "pendantImage")
    private String pendantImage;

    @JSONField(name = "avatar")
    private String avatar;

    @JSONField(name = "isAnnualVip")
    private String isAnnualVip;

    public String getPendantId() {
        return pendantId;
    }

    public void setPendantId(String pendantId) {
        this.pendantId = pendantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPendantName() {
        return pendantName;
    }

    public void setPendantName(String pendantName) {
        this.pendantName = pendantName;
    }

    public String getPendantImage() {
        return pendantImage;
    }

    public void setPendantImage(String pendantImage) {
        this.pendantImage = pendantImage;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setIsAnnualVip(String isAnnualVip) {
        this.isAnnualVip = isAnnualVip;
    }

    public String isIsAnnualVip() {
        return isAnnualVip;
    }

    @Override
    public String toString() {
        return
                "UpInfo{" +
                        "pendantId = '" + pendantId + '\'' +
                        ",name = '" + name + '\'' +
                        ",mid = '" + mid + '\'' +
                        ",pendantName = '" + pendantName + '\'' +
                        ",pendantImage = '" + pendantImage + '\'' +
                        ",avatar = '" + avatar + '\'' +
                        ",isAnnualVip = '" + isAnnualVip + '\'' +
                        "}";
    }
}
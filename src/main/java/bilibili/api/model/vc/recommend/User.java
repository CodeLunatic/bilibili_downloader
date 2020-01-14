package bilibili.api.model.vc.recommend;

import com.alibaba.fastjson.annotation.JSONField;

public class User {

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "head_url")
    private String headUrl;

    @JSONField(name = "is_vip")
    private String isVip;

    @JSONField(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return
                "User{" +
                        "uid = '" + uid + '\'' +
                        ",head_url = '" + headUrl + '\'' +
                        ",is_vip = '" + isVip + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}
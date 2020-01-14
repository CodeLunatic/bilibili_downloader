package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Official {

    @JSONField(name = "role")
    private String role;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "desc")
    private String desc;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "Official{" +
                        "role = '" + role + '\'' +
                        ",title = '" + title + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
package bilibili.api.model.common.upper_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Pendant {

    @JSONField(name = "image")
    private String image;

    @JSONField(name = "expire")
    private String expire;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "pid")
    private String pid;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return
                "Pendant{" +
                        "image = '" + image + '\'' +
                        ",expire = '" + expire + '\'' +
                        ",name = '" + name + '\'' +
                        ",pid = '" + pid + '\'' +
                        "}";
    }
}
package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Owner {

    @JSONField(name = "face")
    private String face;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "mid")
    private String mid;

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
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

    @Override
    public String toString() {
        return
                "Owner{" +
                        "face = '" + face + '\'' +
                        ",name = '" + name + '\'' +
                        ",mid = '" + mid + '\'' +
                        "}";
    }
}
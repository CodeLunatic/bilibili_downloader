package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class OfficialVerify {

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "desc")
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "OfficialVerify{" +
                        "type = '" + type + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
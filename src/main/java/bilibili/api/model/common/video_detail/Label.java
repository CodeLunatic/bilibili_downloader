package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Label {

    @JSONField(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "Label{" +
                        "type = '" + type + '\'' +
                        "}";
    }
}
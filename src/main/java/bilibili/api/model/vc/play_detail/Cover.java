package bilibili.api.model.vc.play_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Cover {

    @JSONField(name = "default")
    private String jsonMemberDefault;

    public String getJsonMemberDefault() {
        return jsonMemberDefault;
    }

    public void setJsonMemberDefault(String jsonMemberDefault) {
        this.jsonMemberDefault = jsonMemberDefault;
    }

    @Override
    public String toString() {
        return
                "Cover{" +
                        "default = '" + jsonMemberDefault + '\'' +
                        "}";
    }
}
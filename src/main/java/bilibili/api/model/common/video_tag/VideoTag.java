package bilibili.api.model.common.video_tag;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class VideoTag {

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "data")
    private List<DataItem> data;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "ttl")
    private String ttl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return
                "VideoTag{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",ttl = '" + ttl + '\'' +
                        "}";
    }
}
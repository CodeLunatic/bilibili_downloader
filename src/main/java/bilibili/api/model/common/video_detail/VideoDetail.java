package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class VideoDetail {

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "data")
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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
                "VideoDetail{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",ttl = '" + ttl + '\'' +
                        "}";
    }
}
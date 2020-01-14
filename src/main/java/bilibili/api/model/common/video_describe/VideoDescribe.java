package bilibili.api.model.common.video_describe;

import com.alibaba.fastjson.annotation.JSONField;

public class VideoDescribe {

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "data")
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
                "VideoDescribe{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",ttl = '" + ttl + '\'' +
                        "}";
    }
}
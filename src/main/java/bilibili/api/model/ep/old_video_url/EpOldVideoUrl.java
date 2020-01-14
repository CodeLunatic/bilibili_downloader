package bilibili.api.model.ep.old_video_url;


import bilibili.api.model.common.VideoUrl;
import com.alibaba.fastjson.annotation.JSONField;

public class EpOldVideoUrl extends VideoUrl {

    @JSONField(name = "result")
    private Result result;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "message")
    private String message;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "EpOldVideoUrl{" +
                        "result = '" + result + '\'' +
                        ",code = '" + code + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
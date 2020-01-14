package bilibili.api.model.au.upper_hot_music;

import com.alibaba.fastjson.annotation.JSONField;

public class UpperHotMusic {

    @JSONField(name = "msg")
    private String msg;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "data")
    private Data data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    @Override
    public String toString() {
        return
                "UpperHotMusic{" +
                        "msg = '" + msg + '\'' +
                        ",code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        "}";
    }
}
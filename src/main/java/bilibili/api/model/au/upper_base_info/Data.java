package bilibili.api.model.au.upper_base_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "uname")
    private String uname;

    @JSONField(name = "avater")
    private String avater;

    @JSONField(name = "sign")
    private String sign;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "uid = '" + uid + '\'' +
                        ",uname = '" + uname + '\'' +
                        ",avater = '" + avater + '\'' +
                        ",sign = '" + sign + '\'' +
                        "}";
    }
}
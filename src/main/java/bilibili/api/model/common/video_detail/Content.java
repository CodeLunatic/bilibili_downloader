package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Content {

    @JSONField(name = "ipi")
    private String ipi;

    @JSONField(name = "members")
    private Object members;

    @JSONField(name = "plat")
    private String plat;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "device")
    private String device;

    public String getIpi() {
        return ipi;
    }

    public void setIpi(String ipi) {
        this.ipi = ipi;
    }

    public Object getMembers() {
        return members;
    }

    public void setMembers(Object members) {
        this.members = members;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return
                "Content{" +
                        "ipi = '" + ipi + '\'' +
                        ",members = '" + members + '\'' +
                        ",plat = '" + plat + '\'' +
                        ",message = '" + message + '\'' +
                        ",device = '" + device + '\'' +
                        "}";
    }
}
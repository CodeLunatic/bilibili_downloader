package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Count {

    @JSONField(name = "view")
    private String view;

    @JSONField(name = "use")
    private String use;

    @JSONField(name = "atten")
    private String atten;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getAtten() {
        return atten;
    }

    public void setAtten(String atten) {
        this.atten = atten;
    }

    @Override
    public String toString() {
        return
                "Count{" +
                        "view = '" + view + '\'' +
                        ",use = '" + use + '\'' +
                        ",atten = '" + atten + '\'' +
                        "}";
    }
}
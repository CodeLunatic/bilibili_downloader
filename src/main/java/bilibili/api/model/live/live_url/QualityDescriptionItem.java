package bilibili.api.model.live.live_url;

import com.alibaba.fastjson.annotation.JSONField;

public class QualityDescriptionItem {

    @JSONField(name = "qn")
    private String qn;

    @JSONField(name = "desc")
    private String desc;

    public String getQn() {
        return qn;
    }

    public void setQn(String qn) {
        this.qn = qn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return
                "QualityDescriptionItem{" +
                        "qn = '" + qn + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
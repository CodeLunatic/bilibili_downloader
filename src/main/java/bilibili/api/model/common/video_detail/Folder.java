package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Folder {

    @JSONField(name = "is_folded")
    private String isFolded;

    @JSONField(name = "rule")
    private String rule;

    @JSONField(name = "has_folded")
    private String hasFolded;

    public void setIsFolded(String isFolded) {
        this.isFolded = isFolded;
    }

    public String isIsFolded() {
        return isFolded;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setHasFolded(String hasFolded) {
        this.hasFolded = hasFolded;
    }

    public String isHasFolded() {
        return hasFolded;
    }

    @Override
    public String toString() {
        return
                "Folder{" +
                        "is_folded = '" + isFolded + '\'' +
                        ",rule = '" + rule + '\'' +
                        ",has_folded = '" + hasFolded + '\'' +
                        "}";
    }
}
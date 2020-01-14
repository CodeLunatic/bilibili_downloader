package bilibili.api.model.ep.new_video_url;

import com.alibaba.fastjson.annotation.JSONField;

public class SegmentBase {

    @JSONField(name = "Initialization")
    private String initialization;

    @JSONField(name = "indexRange")
    private String indexRange;

    public String getInitialization() {
        return initialization;
    }

    public void setInitialization(String initialization) {
        this.initialization = initialization;
    }

    public String getIndexRange() {
        return indexRange;
    }

    public void setIndexRange(String indexRange) {
        this.indexRange = indexRange;
    }

    @Override
    public String toString() {
        return
                "SegmentBase{" +
                        "initialization = '" + initialization + '\'' +
                        ",indexRange = '" + indexRange + '\'' +
                        "}";
    }
}
package bilibili.api.model.live.live_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "current_qn")
    private String currentQn;

    @JSONField(name = "durl")
    private List<DurlItem> durl;

    @JSONField(name = "quality_description")
    private List<QualityDescriptionItem> qualityDescription;

    @JSONField(name = "current_quality")
    private String currentQuality;

    @JSONField(name = "accept_quality")
    private List<String> acceptQuality;

    public String getCurrentQn() {
        return currentQn;
    }

    public void setCurrentQn(String currentQn) {
        this.currentQn = currentQn;
    }

    public List<DurlItem> getDurl() {
        return durl;
    }

    public void setDurl(List<DurlItem> durl) {
        this.durl = durl;
    }

    public List<QualityDescriptionItem> getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(List<QualityDescriptionItem> qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public String getCurrentQuality() {
        return currentQuality;
    }

    public void setCurrentQuality(String currentQuality) {
        this.currentQuality = currentQuality;
    }

    public List<String> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<String> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "current_qn = '" + currentQn + '\'' +
                        ",durl = '" + durl + '\'' +
                        ",quality_description = '" + qualityDescription + '\'' +
                        ",current_quality = '" + currentQuality + '\'' +
                        ",accept_quality = '" + acceptQuality + '\'' +
                        "}";
    }
}
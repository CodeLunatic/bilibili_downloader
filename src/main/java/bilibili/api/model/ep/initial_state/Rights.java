package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Rights {

    @JSONField(name = "canWatch")
    private String canWatch;

    @JSONField(name = "isPreview")
    private String isPreview;

    @JSONField(name = "appOnly")
    private String appOnly;

    @JSONField(name = "isCoverShow")
    private String isCoverShow;

    @JSONField(name = "allowBpRank")
    private String allowBpRank;

    @JSONField(name = "allowBp")
    private String allowBp;

    @JSONField(name = "allowReview")
    private String allowReview;

    @JSONField(name = "limitNotFound")
    private String limitNotFound;

    public void setCanWatch(String canWatch) {
        this.canWatch = canWatch;
    }

    public String isCanWatch() {
        return canWatch;
    }

    public void setIsPreview(String isPreview) {
        this.isPreview = isPreview;
    }

    public String isIsPreview() {
        return isPreview;
    }

    public void setAppOnly(String appOnly) {
        this.appOnly = appOnly;
    }

    public String isAppOnly() {
        return appOnly;
    }

    public void setIsCoverShow(String isCoverShow) {
        this.isCoverShow = isCoverShow;
    }

    public String isIsCoverShow() {
        return isCoverShow;
    }

    public void setAllowBpRank(String allowBpRank) {
        this.allowBpRank = allowBpRank;
    }

    public String isAllowBpRank() {
        return allowBpRank;
    }

    public void setAllowBp(String allowBp) {
        this.allowBp = allowBp;
    }

    public String isAllowBp() {
        return allowBp;
    }

    public void setAllowReview(String allowReview) {
        this.allowReview = allowReview;
    }

    public String isAllowReview() {
        return allowReview;
    }

    public void setLimitNotFound(String limitNotFound) {
        this.limitNotFound = limitNotFound;
    }

    public String isLimitNotFound() {
        return limitNotFound;
    }

    @Override
    public String toString() {
        return
                "Rights{" +
                        "canWatch = '" + canWatch + '\'' +
                        ",isPreview = '" + isPreview + '\'' +
                        ",appOnly = '" + appOnly + '\'' +
                        ",isCoverShow = '" + isCoverShow + '\'' +
                        ",allowBpRank = '" + allowBpRank + '\'' +
                        ",allowBp = '" + allowBp + '\'' +
                        ",allowReview = '" + allowReview + '\'' +
                        ",limitNotFound = '" + limitNotFound + '\'' +
                        "}";
    }
}
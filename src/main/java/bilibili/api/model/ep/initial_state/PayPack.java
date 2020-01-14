package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class PayPack {

    @JSONField(name = "appPayText")
    private String appPayText;

    @JSONField(name = "appNoPayText")
    private String appNoPayText;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "url")
    private String url;

    public String getAppPayText() {
        return appPayText;
    }

    public void setAppPayText(String appPayText) {
        this.appPayText = appPayText;
    }

    public String getAppNoPayText() {
        return appNoPayText;
    }

    public void setAppNoPayText(String appNoPayText) {
        this.appNoPayText = appNoPayText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "PayPack{" +
                        "appPayText = '" + appPayText + '\'' +
                        ",appNoPayText = '" + appNoPayText + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}
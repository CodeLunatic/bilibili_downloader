package bilibili.api.model.common.default_search;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "show_name")
    private String showName;

    @JSONField(name = "seid")
    private String seid;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "goto_value")
    private String gotoValue;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "goto_type")
    private String gotoType;

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGotoValue() {
        return gotoValue;
    }

    public void setGotoValue(String gotoValue) {
        this.gotoValue = gotoValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGotoType() {
        return gotoType;
    }

    public void setGotoType(String gotoType) {
        this.gotoType = gotoType;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "show_name = '" + showName + '\'' +
                        ",seid = '" + seid + '\'' +
                        ",name = '" + name + '\'' +
                        ",goto_value = '" + gotoValue + '\'' +
                        ",id = '" + id + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",goto_type = '" + gotoType + '\'' +
                        "}";
    }
}
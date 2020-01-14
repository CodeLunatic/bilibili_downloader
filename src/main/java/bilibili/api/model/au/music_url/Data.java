package bilibili.api.model.au.music_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "cover")
    private Object cover;

    @JSONField(name = "size")
    private String size;

    @JSONField(name = "cdns")
    private List<String> cdns;

    @JSONField(name = "qualities")
    private Object qualities;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "title")
    private Object title;

    @JSONField(name = "timeout")
    private String timeout;

    @JSONField(name = "sid")
    private String sid;

    @JSONField(name = "info")
    private String info;

    public Object getCover() {
        return cover;
    }

    public void setCover(Object cover) {
        this.cover = cover;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getCdns() {
        return cdns;
    }

    public void setCdns(List<String> cdns) {
        this.cdns = cdns;
    }

    public Object getQualities() {
        return qualities;
    }

    public void setQualities(Object qualities) {
        this.qualities = qualities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "cover = '" + cover + '\'' +
                        ",size = '" + size + '\'' +
                        ",cdns = '" + cdns + '\'' +
                        ",qualities = '" + qualities + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        ",timeout = '" + timeout + '\'' +
                        ",sid = '" + sid + '\'' +
                        ",info = '" + info + '\'' +
                        "}";
    }
}
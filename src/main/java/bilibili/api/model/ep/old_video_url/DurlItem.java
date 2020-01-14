package bilibili.api.model.ep.old_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class DurlItem {

    @JSONField(name = "size")
    private String size;

    @JSONField(name = "ahead")
    private String ahead;

    @JSONField(name = "length")
    private String length;

    @JSONField(name = "vhead")
    private String vhead;

    @JSONField(name = "backup_url")
    private List<String> backupUrl;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "order")
    private String order;

    @JSONField(name = "md5")
    private String md5;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAhead() {
        return ahead;
    }

    public void setAhead(String ahead) {
        this.ahead = ahead;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getVhead() {
        return vhead;
    }

    public void setVhead(String vhead) {
        this.vhead = vhead;
    }

    public List<String> getBackupUrl() {
        return backupUrl;
    }

    public void setBackupUrl(List<String> backupUrl) {
        this.backupUrl = backupUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return
                "DurlItem{" +
                        "size = '" + size + '\'' +
                        ",ahead = '" + ahead + '\'' +
                        ",length = '" + length + '\'' +
                        ",vhead = '" + vhead + '\'' +
                        ",backup_url = '" + backupUrl + '\'' +
                        ",url = '" + url + '\'' +
                        ",order = '" + order + '\'' +
                        ",md5 = '" + md5 + '\'' +
                        "}";
    }
}
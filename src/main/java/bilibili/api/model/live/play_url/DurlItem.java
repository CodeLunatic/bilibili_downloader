package bilibili.api.model.live.play_url;

import com.alibaba.fastjson.annotation.JSONField;

public class DurlItem {

    @JSONField(name = "size")
    private String size;

    @JSONField(name = "length")
    private String length;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "order")
    private String order;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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

    @Override
    public String toString() {
        return
                "DurlItem{" +
                        "size = '" + size + '\'' +
                        ",length = '" + length + '\'' +
                        ",url = '" + url + '\'' +
                        ",order = '" + order + '\'' +
                        "}";
    }
}
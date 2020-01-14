package bilibili.api.model.live.live_url;

import com.alibaba.fastjson.annotation.JSONField;

public class DurlItem {

    @JSONField(name = "length")
    private String length;

    @JSONField(name = "stream_type")
    private String streamType;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "order")
    private String order;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
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
                        "length = '" + length + '\'' +
                        ",stream_type = '" + streamType + '\'' +
                        ",url = '" + url + '\'' +
                        ",order = '" + order + '\'' +
                        "}";
    }
}
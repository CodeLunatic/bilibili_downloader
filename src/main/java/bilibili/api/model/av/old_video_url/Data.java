package bilibili.api.model.av.old_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "accept_format")
    private String acceptFormat;

    @JSONField(name = "durl")
    private List<DurlItem> durl;

    @JSONField(name = "seek_param")
    private String seekParam;

    @JSONField(name = "format")
    private String format;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "accept_quality")
    private List<Integer> acceptQuality;

    @JSONField(name = "quality")
    private String quality;

    @JSONField(name = "timelength")
    private String timelength;

    @JSONField(name = "result")
    private String result;

    @JSONField(name = "seek_type")
    private String seekType;

    @JSONField(name = "from")
    private String from;

    @JSONField(name = "video_codecid")
    private String videoCodecid;

    @JSONField(name = "accept_description")
    private List<String> acceptDescription;

    public String getAcceptFormat() {
        return acceptFormat;
    }

    public void setAcceptFormat(String acceptFormat) {
        this.acceptFormat = acceptFormat;
    }

    public List<DurlItem> getDurl() {
        return durl;
    }

    public void setDurl(List<DurlItem> durl) {
        this.durl = durl;
    }

    public String getSeekParam() {
        return seekParam;
    }

    public void setSeekParam(String seekParam) {
        this.seekParam = seekParam;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<Integer> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTimelength() {
        return timelength;
    }

    public void setTimelength(String timelength) {
        this.timelength = timelength;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeekType() {
        return seekType;
    }

    public void setSeekType(String seekType) {
        this.seekType = seekType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getVideoCodecid() {
        return videoCodecid;
    }

    public void setVideoCodecid(String videoCodecid) {
        this.videoCodecid = videoCodecid;
    }

    public List<String> getAcceptDescription() {
        return acceptDescription;
    }

    public void setAcceptDescription(List<String> acceptDescription) {
        this.acceptDescription = acceptDescription;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "accept_format = '" + acceptFormat + '\'' +
                        ",durl = '" + durl + '\'' +
                        ",seek_param = '" + seekParam + '\'' +
                        ",format = '" + format + '\'' +
                        ",message = '" + message + '\'' +
                        ",accept_quality = '" + acceptQuality + '\'' +
                        ",quality = '" + quality + '\'' +
                        ",timelength = '" + timelength + '\'' +
                        ",result = '" + result + '\'' +
                        ",seek_type = '" + seekType + '\'' +
                        ",from = '" + from + '\'' +
                        ",video_codecid = '" + videoCodecid + '\'' +
                        ",accept_description = '" + acceptDescription + '\'' +
                        "}";
    }
}
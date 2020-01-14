package bilibili.api.model.ep.new_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Result {

    @JSONField(name = "accept_format")
    private String acceptFormat;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "seek_param")
    private String seekParam;

    @JSONField(name = "is_preview")
    private String isPreview;

    @JSONField(name = "no_rexcode")
    private String noRexcode;

    @JSONField(name = "format")
    private String format;

    @JSONField(name = "fnval")
    private String fnval;

    @JSONField(name = "video_project")
    private String videoProject;

    @JSONField(name = "fnver")
    private String fnver;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "accept_quality")
    private List<Integer> acceptQuality;

    @JSONField(name = "bp")
    private String bp;

    @JSONField(name = "quality")
    private String quality;

    @JSONField(name = "timelength")
    private String timelength;

    @JSONField(name = "result")
    private String result;

    @JSONField(name = "seek_type")
    private String seekType;

    @JSONField(name = "has_paid")
    private String hasPaid;

    @JSONField(name = "from")
    private String from;

    @JSONField(name = "dash")
    private Dash dash;

    @JSONField(name = "video_codecid")
    private String videoCodecid;

    @JSONField(name = "accept_description")
    private List<String> acceptDescription;

    @JSONField(name = "status")
    private String status;

    public String getAcceptFormat() {
        return acceptFormat;
    }

    public void setAcceptFormat(String acceptFormat) {
        this.acceptFormat = acceptFormat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeekParam() {
        return seekParam;
    }

    public void setSeekParam(String seekParam) {
        this.seekParam = seekParam;
    }

    public String getIsPreview() {
        return isPreview;
    }

    public void setIsPreview(String isPreview) {
        this.isPreview = isPreview;
    }

    public String getNoRexcode() {
        return noRexcode;
    }

    public void setNoRexcode(String noRexcode) {
        this.noRexcode = noRexcode;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFnval() {
        return fnval;
    }

    public void setFnval(String fnval) {
        this.fnval = fnval;
    }

    public void setVideoProject(String videoProject) {
        this.videoProject = videoProject;
    }

    public String isVideoProject() {
        return videoProject;
    }

    public String getFnver() {
        return fnver;
    }

    public void setFnver(String fnver) {
        this.fnver = fnver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<Integer> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
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

    public void setHasPaid(String hasPaid) {
        this.hasPaid = hasPaid;
    }

    public String isHasPaid() {
        return hasPaid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Dash getDash() {
        return dash;
    }

    public void setDash(Dash dash) {
        this.dash = dash;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "Result{" +
                        "accept_format = '" + acceptFormat + '\'' +
                        ",code = '" + code + '\'' +
                        ",seek_param = '" + seekParam + '\'' +
                        ",is_preview = '" + isPreview + '\'' +
                        ",no_rexcode = '" + noRexcode + '\'' +
                        ",format = '" + format + '\'' +
                        ",fnval = '" + fnval + '\'' +
                        ",video_project = '" + videoProject + '\'' +
                        ",fnver = '" + fnver + '\'' +
                        ",message = '" + message + '\'' +
                        ",type = '" + type + '\'' +
                        ",accept_quality = '" + acceptQuality + '\'' +
                        ",bp = '" + bp + '\'' +
                        ",quality = '" + quality + '\'' +
                        ",timelength = '" + timelength + '\'' +
                        ",result = '" + result + '\'' +
                        ",seek_type = '" + seekType + '\'' +
                        ",has_paid = '" + hasPaid + '\'' +
                        ",from = '" + from + '\'' +
                        ",dash = '" + dash + '\'' +
                        ",video_codecid = '" + videoCodecid + '\'' +
                        ",accept_description = '" + acceptDescription + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
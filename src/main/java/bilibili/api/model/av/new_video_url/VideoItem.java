package bilibili.api.model.av.new_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class VideoItem {

    @JSONField(name = "start_with_sap")
    private String startWithSap;

    @JSONField(name = "backupUrl")
    private List<String> backupUrl;

    @JSONField(name = "bandwidth")
    private String bandwidth;

    @JSONField(name = "sar")
    private String sar;

    @JSONField(name = "codecs")
    private String codecs;

    @JSONField(name = "base_url")
    private String baseUrl;

    @JSONField(name = "mimeType")
    private String mimeType;

    @JSONField(name = "segment_base")
    private SegmentBase segmentBase;

    @JSONField(name = "frame_rate")
    private String frameRate;

    @JSONField(name = "codecid")
    private String codecid;

    @JSONField(name = "width")
    private String width;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "height")
    private String height;

    public String getStartWithSap() {
        return startWithSap;
    }

    public void setStartWithSap(String startWithSap) {
        this.startWithSap = startWithSap;
    }

    public List<String> getBackupUrl() {
        return backupUrl;
    }

    public void setBackupUrl(List<String> backupUrl) {
        this.backupUrl = backupUrl;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getSar() {
        return sar;
    }

    public void setSar(String sar) {
        this.sar = sar;
    }

    public String getCodecs() {
        return codecs;
    }

    public void setCodecs(String codecs) {
        this.codecs = codecs;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public SegmentBase getSegmentBase() {
        return segmentBase;
    }

    public void setSegmentBase(SegmentBase segmentBase) {
        this.segmentBase = segmentBase;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getCodecid() {
        return codecid;
    }

    public void setCodecid(String codecid) {
        this.codecid = codecid;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
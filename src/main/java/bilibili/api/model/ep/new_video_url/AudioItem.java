package bilibili.api.model.ep.new_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class AudioItem {

    @JSONField(name = "bandwidth")
    private String bandwidth;

    @JSONField(name = "sar")
    private String sar;

    @JSONField(name = "backupUrl")
    private List<String> backupUrl;

    @JSONField(name = "codecs")
    private String codecs;

    @JSONField(name = "base_url")
    private String baseUrl;


    @JSONField(name = "mimeType")
    private String mimeType;

    @JSONField(name = "SegmentBase")
    private SegmentBase segmentBase;

    @JSONField(name = "frameRate")
    private String frameRate;

    @JSONField(name = "codecid")
    private String codecid;


    @JSONField(name = "size")
    private String size;

    @JSONField(name = "width")
    private String width;

    @JSONField(name = "startWithSAP")
    private String startWithSAP;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "height")
    private String height;

    @JSONField(name = "md5")
    private String md5;

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

    public List<String> getBackupUrl() {
        return backupUrl;
    }

    public void setBackupUrl(List<String> backupUrl) {
        this.backupUrl = backupUrl;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getStartWithSAP() {
        return startWithSAP;
    }

    public void setStartWithSAP(String startWithSAP) {
        this.startWithSAP = startWithSAP;
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
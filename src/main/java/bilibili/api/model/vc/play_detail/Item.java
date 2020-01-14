package bilibili.api.model.vc.play_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Item {

    @JSONField(name = "video_time")
    private String videoTime;

    @JSONField(name = "backup_playurl")
    private List<String> backupPlayurl;

    @JSONField(name = "verify_status_text")
    private String verifyStatusText;

    @JSONField(name = "first_pic")
    private String firstPic;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "at_control")
    private String atControl;

    @JSONField(name = "cover")
    private Cover cover;

    @JSONField(name = "jump_url")
    private String jumpUrl;

    @JSONField(name = "video_size")
    private String videoSize;

    @JSONField(name = "video_playurl")
    private String videoPlayurl;

    @JSONField(name = "verify_status")
    private String verifyStatus;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "reply")
    private String reply;

    @JSONField(name = "height")
    private String height;

    @JSONField(name = "share_num")
    private String shareNum;

    @JSONField(name = "is_fav")
    private String isFav;

    @JSONField(name = "damaku_num")
    private String damakuNum;

    @JSONField(name = "cfrom")
    private String cfrom;

    @JSONField(name = "tags")
    private List<String> tags;

    @JSONField(name = "upload_time")
    private String uploadTime;

    @JSONField(name = "share_url")
    private String shareUrl;

    @JSONField(name = "width")
    private String width;

    @JSONField(name = "enshrine_num")
    private String enshrineNum;

    @JSONField(name = "support_num")
    private String supportNum;

    @JSONField(name = "watched_num")
    private String watchedNum;

    @JSONField(name = "upload_time_text")
    private String uploadTimeText;

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public List<String> getBackupPlayurl() {
        return backupPlayurl;
    }

    public void setBackupPlayurl(List<String> backupPlayurl) {
        this.backupPlayurl = backupPlayurl;
    }

    public String getVerifyStatusText() {
        return verifyStatusText;
    }

    public void setVerifyStatusText(String verifyStatusText) {
        this.verifyStatusText = verifyStatusText;
    }

    public String getFirstPic() {
        return firstPic;
    }

    public void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAtControl() {
        return atControl;
    }

    public void setAtControl(String atControl) {
        this.atControl = atControl;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(String videoSize) {
        this.videoSize = videoSize;
    }

    public String getVideoPlayurl() {
        return videoPlayurl;
    }

    public void setVideoPlayurl(String videoPlayurl) {
        this.videoPlayurl = videoPlayurl;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }

    public void setIsFav(String isFav) {
        this.isFav = isFav;
    }

    public String isIsFav() {
        return isFav;
    }

    public String getDamakuNum() {
        return damakuNum;
    }

    public void setDamakuNum(String damakuNum) {
        this.damakuNum = damakuNum;
    }

    public String getCfrom() {
        return cfrom;
    }

    public void setCfrom(String cfrom) {
        this.cfrom = cfrom;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getEnshrineNum() {
        return enshrineNum;
    }

    public void setEnshrineNum(String enshrineNum) {
        this.enshrineNum = enshrineNum;
    }

    public String getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(String supportNum) {
        this.supportNum = supportNum;
    }

    public String getWatchedNum() {
        return watchedNum;
    }

    public void setWatchedNum(String watchedNum) {
        this.watchedNum = watchedNum;
    }

    public String getUploadTimeText() {
        return uploadTimeText;
    }

    public void setUploadTimeText(String uploadTimeText) {
        this.uploadTimeText = uploadTimeText;
    }

    @Override
    public String toString() {
        return
                "Item{" +
                        "video_time = '" + videoTime + '\'' +
                        ",backup_playurl = '" + backupPlayurl + '\'' +
                        ",verify_status_text = '" + verifyStatusText + '\'' +
                        ",first_pic = '" + firstPic + '\'' +
                        ",description = '" + description + '\'' +
                        ",type = '" + type + '\'' +
                        ",at_control = '" + atControl + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",jump_url = '" + jumpUrl + '\'' +
                        ",video_size = '" + videoSize + '\'' +
                        ",video_playurl = '" + videoPlayurl + '\'' +
                        ",verify_status = '" + verifyStatus + '\'' +
                        ",id = '" + id + '\'' +
                        ",reply = '" + reply + '\'' +
                        ",height = '" + height + '\'' +
                        ",share_num = '" + shareNum + '\'' +
                        ",is_fav = '" + isFav + '\'' +
                        ",damaku_num = '" + damakuNum + '\'' +
                        ",cfrom = '" + cfrom + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",upload_time = '" + uploadTime + '\'' +
                        ",share_url = '" + shareUrl + '\'' +
                        ",width = '" + width + '\'' +
                        ",enshrine_num = '" + enshrineNum + '\'' +
                        ",support_num = '" + supportNum + '\'' +
                        ",watched_num = '" + watchedNum + '\'' +
                        ",upload_time_text = '" + uploadTimeText + '\'' +
                        "}";
    }
}
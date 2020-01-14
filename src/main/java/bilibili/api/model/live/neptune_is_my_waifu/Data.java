package bilibili.api.model.live.neptune_is_my_waifu;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "current_qn")
    private String currentQn;

    @JSONField(name = "durl")
    private List<DurlItem> durl;

    @JSONField(name = "quality_description")
    private List<QualityDescriptionItem> qualityDescription;

    @JSONField(name = "current_quality")
    private String currentQuality;

    @JSONField(name = "accept_quality")
    private List<String> acceptQuality;

    @JSONField(name = "room_id")
    private String roomId;

    @JSONField(name = "area_name")
    private String areaName;

    @JSONField(name = "is_anchor")
    private String isAnchor;

    @JSONField(name = "room_silent_level")
    private String roomSilentLevel;

    @JSONField(name = "new_pendants")
    private NewPendants newPendants;

    @JSONField(name = "pk_id")
    private String pkId;

    @JSONField(name = "old_area_id")
    private String oldAreaId;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "area_id")
    private String areaId;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "up_session")
    private String upSession;

    @JSONField(name = "verify")
    private String verify;

    @JSONField(name = "room_silent_type")
    private String roomSilentType;

    @JSONField(name = "room_silent_second")
    private String roomSilentSecond;

    @JSONField(name = "parent_area_id")
    private String parentAreaId;

    @JSONField(name = "allow_upload_cover_time")
    private String allowUploadCoverTime;

    @JSONField(name = "live_status")
    private String liveStatus;

    @JSONField(name = "live_time")
    private String liveTime;

    @JSONField(name = "hot_words")
    private List<String> hotWords;

    @JSONField(name = "battle_id")
    private String battleId;

    @JSONField(name = "pendants")
    private String pendants;

    @JSONField(name = "short_id")
    private String shortId;

    @JSONField(name = "user_cover")
    private String userCover;

    @JSONField(name = "hot_words_status")
    private String hotWordsStatus;

    @JSONField(name = "allow_change_area_time")
    private String allowChangeAreaTime;

    @JSONField(name = "keyframe")
    private String keyframe;

    @JSONField(name = "tags")
    private String tags;

    @JSONField(name = "studio_info")
    private StudioInfo studioInfo;

    @JSONField(name = "parent_area_name")
    private String parentAreaName;

    @JSONField(name = "background")
    private String background;

    @JSONField(name = "is_portrait")
    private String isPortrait;

    @JSONField(name = "area_pendants")
    private String areaPendants;

    @JSONField(name = "attention")
    private String attention;

    @JSONField(name = "online")
    private String online;

    @JSONField(name = "pk_status")
    private String pkStatus;

    @JSONField(name = "is_strict_room")
    private String isStrictRoom;

    @JSONField(name = "special_type")
    private String specialType;

    @JSONField(name = "is_locked")
    private String isLocked;

    @JSONField(name = "is_hidden")
    private String isHidden;

    @JSONField(name = "is_sp")
    private String isSp;

    @JSONField(name = "encrypted")
    private String encrypted;

    @JSONField(name = "pwd_verified")
    private String pwdVerified;

    @JSONField(name = "lock_till")
    private String lockTill;

    @JSONField(name = "need_p2p")
    private String needP2p;

    @JSONField(name = "hidden_till")
    private String hiddenTill;

    @JSONField(name = "room_shield")
    private String roomShield;

    public String getCurrentQn() {
        return currentQn;
    }

    public void setCurrentQn(String currentQn) {
        this.currentQn = currentQn;
    }

    public List<DurlItem> getDurl() {
        return durl;
    }

    public void setDurl(List<DurlItem> durl) {
        this.durl = durl;
    }

    public List<QualityDescriptionItem> getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(List<QualityDescriptionItem> qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public String getCurrentQuality() {
        return currentQuality;
    }

    public void setCurrentQuality(String currentQuality) {
        this.currentQuality = currentQuality;
    }

    public List<String> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<String> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getIsAnchor() {
        return isAnchor;
    }

    public void setIsAnchor(String isAnchor) {
        this.isAnchor = isAnchor;
    }

    public String getRoomSilentLevel() {
        return roomSilentLevel;
    }

    public void setRoomSilentLevel(String roomSilentLevel) {
        this.roomSilentLevel = roomSilentLevel;
    }

    public NewPendants getNewPendants() {
        return newPendants;
    }

    public void setNewPendants(NewPendants newPendants) {
        this.newPendants = newPendants;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getOldAreaId() {
        return oldAreaId;
    }

    public void setOldAreaId(String oldAreaId) {
        this.oldAreaId = oldAreaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpSession() {
        return upSession;
    }

    public void setUpSession(String upSession) {
        this.upSession = upSession;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getRoomSilentType() {
        return roomSilentType;
    }

    public void setRoomSilentType(String roomSilentType) {
        this.roomSilentType = roomSilentType;
    }

    public String getRoomSilentSecond() {
        return roomSilentSecond;
    }

    public void setRoomSilentSecond(String roomSilentSecond) {
        this.roomSilentSecond = roomSilentSecond;
    }

    public String getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(String parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getAllowUploadCoverTime() {
        return allowUploadCoverTime;
    }

    public void setAllowUploadCoverTime(String allowUploadCoverTime) {
        this.allowUploadCoverTime = allowUploadCoverTime;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public String getPendants() {
        return pendants;
    }

    public void setPendants(String pendants) {
        this.pendants = pendants;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getUserCover() {
        return userCover;
    }

    public void setUserCover(String userCover) {
        this.userCover = userCover;
    }

    public String getHotWordsStatus() {
        return hotWordsStatus;
    }

    public void setHotWordsStatus(String hotWordsStatus) {
        this.hotWordsStatus = hotWordsStatus;
    }

    public String getAllowChangeAreaTime() {
        return allowChangeAreaTime;
    }

    public void setAllowChangeAreaTime(String allowChangeAreaTime) {
        this.allowChangeAreaTime = allowChangeAreaTime;
    }

    public String getKeyframe() {
        return keyframe;
    }

    public void setKeyframe(String keyframe) {
        this.keyframe = keyframe;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public StudioInfo getStudioInfo() {
        return studioInfo;
    }

    public void setStudioInfo(StudioInfo studioInfo) {
        this.studioInfo = studioInfo;
    }

    public String getParentAreaName() {
        return parentAreaName;
    }

    public void setParentAreaName(String parentAreaName) {
        this.parentAreaName = parentAreaName;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setIsPortrait(String isPortrait) {
        this.isPortrait = isPortrait;
    }

    public String isIsPortrait() {
        return isPortrait;
    }

    public String getAreaPendants() {
        return areaPendants;
    }

    public void setAreaPendants(String areaPendants) {
        this.areaPendants = areaPendants;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getPkStatus() {
        return pkStatus;
    }

    public void setPkStatus(String pkStatus) {
        this.pkStatus = pkStatus;
    }

    public void setIsStrictRoom(String isStrictRoom) {
        this.isStrictRoom = isStrictRoom;
    }

    public String isIsStrictRoom() {
        return isStrictRoom;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public String isIsLocked() {
        return isLocked;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }

    public String isIsHidden() {
        return isHidden;
    }

    public String getIsSp() {
        return isSp;
    }

    public void setIsSp(String isSp) {
        this.isSp = isSp;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public String isEncrypted() {
        return encrypted;
    }

    public void setPwdVerified(String pwdVerified) {
        this.pwdVerified = pwdVerified;
    }

    public String isPwdVerified() {
        return pwdVerified;
    }

    public String getLockTill() {
        return lockTill;
    }

    public void setLockTill(String lockTill) {
        this.lockTill = lockTill;
    }

    public String getNeedP2p() {
        return needP2p;
    }

    public void setNeedP2p(String needP2p) {
        this.needP2p = needP2p;
    }

    public String getHiddenTill() {
        return hiddenTill;
    }

    public void setHiddenTill(String hiddenTill) {
        this.hiddenTill = hiddenTill;
    }

    public String getRoomShield() {
        return roomShield;
    }

    public void setRoomShield(String roomShield) {
        this.roomShield = roomShield;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "current_qn = '" + currentQn + '\'' +
                        ",durl = '" + durl + '\'' +
                        ",quality_description = '" + qualityDescription + '\'' +
                        ",current_quality = '" + currentQuality + '\'' +
                        ",accept_quality = '" + acceptQuality + '\'' +
                        ",room_id = '" + roomId + '\'' +
                        ",area_name = '" + areaName + '\'' +
                        ",is_anchor = '" + isAnchor + '\'' +
                        ",room_silent_level = '" + roomSilentLevel + '\'' +
                        ",new_pendants = '" + newPendants + '\'' +
                        ",pk_id = '" + pkId + '\'' +
                        ",old_area_id = '" + oldAreaId + '\'' +
                        ",description = '" + description + '\'' +
                        ",area_id = '" + areaId + '\'' +
                        ",title = '" + title + '\'' +
                        ",uid = '" + uid + '\'' +
                        ",up_session = '" + upSession + '\'' +
                        ",verify = '" + verify + '\'' +
                        ",room_silent_type = '" + roomSilentType + '\'' +
                        ",room_silent_second = '" + roomSilentSecond + '\'' +
                        ",parent_area_id = '" + parentAreaId + '\'' +
                        ",allow_upload_cover_time = '" + allowUploadCoverTime + '\'' +
                        ",live_status = '" + liveStatus + '\'' +
                        ",live_time = '" + liveTime + '\'' +
                        ",hot_words = '" + hotWords + '\'' +
                        ",battle_id = '" + battleId + '\'' +
                        ",pendants = '" + pendants + '\'' +
                        ",short_id = '" + shortId + '\'' +
                        ",user_cover = '" + userCover + '\'' +
                        ",hot_words_status = '" + hotWordsStatus + '\'' +
                        ",allow_change_area_time = '" + allowChangeAreaTime + '\'' +
                        ",keyframe = '" + keyframe + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",studio_info = '" + studioInfo + '\'' +
                        ",parent_area_name = '" + parentAreaName + '\'' +
                        ",background = '" + background + '\'' +
                        ",is_portrait = '" + isPortrait + '\'' +
                        ",area_pendants = '" + areaPendants + '\'' +
                        ",attention = '" + attention + '\'' +
                        ",online = '" + online + '\'' +
                        ",pk_status = '" + pkStatus + '\'' +
                        ",is_strict_room = '" + isStrictRoom + '\'' +
                        ",special_type = '" + specialType + '\'' +
                        ",is_locked = '" + isLocked + '\'' +
                        ",is_hidden = '" + isHidden + '\'' +
                        ",is_sp = '" + isSp + '\'' +
                        ",encrypted = '" + encrypted + '\'' +
                        ",pwd_verified = '" + pwdVerified + '\'' +
                        ",lock_till = '" + lockTill + '\'' +
                        ",need_p2p = '" + needP2p + '\'' +
                        ",hidden_till = '" + hiddenTill + '\'' +
                        ",room_shield = '" + roomShield + '\'' +
                        "}";
    }
}
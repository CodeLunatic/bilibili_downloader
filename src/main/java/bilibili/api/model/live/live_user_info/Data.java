package bilibili.api.model.live.live_user_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "user_charged")
    private String userCharged;

    @JSONField(name = "user_intimacy")
    private String userIntimacy;

    @JSONField(name = "is_level_top")
    private String isLevelTop;

    @JSONField(name = "uname")
    private String uname;

    @JSONField(name = "billCoin")
    private String billCoin;

    @JSONField(name = "achieve")
    private String achieve;

    @JSONField(name = "user_next_level")
    private String userNextLevel;

    @JSONField(name = "gold")
    private String gold;

    @JSONField(name = "user_level_rank")
    private String userLevelRank;

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "face")
    private String face;

    @JSONField(name = "user_level")
    private String userLevel;

    @JSONField(name = "silver")
    private String silver;

    @JSONField(name = "vip")
    private String vip;

    @JSONField(name = "svip")
    private String svip;

    @JSONField(name = "user_next_intimacy")
    private String userNextIntimacy;

    public String getUserCharged() {
        return userCharged;
    }

    public void setUserCharged(String userCharged) {
        this.userCharged = userCharged;
    }

    public String getUserIntimacy() {
        return userIntimacy;
    }

    public void setUserIntimacy(String userIntimacy) {
        this.userIntimacy = userIntimacy;
    }

    public String getIsLevelTop() {
        return isLevelTop;
    }

    public void setIsLevelTop(String isLevelTop) {
        this.isLevelTop = isLevelTop;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getBillCoin() {
        return billCoin;
    }

    public void setBillCoin(String billCoin) {
        this.billCoin = billCoin;
    }

    public String getAchieve() {
        return achieve;
    }

    public void setAchieve(String achieve) {
        this.achieve = achieve;
    }

    public String getUserNextLevel() {
        return userNextLevel;
    }

    public void setUserNextLevel(String userNextLevel) {
        this.userNextLevel = userNextLevel;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getUserLevelRank() {
        return userLevelRank;
    }

    public void setUserLevelRank(String userLevelRank) {
        this.userLevelRank = userLevelRank;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getSvip() {
        return svip;
    }

    public void setSvip(String svip) {
        this.svip = svip;
    }

    public String getUserNextIntimacy() {
        return userNextIntimacy;
    }

    public void setUserNextIntimacy(String userNextIntimacy) {
        this.userNextIntimacy = userNextIntimacy;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "user_charged = '" + userCharged + '\'' +
                        ",user_intimacy = '" + userIntimacy + '\'' +
                        ",is_level_top = '" + isLevelTop + '\'' +
                        ",uname = '" + uname + '\'' +
                        ",billCoin = '" + billCoin + '\'' +
                        ",achieve = '" + achieve + '\'' +
                        ",user_next_level = '" + userNextLevel + '\'' +
                        ",gold = '" + gold + '\'' +
                        ",user_level_rank = '" + userLevelRank + '\'' +
                        ",uid = '" + uid + '\'' +
                        ",face = '" + face + '\'' +
                        ",user_level = '" + userLevel + '\'' +
                        ",silver = '" + silver + '\'' +
                        ",vip = '" + vip + '\'' +
                        ",svip = '" + svip + '\'' +
                        ",user_next_intimacy = '" + userNextIntimacy + '\'' +
                        "}";
    }
}
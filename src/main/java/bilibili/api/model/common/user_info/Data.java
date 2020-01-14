package bilibili.api.model.common.user_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "officialVerify")
    private OfficialVerify officialVerify;

    @JSONField(name = "email_verified")
    private String emailVerified;

    @JSONField(name = "wallet")
    private Wallet wallet;

    @JSONField(name = "uname")
    private String uname;

    @JSONField(name = "scores")
    private String scores;

    @JSONField(name = "vipDueDate")
    private String vipDueDate;

    @JSONField(name = "mid")
    private String mid;

    @JSONField(name = "official")
    private Official official;

    @JSONField(name = "vipType")
    private String vipType;

    @JSONField(name = "pendant")
    private Pendant pendant;

    @JSONField(name = "moral")
    private String moral;

    @JSONField(name = "isLogin")
    private String isLogin;

    @JSONField(name = "allowance_count")
    private String allowanceCount;

    @JSONField(name = "face")
    private String face;

    @JSONField(name = "vip_pay_type")
    private String vipPayType;

    @JSONField(name = "mobile_verified")
    private String mobileVerified;

    @JSONField(name = "money")
    private String money;

    @JSONField(name = "shop_url")
    private String shopUrl;

    @JSONField(name = "level_info")
    private LevelInfo levelInfo;

    @JSONField(name = "vipStatus")
    private String vipStatus;

    @JSONField(name = "vip_theme_type")
    private String vipThemeType;

    @JSONField(name = "has_shop")
    private String hasShop;

    public OfficialVerify getOfficialVerify() {
        return officialVerify;
    }

    public void setOfficialVerify(OfficialVerify officialVerify) {
        this.officialVerify = officialVerify;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getVipDueDate() {
        return vipDueDate;
    }

    public void setVipDueDate(String vipDueDate) {
        this.vipDueDate = vipDueDate;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public Pendant getPendant() {
        return pendant;
    }

    public void setPendant(Pendant pendant) {
        this.pendant = pendant;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String isIsLogin() {
        return isLogin;
    }

    public String getAllowanceCount() {
        return allowanceCount;
    }

    public void setAllowanceCount(String allowanceCount) {
        this.allowanceCount = allowanceCount;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getVipPayType() {
        return vipPayType;
    }

    public void setVipPayType(String vipPayType) {
        this.vipPayType = vipPayType;
    }

    public String getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(String mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getVipThemeType() {
        return vipThemeType;
    }

    public void setVipThemeType(String vipThemeType) {
        this.vipThemeType = vipThemeType;
    }

    public void setHasShop(String hasShop) {
        this.hasShop = hasShop;
    }

    public String isHasShop() {
        return hasShop;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "officialVerify = '" + officialVerify + '\'' +
                        ",email_verified = '" + emailVerified + '\'' +
                        ",wallet = '" + wallet + '\'' +
                        ",uname = '" + uname + '\'' +
                        ",scores = '" + scores + '\'' +
                        ",vipDueDate = '" + vipDueDate + '\'' +
                        ",mid = '" + mid + '\'' +
                        ",official = '" + official + '\'' +
                        ",vipType = '" + vipType + '\'' +
                        ",pendant = '" + pendant + '\'' +
                        ",moral = '" + moral + '\'' +
                        ",isLogin = '" + isLogin + '\'' +
                        ",allowance_count = '" + allowanceCount + '\'' +
                        ",face = '" + face + '\'' +
                        ",vip_pay_type = '" + vipPayType + '\'' +
                        ",mobile_verified = '" + mobileVerified + '\'' +
                        ",money = '" + money + '\'' +
                        ",shop_url = '" + shopUrl + '\'' +
                        ",level_info = '" + levelInfo + '\'' +
                        ",vipStatus = '" + vipStatus + '\'' +
                        ",vip_theme_type = '" + vipThemeType + '\'' +
                        ",has_shop = '" + hasShop + '\'' +
                        "}";
    }
}
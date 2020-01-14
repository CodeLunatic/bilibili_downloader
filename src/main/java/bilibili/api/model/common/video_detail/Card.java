package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Card {

    @JSONField(name = "follower")
    private String follower;

    @JSONField(name = "article_count")
    private String articleCount;

    @JSONField(name = "following")
    private String following;

    @JSONField(name = "card")
    private Card card;

    @JSONField(name = "archive_count")
    private String archiveCount;

    @JSONField(name = "regtime")
    private String regtime;

    @JSONField(name = "birthday")
    private String birthday;

    @JSONField(name = "sex")
    private String sex;

    @JSONField(name = "attentions")
    private List<Object> attentions;

    @JSONField(name = "sign")
    private String sign;

    @JSONField(name = "mid")
    private String mid;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "pendant")
    private Pendant pendant;

    @JSONField(name = "official_verify")
    private OfficialVerify officialVerify;

    @JSONField(name = "article")
    private String article;

    @JSONField(name = "fans")
    private String fans;

    @JSONField(name = "face")
    private String face;

    @JSONField(name = "spacesta")
    private String spacesta;

    @JSONField(name = "approve")
    private String approve;

    @JSONField(name = "Official")
    private Official official;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "friend")
    private String friend;

    @JSONField(name = "rank")
    private String rank;

    @JSONField(name = "DisplayRank")
    private String displayRank;

    @JSONField(name = "attention")
    private String attention;

    @JSONField(name = "level_info")
    private LevelInfo levelInfo;

    @JSONField(name = "place")
    private String place;

    @JSONField(name = "nameplate")
    private Nameplate nameplate;

    @JSONField(name = "vip")
    private Vip vip;

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String isFollowing() {
        return following;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getArchiveCount() {
        return archiveCount;
    }

    public void setArchiveCount(String archiveCount) {
        this.archiveCount = archiveCount;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Object> getAttentions() {
        return attentions;
    }

    public void setAttentions(List<Object> attentions) {
        this.attentions = attentions;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pendant getPendant() {
        return pendant;
    }

    public void setPendant(Pendant pendant) {
        this.pendant = pendant;
    }

    public OfficialVerify getOfficialVerify() {
        return officialVerify;
    }

    public void setOfficialVerify(OfficialVerify officialVerify) {
        this.officialVerify = officialVerify;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSpacesta() {
        return spacesta;
    }

    public void setSpacesta(String spacesta) {
        this.spacesta = spacesta;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    public String isApprove() {
        return approve;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDisplayRank() {
        return displayRank;
    }

    public void setDisplayRank(String displayRank) {
        this.displayRank = displayRank;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Nameplate getNameplate() {
        return nameplate;
    }

    public void setNameplate(Nameplate nameplate) {
        this.nameplate = nameplate;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return
                "Card{" +
                        "follower = '" + follower + '\'' +
                        ",article_count = '" + articleCount + '\'' +
                        ",following = '" + following + '\'' +
                        ",card = '" + card + '\'' +
                        ",archive_count = '" + archiveCount + '\'' +
                        ",regtime = '" + regtime + '\'' +
                        ",birthday = '" + birthday + '\'' +
                        ",sex = '" + sex + '\'' +
                        ",attentions = '" + attentions + '\'' +
                        ",sign = '" + sign + '\'' +
                        ",mid = '" + mid + '\'' +
                        ",description = '" + description + '\'' +
                        ",pendant = '" + pendant + '\'' +
                        ",official_verify = '" + officialVerify + '\'' +
                        ",article = '" + article + '\'' +
                        ",fans = '" + fans + '\'' +
                        ",face = '" + face + '\'' +
                        ",spacesta = '" + spacesta + '\'' +
                        ",approve = '" + approve + '\'' +
                        ",official = '" + official + '\'' +
                        ",name = '" + name + '\'' +
                        ",friend = '" + friend + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",displayRank = '" + displayRank + '\'' +
                        ",attention = '" + attention + '\'' +
                        ",level_info = '" + levelInfo + '\'' +
                        ",place = '" + place + '\'' +
                        ",nameplate = '" + nameplate + '\'' +
                        ",vip = '" + vip + '\'' +
                        "}";
    }
}
package bilibili.api.model.au.music_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "curtime")
    private String curtime;

    @JSONField(name = "statistic")
    private Statistic statistic;

    @JSONField(name = "uname")
    private String uname;

    @JSONField(name = "crtype")
    private String crtype;

    @JSONField(name = "author")
    private String author;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "duration")
    private String duration;

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "activityId")
    private String activityId;

    @JSONField(name = "msid")
    private String msid;

    @JSONField(name = "vipInfo")
    private VipInfo vipInfo;

    @JSONField(name = "limitdesc")
    private String limitdesc;

    @JSONField(name = "lyric")
    private String lyric;

    @JSONField(name = "passtime")
    private String passtime;

    @JSONField(name = "intro")
    private String intro;

    @JSONField(name = "coin_num")
    private String coinNum;

    @JSONField(name = "limit")
    private String limit;

    @JSONField(name = "ctime")
    private Object ctime;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "collectIds")
    private List<Object> collectIds;

    @JSONField(name = "attr")
    private String attr;

    @JSONField(name = "aid")
    private Object aid;

    @JSONField(name = "cid")
    private String cid;

    public String getCurtime() {
        return curtime;
    }

    public void setCurtime(String curtime) {
        this.curtime = curtime;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCrtype() {
        return crtype;
    }

    public void setCrtype(String crtype) {
        this.crtype = crtype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public VipInfo getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(VipInfo vipInfo) {
        this.vipInfo = vipInfo;
    }

    public String getLimitdesc() {
        return limitdesc;
    }

    public void setLimitdesc(String limitdesc) {
        this.limitdesc = limitdesc;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(String coinNum) {
        this.coinNum = coinNum;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Object getCtime() {
        return ctime;
    }

    public void setCtime(Object ctime) {
        this.ctime = ctime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Object> collectIds) {
        this.collectIds = collectIds;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Object getAid() {
        return aid;
    }

    public void setAid(Object aid) {
        this.aid = aid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "curtime = '" + curtime + '\'' +
                        ",statistic = '" + statistic + '\'' +
                        ",uname = '" + uname + '\'' +
                        ",crtype = '" + crtype + '\'' +
                        ",author = '" + author + '\'' +
                        ",title = '" + title + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",duration = '" + duration + '\'' +
                        ",uid = '" + uid + '\'' +
                        ",activityId = '" + activityId + '\'' +
                        ",msid = '" + msid + '\'' +
                        ",vipInfo = '" + vipInfo + '\'' +
                        ",limitdesc = '" + limitdesc + '\'' +
                        ",lyric = '" + lyric + '\'' +
                        ",passtime = '" + passtime + '\'' +
                        ",intro = '" + intro + '\'' +
                        ",coin_num = '" + coinNum + '\'' +
                        ",limit = '" + limit + '\'' +
                        ",ctime = '" + ctime + '\'' +
                        ",id = '" + id + '\'' +
                        ",collectIds = '" + collectIds + '\'' +
                        ",attr = '" + attr + '\'' +
                        ",aid = '" + aid + '\'' +
                        ",cid = '" + cid + '\'' +
                        "}";
    }
}
package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class MediaInfo {

    @JSONField(name = "newEpSpMode")
    private String newEpSpMode;

    @JSONField(name = "ssType")
    private String ssType;

    @JSONField(name = "activity")
    private Activity activity;

    @JSONField(name = "ssTypeFormat")
    private SsTypeFormat ssTypeFormat;

    @JSONField(name = "rating")
    private Rating rating;

    @JSONField(name = "mainSecTitle")
    private String mainSecTitle;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "rights")
    private Rights rights;

    @JSONField(name = "alias")
    private String alias;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "upInfo")
    private UpInfo upInfo;

    @JSONField(name = "newestEp")
    private NewestEp newestEp;

    @JSONField(name = "squareCover")
    private String squareCover;

    @JSONField(name = "count")
    private Count count;

    @JSONField(name = "epSpMode")
    private String epSpMode;

    @JSONField(name = "payMent")
    private PayMent payMent;

    @JSONField(name = "specialCover")
    private String specialCover;

    @JSONField(name = "ssId")
    private String ssId;

    @JSONField(name = "payPack")
    private PayPack payPack;

    @JSONField(name = "multiMode")
    private String multiMode;

    @JSONField(name = "jpTitle")
    private String jpTitle;

    @JSONField(name = "series")
    private String series;

    @JSONField(name = "playerRecord")
    private String playerRecord;

    @JSONField(name = "pub")
    private Pub pub;

    @JSONField(name = "evaluate")
    private String evaluate;

    @JSONField(name = "pgcType")
    private String pgcType;

    @JSONField(name = "status")
    private String status;

    public void setNewEpSpMode(String newEpSpMode) {
        this.newEpSpMode = newEpSpMode;
    }

    public String isNewEpSpMode() {
        return newEpSpMode;
    }

    public String getSsType() {
        return ssType;
    }

    public void setSsType(String ssType) {
        this.ssType = ssType;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public SsTypeFormat getSsTypeFormat() {
        return ssTypeFormat;
    }

    public void setSsTypeFormat(SsTypeFormat ssTypeFormat) {
        this.ssTypeFormat = ssTypeFormat;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getMainSecTitle() {
        return mainSecTitle;
    }

    public void setMainSecTitle(String mainSecTitle) {
        this.mainSecTitle = mainSecTitle;
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

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UpInfo getUpInfo() {
        return upInfo;
    }

    public void setUpInfo(UpInfo upInfo) {
        this.upInfo = upInfo;
    }

    public NewestEp getNewestEp() {
        return newestEp;
    }

    public void setNewestEp(NewestEp newestEp) {
        this.newestEp = newestEp;
    }

    public String getSquareCover() {
        return squareCover;
    }

    public void setSquareCover(String squareCover) {
        this.squareCover = squareCover;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public void setEpSpMode(String epSpMode) {
        this.epSpMode = epSpMode;
    }

    public String isEpSpMode() {
        return epSpMode;
    }

    public PayMent getPayMent() {
        return payMent;
    }

    public void setPayMent(PayMent payMent) {
        this.payMent = payMent;
    }

    public String getSpecialCover() {
        return specialCover;
    }

    public void setSpecialCover(String specialCover) {
        this.specialCover = specialCover;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public PayPack getPayPack() {
        return payPack;
    }

    public void setPayPack(PayPack payPack) {
        this.payPack = payPack;
    }

    public void setMultiMode(String multiMode) {
        this.multiMode = multiMode;
    }

    public String isMultiMode() {
        return multiMode;
    }

    public String getJpTitle() {
        return jpTitle;
    }

    public void setJpTitle(String jpTitle) {
        this.jpTitle = jpTitle;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPlayerRecord() {
        return playerRecord;
    }

    public void setPlayerRecord(String playerRecord) {
        this.playerRecord = playerRecord;
    }

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getPgcType() {
        return pgcType;
    }

    public void setPgcType(String pgcType) {
        this.pgcType = pgcType;
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
                "MediaInfo{" +
                        "newEpSpMode = '" + newEpSpMode + '\'' +
                        ",ssType = '" + ssType + '\'' +
                        ",activity = '" + activity + '\'' +
                        ",ssTypeFormat = '" + ssTypeFormat + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",mainSecTitle = '" + mainSecTitle + '\'' +
                        ",title = '" + title + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",rights = '" + rights + '\'' +
                        ",alias = '" + alias + '\'' +
                        ",id = '" + id + '\'' +
                        ",upInfo = '" + upInfo + '\'' +
                        ",newestEp = '" + newestEp + '\'' +
                        ",squareCover = '" + squareCover + '\'' +
                        ",count = '" + count + '\'' +
                        ",epSpMode = '" + epSpMode + '\'' +
                        ",payMent = '" + payMent + '\'' +
                        ",specialCover = '" + specialCover + '\'' +
                        ",ssId = '" + ssId + '\'' +
                        ",payPack = '" + payPack + '\'' +
                        ",multiMode = '" + multiMode + '\'' +
                        ",jpTitle = '" + jpTitle + '\'' +
                        ",series = '" + series + '\'' +
                        ",playerRecord = '" + playerRecord + '\'' +
                        ",pub = '" + pub + '\'' +
                        ",evaluate = '" + evaluate + '\'' +
                        ",pgcType = '" + pgcType + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
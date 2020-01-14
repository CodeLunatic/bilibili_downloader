package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Rights {

    @JSONField(name = "download")
    private String download;

    @JSONField(name = "movie")
    private String movie;

    @JSONField(name = "no_reprint")
    private String noReprint;

    @JSONField(name = "is_cooperation")
    private String isCooperation;

    @JSONField(name = "ugc_pay")
    private String ugcPay;

    @JSONField(name = "hd5")
    private String hd5;

    @JSONField(name = "pay")
    private String pay;

    @JSONField(name = "elec")
    private String elec;

    @JSONField(name = "ugc_pay_preview")
    private String ugcPayPreview;

    @JSONField(name = "bp")
    private String bp;

    @JSONField(name = "autoplay")
    private String autoplay;

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getNoReprint() {
        return noReprint;
    }

    public void setNoReprint(String noReprint) {
        this.noReprint = noReprint;
    }

    public String getIsCooperation() {
        return isCooperation;
    }

    public void setIsCooperation(String isCooperation) {
        this.isCooperation = isCooperation;
    }

    public String getUgcPay() {
        return ugcPay;
    }

    public void setUgcPay(String ugcPay) {
        this.ugcPay = ugcPay;
    }

    public String getHd5() {
        return hd5;
    }

    public void setHd5(String hd5) {
        this.hd5 = hd5;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getElec() {
        return elec;
    }

    public void setElec(String elec) {
        this.elec = elec;
    }

    public String getUgcPayPreview() {
        return ugcPayPreview;
    }

    public void setUgcPayPreview(String ugcPayPreview) {
        this.ugcPayPreview = ugcPayPreview;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(String autoplay) {
        this.autoplay = autoplay;
    }

    @Override
    public String toString() {
        return
                "Rights{" +
                        "download = '" + download + '\'' +
                        ",movie = '" + movie + '\'' +
                        ",no_reprString = '" + noReprint + '\'' +
                        ",is_cooperation = '" + isCooperation + '\'' +
                        ",ugc_pay = '" + ugcPay + '\'' +
                        ",hd5 = '" + hd5 + '\'' +
                        ",pay = '" + pay + '\'' +
                        ",elec = '" + elec + '\'' +
                        ",ugc_pay_preview = '" + ugcPayPreview + '\'' +
                        ",bp = '" + bp + '\'' +
                        ",autoplay = '" + autoplay + '\'' +
                        "}";
    }
}
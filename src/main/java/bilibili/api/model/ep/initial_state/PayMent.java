package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class PayMent {

    @JSONField(name = "sixType")
    private SixType sixType;

    @JSONField(name = "vipProm")
    private String vipProm;

    @JSONField(name = "vipDiscount")
    private String vipDiscount;

    @JSONField(name = "price")
    private String price;

    @JSONField(name = "discount")
    private String discount;

    @JSONField(name = "tip")
    private String tip;

    @JSONField(name = "vipFirstProm")
    private String vipFirstProm;

    @JSONField(name = "promotion")
    private String promotion;

    public SixType getSixType() {
        return sixType;
    }

    public void setSixType(SixType sixType) {
        this.sixType = sixType;
    }

    public String getVipProm() {
        return vipProm;
    }

    public void setVipProm(String vipProm) {
        this.vipProm = vipProm;
    }

    public String getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(String vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getVipFirstProm() {
        return vipFirstProm;
    }

    public void setVipFirstProm(String vipFirstProm) {
        this.vipFirstProm = vipFirstProm;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return
                "PayMent{" +
                        "sixType = '" + sixType + '\'' +
                        ",vipProm = '" + vipProm + '\'' +
                        ",vipDiscount = '" + vipDiscount + '\'' +
                        ",price = '" + price + '\'' +
                        ",discount = '" + discount + '\'' +
                        ",tip = '" + tip + '\'' +
                        ",vipFirstProm = '" + vipFirstProm + '\'' +
                        ",promotion = '" + promotion + '\'' +
                        "}";
    }
}
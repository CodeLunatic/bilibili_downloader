package bilibili.api.model.common.user_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Wallet {

    @JSONField(name = "bcoin_balance")
    private String bcoinBalance;

    @JSONField(name = "coupon_due_time")
    private String couponDueTime;

    @JSONField(name = "coupon_balance")
    private String couponBalance;

    @JSONField(name = "mid")
    private String mid;

    public String getBcoinBalance() {
        return bcoinBalance;
    }

    public void setBcoinBalance(String bcoinBalance) {
        this.bcoinBalance = bcoinBalance;
    }

    public String getCouponDueTime() {
        return couponDueTime;
    }

    public void setCouponDueTime(String couponDueTime) {
        this.couponDueTime = couponDueTime;
    }

    public String getCouponBalance() {
        return couponBalance;
    }

    public void setCouponBalance(String couponBalance) {
        this.couponBalance = couponBalance;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return
                "Wallet{" +
                        "bcoin_balance = '" + bcoinBalance + '\'' +
                        ",coupon_due_time = '" + couponDueTime + '\'' +
                        ",coupon_balance = '" + couponBalance + '\'' +
                        ",mid = '" + mid + '\'' +
                        "}";
    }
}
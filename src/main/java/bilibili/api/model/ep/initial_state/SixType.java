package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class SixType {

    @JSONField(name = "allowTicket")
    private String allowTicket;

    @JSONField(name = "allowVipDiscount")
    private String allowVipDiscount;

    @JSONField(name = "allowDiscount")
    private String allowDiscount;

    @JSONField(name = "allowTimeLimit")
    private String allowTimeLimit;

    public void setAllowTicket(String allowTicket) {
        this.allowTicket = allowTicket;
    }

    public String isAllowTicket() {
        return allowTicket;
    }

    public void setAllowVipDiscount(String allowVipDiscount) {
        this.allowVipDiscount = allowVipDiscount;
    }

    public String isAllowVipDiscount() {
        return allowVipDiscount;
    }

    public void setAllowDiscount(String allowDiscount) {
        this.allowDiscount = allowDiscount;
    }

    public String isAllowDiscount() {
        return allowDiscount;
    }

    public void setAllowTimeLimit(String allowTimeLimit) {
        this.allowTimeLimit = allowTimeLimit;
    }

    public String isAllowTimeLimit() {
        return allowTimeLimit;
    }

    @Override
    public String toString() {
        return
                "SixType{" +
                        "allowTicket = '" + allowTicket + '\'' +
                        ",allowVipDiscount = '" + allowVipDiscount + '\'' +
                        ",allowDiscount = '" + allowDiscount + '\'' +
                        ",allowTimeLimit = '" + allowTimeLimit + '\'' +
                        "}";
    }
}
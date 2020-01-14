package bilibili.api.model.au.music_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class VipInfo {

    @JSONField(name = "vip_pay_type")
    private String vipPayType;

    @JSONField(name = "due_date")
    private String dueDate;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "status")
    private String status;

    public String getVipPayType() {
        return vipPayType;
    }

    public void setVipPayType(String vipPayType) {
        this.vipPayType = vipPayType;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "VipInfo{" +
                        "vip_pay_type = '" + vipPayType + '\'' +
                        ",due_date = '" + dueDate + '\'' +
                        ",type = '" + type + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
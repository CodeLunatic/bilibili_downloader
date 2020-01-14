package bilibili.api.model.common.upper_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Vip {

    @JSONField(name = "vipType")
    private String vipType;

    @JSONField(name = "accessStatus")
    private String accessStatus;

    @JSONField(name = "vipStatus")
    private String vipStatus;

    @JSONField(name = "dueRemark")
    private String dueRemark;

    @JSONField(name = "theme_type")
    private String themeType;

    @JSONField(name = "vipStatusWarn")
    private String vipStatusWarn;

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(String accessStatus) {
        this.accessStatus = accessStatus;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getDueRemark() {
        return dueRemark;
    }

    public void setDueRemark(String dueRemark) {
        this.dueRemark = dueRemark;
    }

    public String getThemeType() {
        return themeType;
    }

    public void setThemeType(String themeType) {
        this.themeType = themeType;
    }

    public String getVipStatusWarn() {
        return vipStatusWarn;
    }

    public void setVipStatusWarn(String vipStatusWarn) {
        this.vipStatusWarn = vipStatusWarn;
    }

    @Override
    public String toString() {
        return
                "Vip{" +
                        "vipType = '" + vipType + '\'' +
                        ",accessStatus = '" + accessStatus + '\'' +
                        ",vipStatus = '" + vipStatus + '\'' +
                        ",dueRemark = '" + dueRemark + '\'' +
                        ",theme_type = '" + themeType + '\'' +
                        ",vipStatusWarn = '" + vipStatusWarn + '\'' +
                        "}";
    }
}
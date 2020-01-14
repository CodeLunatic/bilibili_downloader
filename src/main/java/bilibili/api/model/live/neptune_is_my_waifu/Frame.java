package bilibili.api.model.live.neptune_is_my_waifu;

import com.alibaba.fastjson.annotation.JSONField;

public class Frame {

    @JSONField(name = "area")
    private String area;

    @JSONField(name = "area_old")
    private String areaOld;

    @JSONField(name = "bg_color")
    private String bgColor;

    @JSONField(name = "use_old_area")
    private String useOldArea;

    @JSONField(name = "bg_pic")
    private String bgPic;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "position")
    private String position;

    @JSONField(name = "value")
    private String value;

    @JSONField(name = "desc")
    private String desc;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaOld() {
        return areaOld;
    }

    public void setAreaOld(String areaOld) {
        this.areaOld = areaOld;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setUseOldArea(String useOldArea) {
        this.useOldArea = useOldArea;
    }

    public String isUseOldArea() {
        return useOldArea;
    }

    public String getBgPic() {
        return bgPic;
    }

    public void setBgPic(String bgPic) {
        this.bgPic = bgPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return
                "Frame{" +
                        "area = '" + area + '\'' +
                        ",area_old = '" + areaOld + '\'' +
                        ",bg_color = '" + bgColor + '\'' +
                        ",use_old_area = '" + useOldArea + '\'' +
                        ",bg_pic = '" + bgPic + '\'' +
                        ",name = '" + name + '\'' +
                        ",position = '" + position + '\'' +
                        ",value = '" + value + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
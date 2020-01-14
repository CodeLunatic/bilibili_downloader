package bilibili.api.model.common.upper_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Nameplate {

    @JSONField(name = "image")
    private String image;

    @JSONField(name = "image_small")
    private String imageSmall;

    @JSONField(name = "condition")
    private String condition;

    @JSONField(name = "level")
    private String level;

    @JSONField(name = "nid")
    private String nid;

    @JSONField(name = "name")
    private String name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "Nameplate{" +
                        "image = '" + image + '\'' +
                        ",image_small = '" + imageSmall + '\'' +
                        ",condition = '" + condition + '\'' +
                        ",level = '" + level + '\'' +
                        ",nid = '" + nid + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}
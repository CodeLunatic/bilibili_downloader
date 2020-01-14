package bilibili.api.model.common.upper_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Space {

    @JSONField(name = "s_img")
    private String sImg;

    @JSONField(name = "l_img")
    private String lImg;

    public String getSImg() {
        return sImg;
    }

    public void setSImg(String sImg) {
        this.sImg = sImg;
    }

    public String getLImg() {
        return lImg;
    }

    public void setLImg(String lImg) {
        this.lImg = lImg;
    }

    @Override
    public String toString() {
        return
                "Space{" +
                        "s_img = '" + sImg + '\'' +
                        ",l_img = '" + lImg + '\'' +
                        "}";
    }
}
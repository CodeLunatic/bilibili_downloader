package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Dimension {

    @JSONField(name = "rotate")
    private String rotate;

    @JSONField(name = "width")
    private String width;

    @JSONField(name = "height")
    private String height;

    public String getRotate() {
        return rotate;
    }

    public void setRotate(String rotate) {
        this.rotate = rotate;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return
                "Dimension{" +
                        "rotate = '" + rotate + '\'' +
                        ",width = '" + width + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
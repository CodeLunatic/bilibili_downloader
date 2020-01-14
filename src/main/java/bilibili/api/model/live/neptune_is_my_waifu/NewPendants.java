package bilibili.api.model.live.neptune_is_my_waifu;

import com.alibaba.fastjson.annotation.JSONField;

public class NewPendants {

    @JSONField(name = "badge")
    private Object badge;

    @JSONField(name = "mobile_badge")
    private Object mobileBadge;

    @JSONField(name = "frame")
    private Frame frame;

    @JSONField(name = "mobile_frame")
    private MobileFrame mobileFrame;

    public Object getBadge() {
        return badge;
    }

    public void setBadge(Object badge) {
        this.badge = badge;
    }

    public Object getMobileBadge() {
        return mobileBadge;
    }

    public void setMobileBadge(Object mobileBadge) {
        this.mobileBadge = mobileBadge;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public MobileFrame getMobileFrame() {
        return mobileFrame;
    }

    public void setMobileFrame(MobileFrame mobileFrame) {
        this.mobileFrame = mobileFrame;
    }

    @Override
    public String toString() {
        return
                "NewPendants{" +
                        "badge = '" + badge + '\'' +
                        ",mobile_badge = '" + mobileBadge + '\'' +
                        ",frame = '" + frame + '\'' +
                        ",mobile_frame = '" + mobileFrame + '\'' +
                        "}";
    }
}
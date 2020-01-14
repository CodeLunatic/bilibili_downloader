package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class UpAction {

    @JSONField(name = "like")
    private String like;

    @JSONField(name = "reply")
    private String reply;

    public void setLike(String like) {
        this.like = like;
    }

    public String isLike() {
        return like;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String isReply() {
        return reply;
    }

    @Override
    public String toString() {
        return
                "UpAction{" +
                        "like = '" + like + '\'' +
                        ",reply = '" + reply + '\'' +
                        "}";
    }
}
package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Reply {

    @JSONField(name = "replies")
    private List<RepliesItem> replies;

    @JSONField(name = "page")
    private Page page;

    public List<RepliesItem> getReplies() {
        return replies;
    }

    public void setReplies(List<RepliesItem> replies) {
        this.replies = replies;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return
                "Reply{" +
                        "replies = '" + replies + '\'' +
                        ",page = '" + page + '\'' +
                        "}";
    }
}
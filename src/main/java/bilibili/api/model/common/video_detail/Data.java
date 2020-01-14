package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "Related")
    private List<RelatedItem> related;

    @JSONField(name = "Reply")
    private Reply reply;

    @JSONField(name = "View")
    private View view;

    @JSONField(name = "Tags")
    private List<TagsItem> tags;

    @JSONField(name = "Card")
    private Card card;

    public List<RelatedItem> getRelated() {
        return related;
    }

    public void setRelated(List<RelatedItem> related) {
        this.related = related;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public List<TagsItem> getTags() {
        return tags;
    }

    public void setTags(List<TagsItem> tags) {
        this.tags = tags;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "related = '" + related + '\'' +
                        ",reply = '" + reply + '\'' +
                        ",view = '" + view + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",card = '" + card + '\'' +
                        "}";
    }
}
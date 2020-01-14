package bilibili.api.model.common.upper_info;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "follower")
    private String follower;

    @JSONField(name = "article_count")
    private String articleCount;

    @JSONField(name = "following")
    private String following;

    @JSONField(name = "card")
    private Card card;

    @JSONField(name = "space")
    private Space space;

    @JSONField(name = "archive_count")
    private String archiveCount;

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String isFollowing() {
        return following;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public String getArchiveCount() {
        return archiveCount;
    }

    public void setArchiveCount(String archiveCount) {
        this.archiveCount = archiveCount;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "follower = '" + follower + '\'' +
                        ",article_count = '" + articleCount + '\'' +
                        ",following = '" + following + '\'' +
                        ",card = '" + card + '\'' +
                        ",space = '" + space + '\'' +
                        ",archive_count = '" + archiveCount + '\'' +
                        "}";
    }
}
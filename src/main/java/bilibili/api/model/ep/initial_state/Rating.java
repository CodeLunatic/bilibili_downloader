package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Rating {

    @JSONField(name = "score")
    private String score;

    @JSONField(name = "count")
    private String count;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "Rating{" +
                        "score = '" + score + '\'' +
                        ",count = '" + count + '\'' +
                        "}";
    }
}
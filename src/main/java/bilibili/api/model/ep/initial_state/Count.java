package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Count {

    @JSONField(name = "coins")
    private String coins;

    @JSONField(name = "danmus")
    private String danmus;

    @JSONField(name = "follows")
    private String follows;

    @JSONField(name = "views")
    private String views;

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getDanmus() {
        return danmus;
    }

    public void setDanmus(String danmus) {
        this.danmus = danmus;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return
                "Count{" +
                        "coins = '" + coins + '\'' +
                        ",danmus = '" + danmus + '\'' +
                        ",follows = '" + follows + '\'' +
                        ",views = '" + views + '\'' +
                        "}";
    }
}
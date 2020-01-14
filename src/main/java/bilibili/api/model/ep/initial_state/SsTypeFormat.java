package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class SsTypeFormat {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "homeLink")
    private String homeLink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(String homeLink) {
        this.homeLink = homeLink;
    }

    @Override
    public String toString() {
        return
                "SsTypeFormat{" +
                        "name = '" + name + '\'' +
                        ",homeLink = '" + homeLink + '\'' +
                        "}";
    }
}
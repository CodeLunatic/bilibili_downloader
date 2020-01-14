package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Player {

    @JSONField(name = "loaded")
    private String loaded;

    @JSONField(name = "miniOn")
    private String miniOn;

    @JSONField(name = "limitType")
    private String limitType;

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public String isLoaded() {
        return loaded;
    }

    public void setMiniOn(String miniOn) {
        this.miniOn = miniOn;
    }

    public String isMiniOn() {
        return miniOn;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    @Override
    public String toString() {
        return
                "Player{" +
                        "loaded = '" + loaded + '\'' +
                        ",miniOn = '" + miniOn + '\'' +
                        ",limitType = '" + limitType + '\'' +
                        "}";
    }
}
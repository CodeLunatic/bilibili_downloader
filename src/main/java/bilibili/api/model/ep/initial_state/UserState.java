package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class UserState {

    @JSONField(name = "loaded")
    private String loaded;

    @JSONField(name = "vipInfo")
    private VipInfo vipInfo;

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public String isLoaded() {
        return loaded;
    }

    public VipInfo getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(VipInfo vipInfo) {
        this.vipInfo = vipInfo;
    }

    @Override
    public String toString() {
        return
                "UserState{" +
                        "loaded = '" + loaded + '\'' +
                        ",vipInfo = '" + vipInfo + '\'' +
                        "}";
    }
}
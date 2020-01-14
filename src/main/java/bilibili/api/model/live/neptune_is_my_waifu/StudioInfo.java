package bilibili.api.model.live.neptune_is_my_waifu;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class StudioInfo {

    @JSONField(name = "master_list")
    private List<Object> masterList;

    @JSONField(name = "status")
    private String status;

    public List<Object> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<Object> masterList) {
        this.masterList = masterList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "StudioInfo{" +
                        "master_list = '" + masterList + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
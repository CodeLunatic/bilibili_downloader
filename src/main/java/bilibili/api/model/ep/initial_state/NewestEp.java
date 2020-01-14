package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class NewestEp {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "isNew")
    private String isNew;

    @JSONField(name = "desc")
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String isIsNew() {
        return isNew;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return
                "NewestEp{" +
                        "id = '" + id + '\'' +
                        ",isNew = '" + isNew + '\'' +
                        ",desc = '" + desc + '\'' +
                        "}";
    }
}
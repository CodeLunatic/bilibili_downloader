package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Subtitle {

    @JSONField(name = "allow_submit")
    private String allowSubmit;

    @JSONField(name = "list")
    private List<Object> list;

    public void setAllowSubmit(String allowSubmit) {
        this.allowSubmit = allowSubmit;
    }

    public String isAllowSubmit() {
        return allowSubmit;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return
                "Subtitle{" +
                        "allow_submit = '" + allowSubmit + '\'' +
                        ",list = '" + list + '\'' +
                        "}";
    }
}
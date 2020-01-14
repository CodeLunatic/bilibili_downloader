package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class SectionsItem {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "epList")
    private List<EpListItem> epList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EpListItem> getEpList() {
        return epList;
    }

    public void setEpList(List<EpListItem> epList) {
        this.epList = epList;
    }

    @Override
    public String toString() {
        return
                "SectionsItem{" +
                        "id = '" + id + '\'' +
                        ",title = '" + title + '\'' +
                        ",type = '" + type + '\'' +
                        ",epList = '" + epList + '\'' +
                        "}";
    }
}
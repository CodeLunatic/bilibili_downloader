package bilibili.api.model.vc.recommend;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "size")
    private String size;

    @JSONField(name = "has_more")
    private String hasMore;

    @JSONField(name = "items")
    private List<ItemsItem> items;

    @JSONField(name = "next_offset")
    private String nextOffset;

    @JSONField(name = "data_source")
    private String dataSource;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHasMore() {
        return hasMore;
    }

    public void setHasMore(String hasMore) {
        this.hasMore = hasMore;
    }

    public List<ItemsItem> getItems() {
        return items;
    }

    public void setItems(List<ItemsItem> items) {
        this.items = items;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "size = '" + size + '\'' +
                        ",has_more = '" + hasMore + '\'' +
                        ",items = '" + items + '\'' +
                        ",next_offset = '" + nextOffset + '\'' +
                        ",data_source = '" + dataSource + '\'' +
                        "}";
    }
}
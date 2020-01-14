package bilibili.api.model.am.hot_album_list;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "pageCount")
    private String pageCount;

    @JSONField(name = "curPage")
    private String curPage;

    @JSONField(name = "totalSize")
    private String totalSize;

    @JSONField(name = "data")
    private List<DataItem> data;

    @JSONField(name = "pageSize")
    private String pageSize;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "pageCount = '" + pageCount + '\'' +
                        ",curPage = '" + curPage + '\'' +
                        ",totalSize = '" + totalSize + '\'' +
                        ",data = '" + data + '\'' +
                        ",pageSize = '" + pageSize + '\'' +
                        "}";
    }
}
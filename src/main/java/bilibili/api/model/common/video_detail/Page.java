package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Page {

    @JSONField(name = "acount")
    private String acount;

    @JSONField(name = "size")
    private String size;

    @JSONField(name = "num")
    private String num;

    @JSONField(name = "count")
    private String count;

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "Page{" +
                        "acount = '" + acount + '\'' +
                        ",size = '" + size + '\'' +
                        ",num = '" + num + '\'' +
                        ",count = '" + count + '\'' +
                        "}";
    }
}
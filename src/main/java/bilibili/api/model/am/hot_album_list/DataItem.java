package bilibili.api.model.am.hot_album_list;

import com.alibaba.fastjson.annotation.JSONField;

public class DataItem {

    @JSONField(name = "curtime")
    private String curtime;

    @JSONField(name = "statistic")
    private Statistic statistic;

    @JSONField(name = "uname")
    private String uname;

    @JSONField(name = "snum")
    private String snum;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "off")
    private String off;

    @JSONField(name = "cover")
    private String cover;

    @JSONField(name = "uid")
    private String uid;

    @JSONField(name = "isDefault")
    private String isDefault;

    @JSONField(name = "intro")
    private String intro;

    @JSONField(name = "menuId")
    private String menuId;

    @JSONField(name = "ctime")
    private String ctime;

    @JSONField(name = "attr")
    private String attr;

    @JSONField(name = "collectionId")
    private String collectionId;

    public String getCurtime() {
        return curtime;
    }

    public void setCurtime(String curtime) {
        this.curtime = curtime;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
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

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "curtime = '" + curtime + '\'' +
                        ",statistic = '" + statistic + '\'' +
                        ",uname = '" + uname + '\'' +
                        ",snum = '" + snum + '\'' +
                        ",title = '" + title + '\'' +
                        ",type = '" + type + '\'' +
                        ",off = '" + off + '\'' +
                        ",cover = '" + cover + '\'' +
                        ",uid = '" + uid + '\'' +
                        ",isDefault = '" + isDefault + '\'' +
                        ",intro = '" + intro + '\'' +
                        ",menuId = '" + menuId + '\'' +
                        ",ctime = '" + ctime + '\'' +
                        ",attr = '" + attr + '\'' +
                        ",collectionId = '" + collectionId + '\'' +
                        "}";
    }
}
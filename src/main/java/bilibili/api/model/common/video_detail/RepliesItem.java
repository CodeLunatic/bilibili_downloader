package bilibili.api.model.common.video_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class RepliesItem {

    @JSONField(name = "parent")
    private String parent;

    @JSONField(name = "like")
    private String like;

    @JSONField(name = "count")
    private String count;

    @JSONField(name = "mid")
    private String mid;

    @JSONField(name = "oid")
    private String oid;

    @JSONField(name = "rpid")
    private String rpid;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "content")
    private Content content;

    @JSONField(name = "dialog")
    private String dialog;

    @JSONField(name = "rcount")
    private String rcount;

    @JSONField(name = "folder")
    private Folder folder;

    @JSONField(name = "up_action")
    private UpAction upAction;

    @JSONField(name = "replies")
    private Object replies;

    @JSONField(name = "fansgrade")
    private String fansgrade;

    @JSONField(name = "root")
    private String root;

    @JSONField(name = "member")
    private Object member;

    @JSONField(name = "ctime")
    private String ctime;

    @JSONField(name = "action")
    private String action;

    @JSONField(name = "assist")
    private String assist;

    @JSONField(name = "state")
    private String state;

    @JSONField(name = "floor")
    private String floor;

    @JSONField(name = "attr")
    private String attr;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRpid() {
        return rpid;
    }

    public void setRpid(String rpid) {
        this.rpid = rpid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getRcount() {
        return rcount;
    }

    public void setRcount(String rcount) {
        this.rcount = rcount;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public UpAction getUpAction() {
        return upAction;
    }

    public void setUpAction(UpAction upAction) {
        this.upAction = upAction;
    }

    public Object getReplies() {
        return replies;
    }

    public void setReplies(Object replies) {
        this.replies = replies;
    }

    public String getFansgrade() {
        return fansgrade;
    }

    public void setFansgrade(String fansgrade) {
        this.fansgrade = fansgrade;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Object getMember() {
        return member;
    }

    public void setMember(Object member) {
        this.member = member;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAssist() {
        return assist;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return
                "RepliesItem{" +
                        "parent = '" + parent + '\'' +
                        ",like = '" + like + '\'' +
                        ",count = '" + count + '\'' +
                        ",mid = '" + mid + '\'' +
                        ",oid = '" + oid + '\'' +
                        ",rpid = '" + rpid + '\'' +
                        ",type = '" + type + '\'' +
                        ",content = '" + content + '\'' +
                        ",dialog = '" + dialog + '\'' +
                        ",rcount = '" + rcount + '\'' +
                        ",folder = '" + folder + '\'' +
                        ",up_action = '" + upAction + '\'' +
                        ",replies = '" + replies + '\'' +
                        ",fansgrade = '" + fansgrade + '\'' +
                        ",root = '" + root + '\'' +
                        ",member = '" + member + '\'' +
                        ",ctime = '" + ctime + '\'' +
                        ",action = '" + action + '\'' +
                        ",assist = '" + assist + '\'' +
                        ",state = '" + state + '\'' +
                        ",floor = '" + floor + '\'' +
                        ",attr = '" + attr + '\'' +
                        "}";
    }
}
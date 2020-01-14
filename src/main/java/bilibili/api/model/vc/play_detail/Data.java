package bilibili.api.model.vc.play_detail;

import com.alibaba.fastjson.annotation.JSONField;

public class Data {

    @JSONField(name = "item")
    private Item item;

    @JSONField(name = "user")
    private User user;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "item = '" + item + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}
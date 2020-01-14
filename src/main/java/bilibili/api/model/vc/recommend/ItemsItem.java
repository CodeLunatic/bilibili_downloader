package bilibili.api.model.vc.recommend;

import com.alibaba.fastjson.annotation.JSONField;

public class ItemsItem {

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
                "ItemsItem{" +
                        "item = '" + item + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}
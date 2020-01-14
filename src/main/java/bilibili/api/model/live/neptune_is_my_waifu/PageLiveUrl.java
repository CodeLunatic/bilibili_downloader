package bilibili.api.model.live.neptune_is_my_waifu;

import com.alibaba.fastjson.annotation.JSONField;

public class PageLiveUrl {

    @JSONField(name = "roomInitRes")
    private RoomInitRes roomInitRes;

    @JSONField(name = "baseInfoRes")
    private BaseInfoRes baseInfoRes;

    @JSONField(name = "playUrlRes")
    private PlayUrlRes playUrlRes;

    public RoomInitRes getRoomInitRes() {
        return roomInitRes;
    }

    public void setRoomInitRes(RoomInitRes roomInitRes) {
        this.roomInitRes = roomInitRes;
    }

    public BaseInfoRes getBaseInfoRes() {
        return baseInfoRes;
    }

    public void setBaseInfoRes(BaseInfoRes baseInfoRes) {
        this.baseInfoRes = baseInfoRes;
    }

    public PlayUrlRes getPlayUrlRes() {
        return playUrlRes;
    }

    public void setPlayUrlRes(PlayUrlRes playUrlRes) {
        this.playUrlRes = playUrlRes;
    }

    @Override
    public String toString() {
        return
                "PageLiveUrl{" +
                        "roomInitRes = '" + roomInitRes + '\'' +
                        ",baseInfoRes = '" + baseInfoRes + '\'' +
                        ",playUrlRes = '" + playUrlRes + '\'' +
                        "}";
    }
}
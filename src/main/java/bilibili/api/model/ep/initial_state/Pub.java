package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

public class Pub {

    @JSONField(name = "timeShow")
    private String timeShow;

    @JSONField(name = "time")
    private String time;

    @JSONField(name = "isStart")
    private String isStart;

    @JSONField(name = "isFinish")
    private String isFinish;

    public String getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(String timeShow) {
        this.timeShow = timeShow;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIsStart(String isStart) {
        this.isStart = isStart;
    }

    public String isIsStart() {
        return isStart;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String isIsFinish() {
        return isFinish;
    }

    @Override
    public String toString() {
        return
                "Pub{" +
                        "timeShow = '" + timeShow + '\'' +
                        ",time = '" + time + '\'' +
                        ",isStart = '" + isStart + '\'' +
                        ",isFinish = '" + isFinish + '\'' +
                        "}";
    }
}
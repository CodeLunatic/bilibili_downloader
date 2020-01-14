package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Sponsor {

    @JSONField(name = "allReady")
    private String allReady;

    @JSONField(name = "weekMine")
    private Object weekMine;

    @JSONField(name = "weekRank")
    private List<Object> weekRank;

    @JSONField(name = "allState")
    private String allState;

    @JSONField(name = "weekState")
    private String weekState;

    @JSONField(name = "allMine")
    private Object allMine;

    @JSONField(name = "weekReady")
    private String weekReady;

    @JSONField(name = "allCount")
    private String allCount;

    @JSONField(name = "allRank")
    private List<Object> allRank;

    @JSONField(name = "weekCount")
    private String weekCount;

    public void setAllReady(String allReady) {
        this.allReady = allReady;
    }

    public String isAllReady() {
        return allReady;
    }

    public Object getWeekMine() {
        return weekMine;
    }

    public void setWeekMine(Object weekMine) {
        this.weekMine = weekMine;
    }

    public List<Object> getWeekRank() {
        return weekRank;
    }

    public void setWeekRank(List<Object> weekRank) {
        this.weekRank = weekRank;
    }

    public String getAllState() {
        return allState;
    }

    public void setAllState(String allState) {
        this.allState = allState;
    }

    public String getWeekState() {
        return weekState;
    }

    public void setWeekState(String weekState) {
        this.weekState = weekState;
    }

    public Object getAllMine() {
        return allMine;
    }

    public void setAllMine(Object allMine) {
        this.allMine = allMine;
    }

    public void setWeekReady(String weekReady) {
        this.weekReady = weekReady;
    }

    public String isWeekReady() {
        return weekReady;
    }

    public String getAllCount() {
        return allCount;
    }

    public void setAllCount(String allCount) {
        this.allCount = allCount;
    }

    public List<Object> getAllRank() {
        return allRank;
    }

    public void setAllRank(List<Object> allRank) {
        this.allRank = allRank;
    }

    public String getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(String weekCount) {
        this.weekCount = weekCount;
    }

    @Override
    public String toString() {
        return
                "Sponsor{" +
                        "allReady = '" + allReady + '\'' +
                        ",weekMine = '" + weekMine + '\'' +
                        ",weekRank = '" + weekRank + '\'' +
                        ",allState = '" + allState + '\'' +
                        ",weekState = '" + weekState + '\'' +
                        ",allMine = '" + allMine + '\'' +
                        ",weekReady = '" + weekReady + '\'' +
                        ",allCount = '" + allCount + '\'' +
                        ",allRank = '" + allRank + '\'' +
                        ",weekCount = '" + weekCount + '\'' +
                        "}";
    }
}
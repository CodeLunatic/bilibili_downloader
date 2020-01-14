package bilibili.api.model.common.user_info;

import com.alibaba.fastjson.annotation.JSONField;

public class LevelInfo {

    @JSONField(name = "current_level")
    private String currentLevel;

    @JSONField(name = "current_min")
    private String currentMin;

    @JSONField(name = "next_exp")
    private String nextExp;

    @JSONField(name = "current_exp")
    private String currentExp;

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getCurrentMin() {
        return currentMin;
    }

    public void setCurrentMin(String currentMin) {
        this.currentMin = currentMin;
    }

    public String getNextExp() {
        return nextExp;
    }

    public void setNextExp(String nextExp) {
        this.nextExp = nextExp;
    }

    public String getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(String currentExp) {
        this.currentExp = currentExp;
    }

    @Override
    public String toString() {
        return
                "LevelInfo{" +
                        "current_level = '" + currentLevel + '\'' +
                        ",current_min = '" + currentMin + '\'' +
                        ",next_exp = '" + nextExp + '\'' +
                        ",current_exp = '" + currentExp + '\'' +
                        "}";
    }
}
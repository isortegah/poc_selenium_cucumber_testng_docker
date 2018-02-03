package com.isortegah.aspects;
import java.util.List;

public class ScenarioRun {
    private String scenarioName;
    private List<String> tags;

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

package com.example.generaltemplate;

public class Action {
    private final String name;
    private final ActionGroupings grouping;

    private final StatModifier statModifier;
    private final String description;
    private final int accuracy;

    public Action(String name, ActionGroupings grouping, StatModifier statModifier, String description, int accuracy) {
        this.name = name;
        this.grouping = grouping;
        this.description = description;
        this.statModifier = statModifier;
        this.accuracy = accuracy;
    }
    public String getName() {
        return name;
    }

    public ActionGroupings getGrouping() {
        return grouping;
    }

    public StatModifier getStatModifier() {
        return statModifier;
    }

    public String getDescription() {
        return description;
    }

    public int getAccuracy() {
        return accuracy;
    }
}

package com.example.generaltemplate;

public class Action {
    private final String name;
    private final ActionGroupings grouping;

    private final StatModifier statModifier;
    private final String description;


    public Action(String name, ActionGroupings grouping, StatModifier statModifier, String description) {
        this.name = name;
        this.grouping = grouping;
        this.description = description;
        this.statModifier = statModifier;
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
}

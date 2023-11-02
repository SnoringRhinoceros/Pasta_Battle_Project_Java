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

    public Action(PossibleActions possibleActions) {
        this.name = possibleActions.name();
        this.grouping = possibleActions.getAction().getGrouping();
        this.description = possibleActions.getAction().getDescription();
        this.statModifier = possibleActions.getAction().getStatModifier();
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

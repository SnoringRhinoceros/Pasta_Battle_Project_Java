package com.example.generaltemplate;

public class Action {
    private final String name;
    private final ActionGroupings grouping;
    private String description;

    public Action(PossibleActions specificAction) {
        name = specificAction.getStrName();
        grouping = specificAction.getGrouping();
        description = specificAction.getDescription();
    }

    public String getName() {
        return name;
    }

    public ActionGroupings getGrouping() {
        return grouping;
    }

    public String getDescription() {
        return description;
    }
}

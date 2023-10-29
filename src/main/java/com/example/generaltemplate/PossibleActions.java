package com.example.generaltemplate;

public enum PossibleActions {
    FISTS ("Fists", ActionGroupings.WEAPONS, "Fists always work\nHowever, they only do your base damage");

    private final String strName;
    private final String description;
    private final ActionGroupings grouping;

    PossibleActions(String strName, ActionGroupings grouping, String description) {
        this.strName = strName;
        this.description = description;
        this.grouping = grouping;
    }

    public String getStrName() {
        return strName;
    }

    public String getDescription() {
        return description;
    }

    public ActionGroupings getGrouping() {
        return grouping;
    }

    public static PossibleActions getPossibleAction(String name) {
        for (PossibleActions possibleAction : values()) {
            if (possibleAction.getStrName().equals(name)) {
                return possibleAction;
            }
        }
        throw new RuntimeException("Possible action doesn't exist");
    }
}

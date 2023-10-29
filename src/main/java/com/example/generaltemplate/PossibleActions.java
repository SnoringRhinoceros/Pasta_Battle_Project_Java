package com.example.generaltemplate;

public enum PossibleActions {
    FISTS ("Fists", ActionGroupings.WEAPONS,
            new StatModifier(0,0,0,0,0),
            "Fists always work\nHowever, they only do your base damage"),
    BASIC_SWORD ("Basic sword", ActionGroupings.WEAPONS,
            new StatModifier(0,5,0,0,0),
            "Simple sword for a simple pasta\n +5 to strength"),
    BASIC_SHIELD ("Basic shield", ActionGroupings.WEAPONS,
            new StatModifier(0, 0, 5, 0, 0),
            "A good offense needs a good defense\n+5 to defense"),
    BASIC_SAUCE ("Basic sauce", ActionGroupings.SPELLS,
            new StatModifier(0,0,0,0,0),
            "A beginner rotini's first spell\nDeals 5 sauce dmg");

    private final String strName;
    private final String description;
    private final ActionGroupings grouping;
    private final StatModifier statModifier;

    PossibleActions(String strName, ActionGroupings grouping, StatModifier statModifier, String description) {
        this.strName = strName;
        this.grouping = grouping;
        this.statModifier = statModifier;
        this.description = description;
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

    public StatModifier getStatModifier() {
        return statModifier;
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

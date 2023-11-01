package com.example.generaltemplate;

public enum PossibleActions {
    FISTS ("Fists", ActionGroupings.WEAPONS,
            new StatModifier("Fists", new Stats(0,0,0,0,0)),
            "Fists always work\nHowever, they only do your base damage"),
    BASIC_SWORD ("Basic sword", ActionGroupings.WEAPONS,
            new StatModifier("Basic sword", new Stats(0,5,0,0,0)),
            "Simple sword for a simple pasta\n +5 damage"),
    BASIC_HAMMER ("Basic hammer", ActionGroupings.WEAPONS,
            new StatModifier("Basic shield", new Stats(0, 10, 0, 0, 0)),
            "Slow but strong\n+10 damage"),
    BASIC_SAUCE ("Basic sauce", ActionGroupings.SPELLS,
            new StatModifier("Basic Sauce", 5, new Stats(0,5,0,0,0)),
            "The first sauce a rotini ever learns\n+5 to sauce dmg");

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

package com.example.generaltemplate;

public enum PossibleActions {
    FISTS (new Action("Fists", ActionGroupings.WEAPONS,
            new StatModifier("Fists", new Stats(0,0,0,0,0)),
            "Fists always work\nHowever, they only do your base damage")),
    BASIC_SWORD (new Action("Basic sword", ActionGroupings.WEAPONS,
            new StatModifier("Basic sword", new Stats(0,5,0,0,0)),
            "Simple sword for a simple pasta\n +5 damage")),
    BASIC_HAMMER (new Action("Basic hammer", ActionGroupings.WEAPONS,
            new StatModifier("Basic shield", new Stats(0, 10, 0, 0, 0)),
            "Slow but strong\n+10 damage")),
    BASIC_SAUCE (new Action("Basic sauce", ActionGroupings.SPELLS,
            new StatModifier("Basic Sauce", 5, new Stats(0,5,0,0,0)),
            "The first sauce a rotini ever learns\n+5 to sauce dmg"));

    private Action action;

    PossibleActions(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public static PossibleActions getPossibleAction(String name) {
        for (PossibleActions possibleAction : values()) {
            if (possibleAction.getAction().getName().equals(name)) {
                return possibleAction;
            }
        }
        throw new RuntimeException("Possible action doesn't exist");
    }
}

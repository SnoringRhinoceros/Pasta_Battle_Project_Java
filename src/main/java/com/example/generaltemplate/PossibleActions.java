package com.example.generaltemplate;

public enum PossibleActions {
    FISTS (new Action("Fists", ActionGroupings.WEAPONS,
            new StatModifier("Fists", new Stats(0,0,0,0,0)),
            "Fists always work\nHowever, they only do your base damage", 100)),
    BASIC_SWORD (new Action("Basic sword", ActionGroupings.WEAPONS,
            new StatModifier("Basic sword", new Stats(0,5,0,0,0)),
            "Simple sword for a simple pasta\n+5 damage", 35)),
    STRAIGHT_SWORD(new Action("Straight sword", ActionGroupings.WEAPONS,
            new StatModifier("Straight sword", new Stats(0, 10, 0, 0, 0)),
            "A decent blade for a decent pasta.\n+10 damage", 50)),
    BASIC_HAMMER (new Action("Basic hammer", ActionGroupings.WEAPONS,
            new StatModifier("Basic hammer", new Stats(0, 10, 0, 0, 0)),
            "Not very accurate but pretty strong\n+10 damage", 25)),
    MEAT_HAMMER(new Action("Meat hammer", ActionGroupings.WEAPONS,
            new StatModifier("Normal hammer", new Stats(0, 20, 0, 0, 0)),
            "Hammer but for meat\n+20 damage", 35)),
    BASIC_SAUCE (new Action("Basic sauce", ActionGroupings.SPELLS,
            new StatModifier("Basic Sauce", 5, new Stats(0,20,0,0,0)),
            "The first sauce a rotini ever learns\n+20 to sauce dmg for 5 ticks", 100)),
    MARINARA_SAUCE (new Action("Marinara sauce", ActionGroupings.SPELLS,
            new StatModifier("Marinara sauce", 10, new Stats(0, 20, 0, 0, 0)),
            "All good rotini start with the fundamentals\n+20 to sauce dmg for 10 ticks", 100));


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

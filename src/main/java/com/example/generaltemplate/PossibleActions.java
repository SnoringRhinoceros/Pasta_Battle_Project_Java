package com.example.generaltemplate;

public enum PossibleActions {
    FISTS (new Action("Fists", ActionGroupings.WEAPONS,
            new StatModifier("Fists", new Stats(0,0,0,0,0)),
            "Fists always work\nHowever, they only do your base damage", 100)),
    BASIC_SWORD (new Action("Basic sword", ActionGroupings.WEAPONS,
            new StatModifier("Basic sword", new Stats(0,10,0,0,0)),
            "Simple sword for a simple pasta\n+10 damage", 70)),
    STRAIGHT_SWORD(new Action("Straight sword", ActionGroupings.WEAPONS,
            new StatModifier("Straight sword", new Stats(0, 20, 0, 0, 0)),
            "A decent blade for a decent pasta.\n+20 damage", 80)),
    MASTER_SWORD (new Action("Master sword", ActionGroupings.WEAPONS
            , new StatModifier("Master Sword", new Stats(0, 30, 0, 5, 0)),
            "Perfectly balanced as all things should be\n+30 strength and +5 awesomeness", 100)),
    BASIC_HAMMER (new Action("Basic hammer", ActionGroupings.WEAPONS,
            new StatModifier("Basic hammer", new Stats(0, 20, 0, 0, 0)),
            "Not very accurate but pretty strong\n+20 damage", 35)),
    MEAT_HAMMER(new Action("Meat hammer", ActionGroupings.WEAPONS,
            new StatModifier("Normal hammer", new Stats(0, 40, 0, 0, 0)),
            "Hammer but for meat\n+40 damage", 50)),
    PRETTY_BIG_HAMMER (new Action("Pretty big hammer", ActionGroupings.WEAPONS,
            new StatModifier("Pretty big hammer", new Stats(0, 75, 0, 0, 0)),
            "It's big but not very accurate\n+65", 65)),
    BASIC_SAUCE (new Action("Basic sauce", ActionGroupings.SPELLS,
            new StatModifier("Basic Sauce", 10, new Stats(0,20,0,0,0)),
            "The first sauce a rotini ever learns\n+20 to sauce dmg for 5 ticks", 100)),
    MARINARA_SAUCE (new Action("Marinara sauce", ActionGroupings.SPELLS,
            new StatModifier("Marinara sauce", 10, new Stats(0, 20, 0, 0, 0)),
            "All good rotini start with the fundamentals\n+20 to sauce dmg for 10 ticks", 100)),
    BOLOGNESE (new Action("Bolognese", ActionGroupings.SPELLS,
            new StatModifier("Bolognese", 10, new Stats(0, 20, 0, 5, 0)),
            "The ultimate sauce\n+20 damage and +5 awesomeness", 100)),

    BASIC_ARMOR (new Action("Basic Armor", ActionGroupings.ARMOR,
            new StatModifier("Basic Armor", 1, new Stats(0, 0, 5, 0, 0)),
            "Some armor is better than no armor\n+5 defense", 100)),
    MEDIUM_ARMOR (new Action("Medium Armor", ActionGroupings.ARMOR,
                  new StatModifier("Medium armor", 1, new Stats(0, 0, 20, 0, 0)),
            "Middle of the pack\n+20 defense", 100)),
    AWESOME_ARMOR (new Action("Awesome armor", ActionGroupings.ARMOR,
            new StatModifier("Awesome armor", 1, new Stats(0, 0, 40, 5, 0)),
            "Armor that's pretty awesome\n+40 defense and +5 awesomeness", 100));


    private final Action action;

    PossibleActions(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}

package com.example.generaltemplate;

public enum ActionGroupings {
    WEAPONS("Weapons"),
    SPELLS("Spells"),
    ITEMS("Items"),
    MISC("Misc"),
    ARMOR("Armor");

    private final String name;

    ActionGroupings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ActionGroupings getActionGrouping(String name) {
        for (ActionGroupings actionGrouping : values()) {
            if (actionGrouping.getName().equals(name)) {
                return actionGrouping;
            }
        }
        throw new RuntimeException("Action grouping doesn't exist");
    }
}

package com.example.generaltemplate;

public enum EnemyType {
    MILITARY_POTATO ("Military potato", new Item(PossibleActions.BASIC_SWORD.getAction(), 1, 25),
            new Item(PossibleActions.BASIC_HAMMER.getAction(), 1, 25),
            new Item(PossibleActions.BASIC_ARMOR.getAction(), 1, 25),
            new Item(PossibleActions.BASIC_SAUCE.getAction(), 1, 25)),
    KUNG_FU_BREAD ("Kung fu bread", new Item(PossibleActions.STRAIGHT_SWORD.getAction(), 1, 25),
            new Item(PossibleActions.MARINARA_SAUCE.getAction(), 1, 25),
            new Item(PossibleActions.MEAT_HAMMER.getAction(), 1, 25),
            new Item(PossibleActions.MEDIUM_ARMOR.getAction(), 1, 25));

    private final String name;
    private final Item[] items;
    EnemyType(String name, Item... items) {
        this.name = name;
        this.items = items;
    }
    public static EnemyType getEnemyType(String name) {
        for (EnemyType enemyType : values()) {
            if (enemyType.getName().equals(name)) {
                return enemyType;
            }
        }
        throw new RuntimeException("Enemy type (" + name + ") doesn't exist");
    }

    public String getName() {
        return name;
    }

    public Item[] getPossibleDrops() {
        return items;
    }
}

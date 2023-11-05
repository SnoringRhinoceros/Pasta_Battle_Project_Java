package com.example.generaltemplate;

public enum EnemyType {
    MILITARY_POTATO ("Military potato", new Item(PossibleActions.BASIC_SWORD.getAction(), 1, 33),
            new Item(PossibleActions.BASIC_HAMMER.getAction(), 1, 33),
            new Item(PossibleActions.BASIC_SAUCE.getAction(), 1, 33));

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

package com.example.generaltemplate;

public enum EnemyType {
    MILITARY_POTATO ("Military potato", new Drop(PossibleActions.BASIC_SWORD.getAction(), 100, 2));

    private final String name;
    private final Drop[] drops;
    EnemyType(String name, Drop... drops) {
        this.name = name;
        this.drops = drops;
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

    public Drop[] getPossibleDrops() {
        return drops;
    }
}

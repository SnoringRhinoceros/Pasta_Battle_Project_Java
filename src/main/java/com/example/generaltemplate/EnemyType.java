package com.example.generaltemplate;

public enum EnemyType {
    MILITARY_POTATO ("MILITARY_POTATO", new PossibleDrop(PossibleActions.BASIC_SWORD, 100, 2));

    private final String name;
    private final PossibleDrop[] possibleDrops;
    EnemyType(String name, PossibleDrop ... possibleDrops) {
        this.name = name;
        this.possibleDrops = possibleDrops;
    }
    public static EnemyType getEnemyType(String name) {
        for (EnemyType enemyType : values()) {
            if (enemyType.getName().equals(name)) {
                return enemyType;
            }
        }
        throw new RuntimeException("Enemy type doesn't exist");
    }

    public String getName() {
        return name;
    }

    public PossibleDrop[] getPossibleDrops() {
        return possibleDrops;
    }
}

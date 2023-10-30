package com.example.generaltemplate;

public enum EnemyType {
    MILITARY_POTATO ("MILITARY_POTATO");

    private final String name;
    EnemyType(String name) {
        this.name = name;
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
}

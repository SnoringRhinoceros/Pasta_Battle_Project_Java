package com.example.generaltemplate;

public class World {
    private final PC player;
    private Battle curBattle;
    private final Crafter crafter;

    World(PC player) {
        this.player = player;
        crafter = new Crafter();
    }

    public void createBattle(Enemy enemy) {
        curBattle = new Battle(player, enemy);
    }

    public Enemy createNewEnemy(EnemyType enemyType, int enemyDifficulty) {
        if (enemyType.equals(EnemyType.MILITARY_POTATO)) {
            return new Enemy(EnemyType.MILITARY_POTATO, EnemyType.MILITARY_POTATO.getName(),
                    "Idaho/MILITARY_POTATO/" + enemyDifficulty + "/MILITARY_POTATO.png",
                    "idahoView",
                    "You encountered a random military potato named Joe",
                    20*enemyDifficulty, 5*enemyDifficulty,
                    5*enemyDifficulty, enemyDifficulty, enemyDifficulty);
        } else if (enemyType.equals(EnemyType.KUNG_FU_BREAD)) {
            return new Enemy(EnemyType.KUNG_FU_BREAD, EnemyType.KUNG_FU_BREAD.getName(),
                    "Bakery/KUNG_FU_BREAD/" + enemyDifficulty + "/KUNG_FU_BREAD.png",
                    "bakeryView",
                    "A piece of bread appears!",
                    30*enemyDifficulty, 10*enemyDifficulty,
                    10*enemyDifficulty, (int) (enemyDifficulty*1.2), enemyDifficulty);
        }
        throw new RuntimeException("Invalid enemy type");
    }

    public Battle getCurBattle() {
        return curBattle;
    }

    public PC getPlayer() {
        return player;
    }

    public Crafter getCrafter() {
        return crafter;
    }
}

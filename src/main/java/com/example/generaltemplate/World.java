package com.example.generaltemplate;

public class World {
    private final PC player;
    private Battle curBattle;

    World(PC player) {
        this.player = player;
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
                    5*enemyDifficulty, 5*enemyDifficulty);
        }
        throw new RuntimeException("Invalid enemy type");
    }

    public Battle getCurBattle() {
        return curBattle;
    }

    public PC getPlayer() {
        return player;
    }
}

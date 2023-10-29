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

    public Enemy createNewEnemy(EnemyType enemyType) {
        if (enemyType.equals(EnemyType.MILITARY_POTATO)) {
            return new Enemy("Joe", "Idaho/militaryPotato.png",
                    "idahoView",
                    "You encountered a random potato named Joe",
                    20, 5, 0, 0);
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

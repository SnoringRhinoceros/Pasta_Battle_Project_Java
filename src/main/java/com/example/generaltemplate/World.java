package com.example.generaltemplate;

import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {
    private final PC player;
    private Battle curBattle;
    private final Crafter crafter;
    private int time;
    private ArrayList<Enemy> allAliveEnemies;
    private ArrayList<Enemy> allEnemies;
    private final int END_TIME = 40;

    World(PC player) {
        this.player = player;
        crafter = new Crafter();
    }

    public void createBattle(Enemy enemy) {
        curBattle = new Battle(player, enemy);
    }

    public Enemy createNewEnemy(Button enemyBtn, EnemyType enemyType, int enemyDifficulty) {
        if (enemyType.equals(EnemyType.MILITARY_POTATO)) {
            return new Enemy(enemyBtn, EnemyType.MILITARY_POTATO, EnemyType.MILITARY_POTATO.getName(),
                    "Idaho/MILITARY_POTATO/" + enemyDifficulty + "/MILITARY_POTATO.png",
                    "idahoView",
                    "You encountered a random military potato named Joe",
                    20*enemyDifficulty, 5*enemyDifficulty,
                    5*enemyDifficulty, enemyDifficulty, enemyDifficulty);
        } else if (enemyType.equals(EnemyType.KUNG_FU_BREAD)) {
            return new Enemy(enemyBtn, EnemyType.KUNG_FU_BREAD, EnemyType.KUNG_FU_BREAD.getName(),
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

    public int getTime() {
        return time;
    }

    public ArrayList<Enemy> getAllAliveEnemies() {
        return allAliveEnemies;
    }

    public ArrayList<Enemy> getAllEnemies() {
        return allEnemies;
    }

    public void setAllEnemies(ArrayList<Enemy> allEnemies) {
        this.allEnemies = new ArrayList<>(allEnemies);
        allAliveEnemies = new ArrayList<>(allEnemies);
    }

    public void tickTime() {
        time += 1;
    }
    public void enemyDies(Enemy enemy) {
        for (Enemy aliveEnemy: allAliveEnemies){
            if (aliveEnemy.getButton().equals(enemy.getButton())) {
                enemy.getButton().setDisable(true);
                allAliveEnemies.remove(aliveEnemy);
                return;
            }
        }
    }

    public boolean allEnemiesAreDead() {
        return allAliveEnemies.isEmpty();
    }

    public boolean ends() {
        return getTime() >= END_TIME;
    }
}

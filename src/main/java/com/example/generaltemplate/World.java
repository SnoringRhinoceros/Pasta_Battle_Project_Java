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

    public Battle getCurBattle() {
        return curBattle;
    }

    public PC getPlayer() {
        return player;
    }
}

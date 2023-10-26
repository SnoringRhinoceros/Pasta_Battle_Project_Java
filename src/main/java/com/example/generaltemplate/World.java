package com.example.generaltemplate;

public class World {
    private final PC player;
    private Battle curBattle;

    World() {
        player = new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1);
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

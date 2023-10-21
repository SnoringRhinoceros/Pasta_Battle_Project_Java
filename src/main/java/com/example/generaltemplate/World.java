package com.example.generaltemplate;

public class World {
    private final PC player;
    private final BattleHandler battleHandler = new BattleHandler();

    World() {
        player = new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1);
    }

    public String handleBattle() {
        Enemy basic1 = new Enemy("slime", 5, 1, 0, 0);
        return battleHandler.getBattleOutcome(player, basic1);
    }
}

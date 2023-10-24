package com.example.generaltemplate;

public class World {
    private final PC player;
    private final Land idaho;
    private final Land bakery;
    private final Land riceFields;
    private final Land questionMark;
    private Battle curBattle;

    World() {
        idaho = new Land();
        bakery = new Land();
        riceFields = new Land();
        questionMark = new Land();
        player = new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1);
    }

    public void createBattle(Enemy enemy) {
        curBattle = new Battle(player, enemy);
    }
}

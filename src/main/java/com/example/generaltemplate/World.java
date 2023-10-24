package com.example.generaltemplate;

import javafx.scene.image.ImageView;

public class World {
    private final PC player;
    private final BattleHandler battleHandler;
    private final Land idaho;
    private final Land bakery;
    private final Land riceFields;
    private final Land questionMark;

    World() {
        battleHandler = new BattleHandler();
        idaho = new Land();
        bakery = new Land();
        riceFields = new Land();
        questionMark = new Land();
        player = new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1);
    }

    public String handleBattle() {
        Enemy basic1 = new Enemy("potato", 5, 1, 0, 0);
        return battleHandler.getBattleOutcome(player, basic1);
    }
}

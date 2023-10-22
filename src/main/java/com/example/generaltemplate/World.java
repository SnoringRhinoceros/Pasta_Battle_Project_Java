package com.example.generaltemplate;

import javafx.scene.image.ImageView;

public class World {
    private final PC player;
    private final BattleHandler battleHandler;
    private final Land idaho;
    private final Land bakery;
    private final Land riceFields;
    private final Land questionMark;

    World(ImageView idahoImg, ImageView bakeryImg, ImageView riceFieldsImg, ImageView questionMarkImg) {
        battleHandler = new BattleHandler();
        idaho = new Land(idahoImg);
        bakery = new Land(bakeryImg);
        riceFields = new Land(riceFieldsImg);
        questionMark = new Land(questionMarkImg);
        player = new PC("player", CharacterType.SPAGHETTI, 15, 2, 1, 1);
    }

    public String handleBattle() {
//        Enemy basic1 = new Enemy("potato", 5, 1, 0, 0);
//        return battleHandler.getBattleOutcome(player, basic1);
        return "";
    }
}

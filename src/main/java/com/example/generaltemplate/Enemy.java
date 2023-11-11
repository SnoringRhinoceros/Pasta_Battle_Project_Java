package com.example.generaltemplate;

import javafx.scene.control.Button;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Enemy extends LivingBeing {
    private final String imgPath;
    private final String entryText;
    private final PossibleDrops possibleDrops;
    private final EnemyType enemyType;
    private transient Button button;
    private String buttonId;

    public Enemy(Button button, EnemyType enemyType, String name, String imgPath, String loc, String entryText, int health, int strength, int defense, int awesomeness, int difficulty) {
        super(name, loc, health, strength, defense, awesomeness);
        this.button = button;
        this.enemyType = enemyType;
        this.imgPath = imgPath;
        this.entryText = entryText;
        possibleDrops = new PossibleDrops();
        for (Item item : enemyType.getPossibleDrops()) {
            possibleDrops.addItem(item.getAction(), item.getAmount() * difficulty, item.getDropChance());
        }
        buttonId = button.getId();
    }

    @Override
    public String getStatsText() {
        return getName() + "'s stats:" + "\n"
                + "Health, " + getStats().getCurHealth() + "/" + getStats().getMaxHealth() + "\n"
                + "Strength, " + getStats().getStrength() + "\n"
                + "Defense, " + getStats().getDefense() + "\n"
                + "Awesomeness, " + getStats().getAwesomeness() + "\n";
    }

    public Button getButton() {
        return button;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getEntryText() {
        return entryText;
    }

    public Item getRandDrop() {
        return possibleDrops.getRandDrop();
    }

    public String getButtonId() {
        return buttonId;
    }
    public void setButton(Button button) {
        this.button = button;
    }
}

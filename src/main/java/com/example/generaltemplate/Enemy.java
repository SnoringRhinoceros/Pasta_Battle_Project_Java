package com.example.generaltemplate;

import javafx.scene.image.ImageView;

public class Enemy extends LivingBeing{
    private ImageView img;
    public Enemy(String name, int health, int strength, int defense, int awesomeness) {
        super(name, health, strength, defense, awesomeness);
        this.img = img;
    }

    @Override
    public String getStats() {
        return getName() + " stats:" + "\n"
                + "health, " + getHealth() + "\n"
                + "strength, " + getStrength() + "\n"
                + "defense, " + getDefense() + "\n"
                + "awesomeness, " + getAwesomeness() + "\n";
    }
}

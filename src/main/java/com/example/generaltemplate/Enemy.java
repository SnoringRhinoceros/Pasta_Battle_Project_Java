package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    public Enemy(String name, int health, int strength, int defense, int awesomeness) {
        super(name, health, strength, defense, awesomeness);
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

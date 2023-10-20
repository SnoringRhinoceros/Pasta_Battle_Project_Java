package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    private final String name;
    public Enemy(String name, int health, int strength, int defense, int awesomeness) {
        super(health, strength, defense, awesomeness);
        this.name = name;
    }

    @Override
    public String getStats() {
        return name + " stats:" + "\n"
                + "health, " + getHealth() + "\n"
                + "strength, " + getStrength() + "\n"
                + "defense, " + getDefense() + "\n"
                + "awesomeness, " + getAwesomeness() + "\n";
    }
}

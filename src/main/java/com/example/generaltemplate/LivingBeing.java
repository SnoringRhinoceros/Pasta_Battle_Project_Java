package com.example.generaltemplate;

abstract public class LivingBeing {
    private int health;
    private int strength;
    private int defense;
    private int awesomeness;
    public LivingBeing(int health, int strength, int defense, int awesomeness) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.awesomeness = awesomeness;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getAwesomeness() {
        return awesomeness;
    }

    abstract public String getStats();
}

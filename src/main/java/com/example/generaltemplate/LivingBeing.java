package com.example.generaltemplate;

abstract public class LivingBeing {
    private final int health;
    private final int strength;
    private final int defense;
    private final int awesomeness;

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
}

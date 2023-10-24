package com.example.generaltemplate;

abstract public class LivingBeing {
    private String name;
    private int health;
    private int strength;
    private int defense;
    private int awesomeness;
    public LivingBeing(String name, int health, int strength, int defense, int awesomeness) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.awesomeness = awesomeness;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int amount) {
        health += amount;
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

    public boolean isDead() {return health <= 0;}

    abstract public String getStats();
}

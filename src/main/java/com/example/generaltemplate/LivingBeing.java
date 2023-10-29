package com.example.generaltemplate;

abstract public class LivingBeing {
    private String name;
    private int maxHealth;
    private int strength;
    private int defense;
    private int awesomeness;
    private int curHealth;
    public LivingBeing(String name, int maxHealth, int strength, int defense, int awesomeness) {
        this.name = name;
        this.maxHealth = maxHealth;
        curHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.awesomeness = awesomeness;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void loseHealth(int amount) {
        curHealth -= amount;
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

    public int getCurHealth() {
        return curHealth;
    }

    public boolean isDead() {return curHealth <= 0;}

    abstract public String getStats();
}

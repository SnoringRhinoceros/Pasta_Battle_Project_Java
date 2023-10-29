package com.example.generaltemplate;

abstract public class LivingBeing {
    private String name;
    private int maxHealth;
    private int strength;
    private int defense;
    private int awesomeness;
    private int curHealth;
    private String loc;
    public LivingBeing(String name, String loc, int maxHealth, int strength, int defense, int awesomeness) {
        this.name = name;
        this.maxHealth = maxHealth;
        curHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.awesomeness = awesomeness;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public String getLoc() {
        return loc;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void loseHealth(int amount) {
        if (curHealth - amount <= 0) {
            curHealth = 0;
        } else {
            curHealth -= amount;
        }
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

    public void travelTo(String place) {
        loc = place;
    }

    abstract public String getStats();
}

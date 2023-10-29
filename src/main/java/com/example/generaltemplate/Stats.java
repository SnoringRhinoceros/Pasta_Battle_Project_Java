package com.example.generaltemplate;

public class Stats {
    private int maxHealth;
    private int strength;
    private int defense;
    private int awesomeness;
    private int curHealth;

    public Stats(int maxHealth, int strength, int defense, int awesomeness, int curHealth) {
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.awesomeness = awesomeness;
        this.curHealth = curHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(int awesomeness) {
        this.awesomeness = awesomeness;
    }

    public int getCurHealth() {
        return curHealth;
    }

    public void setCurHealth(int curHealth) {
        this.curHealth = curHealth;
    }
}

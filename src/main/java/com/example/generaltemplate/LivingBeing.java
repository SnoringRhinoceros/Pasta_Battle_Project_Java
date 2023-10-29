package com.example.generaltemplate;

import java.util.ArrayList;

abstract public class LivingBeing {
    private String name;
    private int maxHealth;
    private int strength;
    private int defense;
    private int awesomeness;
    private int curHealth;
    private String loc;
    private final ArrayList<Action> actions = new ArrayList<>();
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

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAwesomeness(int awesomeness) {
        this.awesomeness = awesomeness;
    }

    public boolean isDead() {return curHealth <= 0;}

    public void travelTo(String place) {
        loc = place;
    }

    abstract public String getStats();
}

package com.example.generaltemplate;

import java.util.ArrayList;

abstract public class LivingBeing {
    private String name;
    private Stats stats;
    private StatModifiersOwned statModifiersOwned;
    private String loc;
    private final ArrayList<Action> actions = new ArrayList<>();
    public LivingBeing(String name, String loc, int maxHealth, int strength, int defense, int awesomeness) {
        this.name = name;
        stats = new Stats(maxHealth, strength, defense, awesomeness, maxHealth);
        statModifiersOwned = new StatModifiersOwned();
        this.loc = loc;
    }

    public String getName() {
        return name;
    }
    public StatModifiersOwned getStatModifiersOwned() {
        return statModifiersOwned;
    }

    public String getLoc() {
        return loc;
    }

    public void loseHealth(int amount) {
        if (stats.getCurHealth() - amount <= 0) {
            stats.setCurHealth(0);
        } else {
            stats.setCurHealth(stats.getCurHealth()-amount);
        }
    }
    public ArrayList<Action> getActions() {
        return actions;
    }

    public boolean isDead() {return stats.getCurHealth() <= 0;}

    public void travelTo(String place) {
        loc = place;
    }

    public Stats getStats() {return stats;}

    abstract public String getStatsText();

    public void passTick() {
        getStatModifiersOwned().decrementStatDurations();
        getStatModifiersOwned().clearFinishedStats();
    }
}

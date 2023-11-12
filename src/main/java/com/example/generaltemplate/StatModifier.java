package com.example.generaltemplate;

import java.io.Serializable;
import java.util.ArrayList;

public class StatModifier extends Stats implements Serializable {

    private final String reason;
    private int duration;

    public StatModifier(String reason, int maxHealth, int strength, int defense, int awesomeness, int curHealth) {
        super(maxHealth, strength, defense, awesomeness, curHealth);
        this.reason = reason;
    }


    public StatModifier(String reason, Stats stat) {
        super(stat);
        this.reason = reason;
    }

    public StatModifier(String reason, int duration, Stats stat) {
        super(stat);
        this.reason = reason;
        this.duration = duration;
    }

    public StatModifier(StatModifier statModifier) {
        super(statModifier.getMaxHealth(), statModifier.getStrength(), statModifier.getDefense(), statModifier.getAwesomeness(), statModifier.getCurHealth());
        this.reason = statModifier.getReason();
        duration = statModifier.getDuration();
    }

    public StatModifier(StatModifier statModifier, int duration) {
        super(statModifier.getMaxHealth(), statModifier.getStrength(), statModifier.getDefense(), statModifier.getAwesomeness(), statModifier.getCurHealth());
        this.reason = statModifier.getReason();
        this.duration = duration;
    }

    public void modify(Stats stat) {
        stat.setMaxHealth(stat.getMaxHealth() + getMaxHealth());
        stat.setStrength(stat.getStrength() + getStrength());
        stat.setDefense(stat.getDefense() + getDefense());
        stat.setAwesomeness(stat.getAwesomeness() + getAwesomeness());
        stat.setCurHealth(stat.getCurHealth() + getCurHealth());
    }

    public String getReason() {
        return reason;
    }

    public int getDuration() {
        return duration;
    }

    public void decrementDuration() {
        duration -= 1;
    }

    public void addDuration(int amount) {
        duration += amount;
    }

    public String getText() {
        StringBuilder result = new StringBuilder();

        result.append(getReason()).append(" (").append(getDuration()).append(" ticks) \n");
        if (getMaxHealth() != 0) {
            result.append("  Max Health: ").append(getPosOrNeg(getMaxHealth()));
        }
        if (getStrength() != 0) {
            result.append("  Strength: ").append(getPosOrNeg(getStrength()));
        }
        if (getDefense() != 0) {
            result.append("  Defense: ").append(getPosOrNeg(getDefense()));
        }
        if (getAwesomeness() != 0) {
            result.append("  Awesomeness: ").append(getPosOrNeg(getAwesomeness()));
        }
        if (getCurHealth() != 0) {
            result.append("  Current Health").append(getPosOrNeg(getCurHealth()));
        }
        return result.toString();
    }

    private String getPosOrNeg(int num) {
        if (num > 0) {
            return "+" + num;
        }
        return "-" + num;
    }
}

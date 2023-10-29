package com.example.generaltemplate;

public class StatModifier extends Stats {

    private final String reason;
    public StatModifier(String reason, int maxHealth, int strength, int defense, int awesomeness, int curHealth) {
        super(maxHealth, strength, defense, awesomeness, curHealth);
        this.reason = reason;
    }

    public void modify(Stats stat) {
        stat.setMaxHealth(stat.getMaxHealth() + getMaxHealth());
        stat.setStrength(stat.getStrength() + getStrength());
        stat.setDefense(stat.getDefense() + getDefense());
        stat.setAwesomeness(stat.getAwesomeness() + getAwesomeness());
        stat.setCurHealth(stat.getAwesomeness() + getCurHealth());
    }

    public String getReason() {
        return reason;
    }
}

package com.example.generaltemplate;

import java.util.ArrayList;

public class PC extends LivingBeing {
    private final CharacterType characterType;
    public PC(String name, String loc, CharacterType characterType, int maxHealth, int strength, int defense, int awesomeness) {
        super(name, loc, maxHealth, strength, defense, awesomeness);
        this.characterType = characterType;
        getActions().add(new Action(PossibleActions.FISTS));
    }

    @Override
    public String getStats() {
        return "Your stats:" + "\n"
                + "Health, " + getCurHealth() + "/" + getMaxHealth() + "\n"
                + "Strength, " + getStrength() + "\n"
                + "Defense, " + getDefense() + "\n"
                + "Awesomeness, " + getAwesomeness() + "\n";
    }
}

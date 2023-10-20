package com.example.generaltemplate;

public class PC extends LivingBeing {
    private final CharacterType characterType;

    public PC(String name, CharacterType characterType, int health, int strength, int defense, int awesomeness) {
        super(name, health, strength, defense, awesomeness);
        this.characterType = characterType;
    }

    @Override
    public String getStats() {
        return characterType.name().toLowerCase() + " " + getName() + " " + "stats:" + "\n"
                + "health, " + getHealth() + "\n"
                + "strength, " + getStrength() + "\n"
                + "defense, " + getDefense() + "\n"
                + "awesomeness, " + getAwesomeness() + "\n";
    }
}

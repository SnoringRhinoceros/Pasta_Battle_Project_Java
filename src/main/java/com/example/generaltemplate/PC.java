package com.example.generaltemplate;
public class PC extends LivingBeing {
    private final CharacterType characterType;

    public PC(String name, String loc, CharacterType characterType, int maxHealth, int strength, int defense, int awesomeness) {
        super(name, loc, maxHealth, strength, defense, awesomeness);
        this.characterType = characterType;
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

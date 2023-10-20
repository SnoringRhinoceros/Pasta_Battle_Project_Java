package com.example.generaltemplate;

public class PlayableCharacter extends LivingBeing {
    private final CharacterType characterType;

    public PlayableCharacter(CharacterType characterType, int health, int strength, int defense, int awesomeness) {
        super(health, strength, defense, awesomeness);
        this.characterType = characterType;
    }

    public CharacterType characterType() {
        return characterType;
    }

    @Override
    public String getStats() {
        return characterType.name() + " stats:" + "\n"
                + "health, " + getHealth() + "\n"
                + "strength, " + getStrength() + "\n"
                + "defense, " + getDefense() + "\n"
                + "awesomeness, " + getAwesomeness() + "\n";
    }
}

package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    private String imgPath;
    private String entryText;
    public Enemy(String name, String imgPath, String entryText, int health, int strength, int defense, int awesomeness) {
        super(name, health, strength, defense, awesomeness);
        this.imgPath = imgPath;
        this.entryText = entryText;
    }

    @Override
    public String getStats() {
        return getName() + "'s stats:" + "\n"
                + "Health, " + getCurHealth() + "/" + getMaxHealth() + "\n"
                + "Strength, " + getStrength() + "\n"
                + "Defense, " + getDefense() + "\n"
                + "Awesomeness, " + getAwesomeness() + "\n";
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getEntryText() {
        return entryText;
    }
}

package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    private String imgPath;
    private String entryText;
    public Enemy(String name, String imgPath, String loc, String entryText, int health, int strength, int defense, int awesomeness) {
        super(name, loc, health, strength, defense, awesomeness);
        this.imgPath = imgPath;
        this.entryText = entryText;
    }

    @Override
    public String getStatsText() {
        return getName() + "'s stats:" + "\n"
                + "Health, " + getStats().getCurHealth() + "/" + getStats().getMaxHealth() + "\n"
                + "Strength, " + getStats().getStrength() + "\n"
                + "Defense, " + getStats().getDefense() + "\n"
                + "Awesomeness, " + getStats().getAwesomeness() + "\n";
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getEntryText() {
        return entryText;
    }
}

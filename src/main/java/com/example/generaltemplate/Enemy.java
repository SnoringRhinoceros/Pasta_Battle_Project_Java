package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    private String imgPath;
    private String entryText;
    private final PossibleDrops possibleDrops;
    private EnemyType enemyType;
    public Enemy(EnemyType enemyType, String name, String imgPath, String loc, String entryText, int health, int strength, int defense, int awesomeness) {
        super(name, loc, health, strength, defense, awesomeness);
        this.enemyType = enemyType;
        this.imgPath = imgPath;
        this.entryText = entryText;
        possibleDrops = new PossibleDrops();
        for (PossibleDrop possibleDrop: enemyType.getPossibleDrops()) {
            possibleDrops.addDrop(possibleDrop);
        }
    }

    @Override
    public String getStatsText() {
        return getName() + "'s stats:" + "\n"
                + "Health, " + getStats().getCurHealth() + "/" + getStats().getMaxHealth() + "\n"
                + "Strength, " + getStats().getStrength() + "\n"
                + "Defense, " + getStats().getDefense() + "\n"
                + "Awesomeness, " + getStats().getAwesomeness() + "\n";
    }

    public EnemyType getEnemyType() {return enemyType;}
    public String getImgPath() {
        return imgPath;
    }

    public String getEntryText() {
        return entryText;
    }

    public PossibleDrop getRandDrop() {
        return possibleDrops.getRandDrop();
    }
}

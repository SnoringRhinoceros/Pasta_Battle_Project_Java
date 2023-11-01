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
        for (Drop drop : enemyType.getPossibleDrops()) {
            possibleDrops.addDrop(drop);
        }
    }

    @Override
    public String getStatsText() {
        return getNormalName() + "'s stats:" + "\n"
                + "Health, " + getStats().getCurHealth() + "/" + getStats().getMaxHealth() + "\n"
                + "Strength, " + getStats().getStrength() + "\n"
                + "Defense, " + getStats().getDefense() + "\n"
                + "Awesomeness, " + getStats().getAwesomeness() + "\n";
    }

    public String getNormalName() {
        String[] nameArray = getName().split("_");
        StringBuilder result = new StringBuilder();
        for (String word: nameArray) {
            result.append(word.toLowerCase());
            result.append(" ");
        }
        // removes the last space at the end
        return result.substring(0, result.length()-1);
    }

    public EnemyType getEnemyType() {return enemyType;}
    public String getImgPath() {
        return imgPath;
    }

    public String getEntryText() {
        return entryText;
    }

    public Drop getRandDrop() {
        return possibleDrops.getRandDrop();
    }
}

package com.example.generaltemplate;

public class Enemy extends LivingBeing{
    private String imgPath;
    private String entryText;
    private final PossibleDrops possibleDrops;
    private EnemyType enemyType;
    private int difficulty;
    public Enemy(EnemyType enemyType, String name, String imgPath, String loc, String entryText, int health, int strength, int defense, int awesomeness, int difficulty) {
        super(name, loc, health, strength, defense, awesomeness);
        this.enemyType = enemyType;
        this.imgPath = imgPath;
        this.entryText = entryText;
        this.difficulty = difficulty;
        possibleDrops = new PossibleDrops();
        for (Item item : enemyType.getPossibleDrops()) {
            possibleDrops.addItem(item.getAction(), item.getAmount()*difficulty, item.getDropChance());
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

    public Item getRandDrop() {
        return possibleDrops.getRandDrop();
    }
}

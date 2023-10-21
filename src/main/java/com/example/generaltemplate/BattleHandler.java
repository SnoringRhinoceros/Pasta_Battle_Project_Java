package com.example.generaltemplate;

public class BattleHandler {
    private PC player;
    private Enemy enemy;
    private LivingBeing curBeing;
    public String getBattleOutcome(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        StringBuilder result = new StringBuilder();
        curBeing = player;
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int dmgDealt = curBeing.getStrength()+getOpp(curBeing).getDefense();
            if (dmgDealt <= 0) {
                result.append("\n " + curBeing.getName() + " did no damage.");
            } else {
                result.append("\n " + curBeing.getName() + " attacked for " + dmgDealt + " damage.");
                getOpp(curBeing).addHealth(-dmgDealt);
            }
            curBeing = getOpp(curBeing);
        }
        return result.toString();
    }

    private LivingBeing getOpp(LivingBeing being) {
        if (being.equals(player)) {
            return enemy;
        }
        return player;
    }

    // make another method to get what items are dropped
}

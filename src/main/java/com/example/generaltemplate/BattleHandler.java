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
            int healthToAdd = -curBeing.getStrength()+getOpp(curBeing).getDefense();
            if (healthToAdd >= 0) {
                result.append("\n " + getOpp(curBeing).getName() + " did no damage");
            } else {
                getOpp(curBeing).addHealth(healthToAdd);
            }
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

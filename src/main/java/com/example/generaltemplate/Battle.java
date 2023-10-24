package com.example.generaltemplate;

public class Battle {
    private PC player;
    private Enemy enemy;
    private LivingBeing curBeing;
    private int turnNum = 1;
    private String result;

    public Battle(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        curBeing = this.player;
    }

    public String runTurn(String chosenAction) {
        result = "";
        doDmg();
        endTurn();
        doDmg();
        endTurn();
        return result;
    }

    private String doDmg() {
        int dmgDealt = getDmgDealt();
        getOpp(curBeing).addHealth(-dmgDealt);
        result += getDmgText(dmgDealt);
        return result;
    }

    private void endTurn() {
        curBeing = getOpp(curBeing);
        turnNum++;
    }

    private int getDmgDealt() {
        int dmgDealt = curBeing.getStrength()-getOpp(curBeing).getDefense();
        if (dmgDealt <= 0) {
            dmgDealt = 0;
        }
        return dmgDealt;
    }

    private String getDmgText(int dmgDealt) {
        StringBuilder result = new StringBuilder();
        if (dmgDealt == 0) {
            result.append(curBeing.getName() + " did no damage.");
        } else {
            result.append(curBeing.getName() + " attacked for " + dmgDealt + " damage.");
        }
        if (getOpp(curBeing).isDead()) {
            result.append("\n" + getOpp(curBeing).getName() + " is dead. " + curBeing.getName() + " wins");
        }
        return result.toString();
    }

    private LivingBeing getOpp(LivingBeing being) {
        if (being.equals(player)) {
            return enemy;
        }
        return player;
    }
}

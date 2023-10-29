package com.example.generaltemplate;

public class Battle {
    private PC player;
    private Enemy enemy;
    private LivingBeing curBeing;
    private int turnNum = 1;
    private String result;
    private LivingBeing winner;
    private BattleState state = BattleState.PLAYER_TURN;

    public Battle(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        curBeing = this.player;
    }

    public String runTurn(String chosenAction) {
        result = "";
        doDmg();
        if (battleDone()) {
            state = BattleState.BATTLE_OVER;
            return result;
        }
        endTurn();
        return result;
    }

    public String runTurn() {
        return runTurn("Enemy turn");
    }

    private String doDmg() {
        int dmgDealt = getDmgDealt();
        getOpp(curBeing).loseHealth(dmgDealt);
        result += getDmgText(dmgDealt);
        return result;
    }

    private boolean battleDone() {
        if (curBeing.isDead()) {
            winner = getOpp(curBeing);
            return true;
        } else if (getOpp(curBeing).isDead()) {
            winner = curBeing;
            return true;
        }
        return false;
    }

    private void endTurn() {
        curBeing = getOpp(curBeing);
        if (curBeing.equals(player)) {
            state = BattleState.PLAYER_TURN;
        } else if (curBeing.equals(enemy)) {
            state = BattleState.ENEMY_TURN;
        }
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

    public int getTurnNum() {
        return turnNum;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public BattleState getState() {
        return state;
    }
}

package com.example.generaltemplate;

public class Battle {
    private PC player;
    private Enemy enemy;
    private LivingBeing curBeing;
    private int turnNum = 1;
    private String result;
    private LivingBeing winner;
    private BattleState state = BattleState.PLAYER_TURN;
    private Item enemyItem;

    public Battle(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        curBeing = this.player;
    }

    public String runTurn(Action chosenAction) {
        player.passTick();
        result = "";
        if (chosenAction.getGrouping().equals(ActionGroupings.SPELLS)) {
            curBeing.getStatModifiersOwned().addStatModif(new StatModifier(chosenAction.getStatModifier()));
            result = curBeing.getName() + " casts a " + chosenAction.getName() + " spell";
        } else {
            doDmg(chosenAction);
            curBeing.getStatModifiersOwned().clearFinishedStats();
        }
        winner = getWinner();
        if (winner != null) {
            state = BattleState.BATTLE_OVER;
            if (winner.equals(player)) {
                enemyItem = enemy.getRandDrop();
                player.addItem(new Item(enemyItem));
                result += "\nenemy dropped " + enemyItem.getAmount() + " " + enemyItem.getAction().getName() + " (" + enemyItem.getDropChance() + "%)";
            }
            return result;
        }
        endTurn();
        return result;
    }

    public String runTurn() {
        return runTurn(PossibleActions.FISTS.getAction());
    }

    private String doDmg(Action chosenAction) {
        int dmgDealt = getDmgDealt(chosenAction);
        getOpp(curBeing).loseHealth(dmgDealt);
        result += getDmgText(dmgDealt);
        return result;
    }

    private int getDmgDealt(Action chosenAction) {
        curBeing.getStatModifiersOwned().addStatModif(new StatModifier(chosenAction.getStatModifier(), 0));
        Stats curBeingModifiedStats = curBeing.getStatModifiersOwned().getTotalStatModif(curBeing.getStats());
        int dmgDealt = curBeingModifiedStats.getStrength();
        Stats oppBeingModifiedStats = getOpp(curBeing).getStatModifiersOwned().getTotalStatModif(getOpp(curBeing).getStats());
        int dmgOpposed = oppBeingModifiedStats.getDefense();
        dmgDealt = dmgDealt - dmgOpposed;
        if (dmgDealt <= 0) {
            dmgDealt = 0;
        }
        return dmgDealt;
    }

    private LivingBeing getWinner() {
        if (curBeing.isDead()) {
            return getOpp(curBeing);
        } else if (getOpp(curBeing).isDead()) {
            return curBeing;
        }
        return null;
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

    private String getDmgText(int dmgDealt) {
        StringBuilder result = new StringBuilder();
        if (dmgDealt == 0) {
            result.append(curBeing.getName() + " did no damage.");
        } else {
            result.append(curBeing.getName() + " attacked for " + dmgDealt + " damage.");
        }
        if (getOpp(curBeing).isDead()) {
            result.append(" " + curBeing.getName() + " wins!");
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

    public Item getEnemyDrop() {
        return enemyItem;
    }
}

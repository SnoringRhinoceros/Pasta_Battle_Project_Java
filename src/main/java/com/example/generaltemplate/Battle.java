package com.example.generaltemplate;

import static com.example.generaltemplate.GameController.generateRandNum;

public class Battle {
    private final PC player;
    private final Enemy enemy;
    private LivingBeing curBeing;
    private int turnNum = 1;
    private String result;
    private BattleState state = BattleState.PLAYER_TURN;

    public Battle(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        curBeing = this.player;
    }

    public String runTurn(Action chosenAction) {
        player.passTick();
        result = "";
        StatModifier statModifier = new StatModifier("Armor", 0, 0, 0, 0, 0);
        for (Item armor: getOpp(curBeing).getEquippedArmor()) {
            armor.getAction().statModifier().modify(statModifier);
        }
        getOpp(curBeing).getStatModifiersOwned().addStatModif(new StatModifier(statModifier));
        if (chosenAction.grouping().equals(ActionGroupings.SPELLS)) {
            curBeing.getStatModifiersOwned().addStatModif(new StatModifier(chosenAction.statModifier()));
            result = curBeing.getName() + " casts a " + chosenAction.name() + " spell";
        } else {
            doDmg(chosenAction);
            curBeing.getStatModifiersOwned().clearFinishedStats();
        }
        LivingBeing winner = getWinner();
        if (winner != null) {
            state = BattleState.BATTLE_OVER;
            if (winner.equals(player)) {
                Item enemyItem = enemy.getRandDrop();
                if (enemyItem != null) {
                    player.addItem(new Item(enemyItem));
                    result += "\nenemy dropped " + enemyItem.getAmount() + " " + enemyItem.getAction().name() + " (" + enemyItem.getDropChance() + "%)";
                }
            }
            return result;
        }
        endTurn();
        return result;
    }

    public String runTurn() {
        return runTurn(PossibleActions.FISTS.getAction());
    }

    private void doDmg(Action chosenAction) {
        int dmgDealt = getDmgDealt(chosenAction);
        if (dmgDealt <= 0) {
            result += getDmgText(dmgDealt);
        } else {
            if (getAttackHits(chosenAction)) {
                getOpp(curBeing).loseHealth(dmgDealt);
                result += getDmgText(dmgDealt);
            }
        }
    }

    private boolean getAttackHits(Action chosenAction) {
        int randNum = generateRandNum(1, 100);
        int awesomeModif = curBeing.getModifStats().getAwesomeness() - getOpp(curBeing).getModifStats().getAwesomeness();
        int changedAccuracy = chosenAction.accuracy();
        boolean curBeingIsMorAwesome;
        if (awesomeModif > 0) {
            changedAccuracy *= awesomeModif;
            curBeingIsMorAwesome = true;
        } else {
            if (awesomeModif == 0) {
                awesomeModif = -1;
            }
            awesomeModif *= -1;
            changedAccuracy /= awesomeModif;
            curBeingIsMorAwesome = false;
        }
        boolean attackHits = randNum <= changedAccuracy;
        if (attackHits) {
            if (curBeingIsMorAwesome) {
                result += curBeing.getName() + "'s attack hits\n";
            } else {
                result += "Despite " + getOpp(curBeing).getName() + "'s superior awesomeness, "
                        + curBeing.getName() + "'s attack hits!\n";
            }
        } else {
            if (curBeingIsMorAwesome) {
                result += "\nDespite " + curBeing.getName() + "'s superior awesomeness, "
                        + curBeing.getName() + "'s attack misses!";
            } else {
                result += "\n" + curBeing.getName() + "'s attack misses";
            }
        }
        return attackHits;
    }

    private int getDmgDealt(Action chosenAction) {
        curBeing.getStatModifiersOwned().addStatModif(new StatModifier(chosenAction.statModifier(), 0));
        Stats curBeingModifiedStats = curBeing.getModifStats();
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
            result.append(curBeing.getName()).append(" did no damage.");
        } else {
            result.append(curBeing.getName()).append(" attacked for ").append(dmgDealt).append(" damage.");
        }
        if (getOpp(curBeing).isDead()) {
            result.append(" ").append(curBeing.getName()).append(" wins!");
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

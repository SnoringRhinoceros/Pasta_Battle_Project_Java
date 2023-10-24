package com.example.generaltemplate;

public class Battle {
    private PC player;
    private Enemy enemy;
    private LivingBeing curBeing;
    private int turnNum;
    private String result;

    public Battle(PC player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        curBeing = this.player;
    }

    private void runPlayerTurn(String chosenAction) {

    }

    private void runEnemyTurn() {

    }
}

package com.example.generaltemplate;

import java.util.ArrayList;

public class PossibleDrops {
    private final ArrayList<Drop> drops = new ArrayList<>();

    public PossibleDrops(Drop... inputtedDrop) {
        for (Drop drop: inputtedDrop) {
            addDrop(drop);
        }
    }

    public void addDrop(Action action, int dropChance, int amount) {
        drops.add(new Drop(action, dropChance, amount));
    }

    public void addDrop(Drop drop) {
        addDrop(drop.action(), drop.dropChance(), drop.amount());
    }

    public Drop getRandDrop() {
        int randNum = generateRandNum(1, 100);
        int percentCount = 0;
        for (Drop drop : drops) {
            if (randNum >= percentCount && randNum <= drop.dropChance()+percentCount) {
                return drop;
            }
            percentCount += drop.dropChance();
        }
        return null;
    }

    public static int generateRandNum(int min, int max) {
        return min + (int) (Math.random()*((max - min) + 1));
    }

}

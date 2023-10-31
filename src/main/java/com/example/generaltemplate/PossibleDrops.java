package com.example.generaltemplate;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class PossibleDrops {
    private final ArrayList<PossibleDrop> drops = new ArrayList<>();

    public PossibleDrops(PossibleDrop ... inputtedPossibleDrop) {
        for (PossibleDrop drop: inputtedPossibleDrop) {
            addDrop(drop);
        }
    }

    public void addDrop(PossibleActions action, int dropChance, int amount) {
        drops.add(new PossibleDrop(action, dropChance, amount));
    }

    public void addDrop(PossibleDrop possibleDrop) {
        addDrop(possibleDrop.drop(), possibleDrop.dropChance(), possibleDrop.amount());
    }

    public PossibleDrop getRandDrop() {
        int randNum = generateRandNum(1, 100);
        int percentCount = 0;
        for (PossibleDrop possibleDrop: drops) {
            if (randNum >= percentCount && randNum <= possibleDrop.dropChance()+percentCount) {
                return possibleDrop;
            }
            percentCount += possibleDrop.dropChance();
        }
        return null;
    }

    public static int generateRandNum(int min, int max) {
        return min + (int) (Math.random()*((max - min) + 1));
    }

}

package com.example.generaltemplate;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class PossibleDrops {
    private final ArrayList<PossibleDrop> drops = new ArrayList<>();

    public record PossibleDrop(PossibleActions drop, int dropChance) {
    }

    public void addDrop(PossibleActions action, int dropChance) {
        drops.add(new PossibleDrop(action, dropChance));
    }

    public PossibleActions getRandDrop() {
        int randNum = generateRandNum(1, 100);
        int percentCount = 0;
        for (PossibleDrop possibleDrop: drops) {
            if (randNum >= percentCount && randNum <= possibleDrop.dropChance()+percentCount) {
                return possibleDrop.drop;
            }
            percentCount += possibleDrop.dropChance();
        }
        return null;
    }

    public static int generateRandNum(int min, int max) {
        return min + (int) (Math.random()*((max - min) + 1));
    }

}

package com.example.generaltemplate;

import java.util.ArrayList;

public class PossibleDrops {
    private final ArrayList<Item> items = new ArrayList<>();

    public PossibleDrops(Item... inputtedItem) {
        for (Item item : inputtedItem) {
            addDrop(item);
        }
    }

    public void addDrop(Action action, int dropChance, int amount) {
        items.add(new Item(action, dropChance, amount));
    }

    public void addDrop(Item item) {
        addDrop(item.getAction(), item.getDropChance(), item.getDropChance());
    }

    public Item getRandDrop() {
        int randNum = generateRandNum(1, 100);
        int percentCount = 0;
        for (Item item : items) {
            if (randNum >= percentCount && randNum <= item.getDropChance()+percentCount) {
                return item;
            }
            percentCount += item.getDropChance();
        }
        return null;
    }

    public static int generateRandNum(int min, int max) {
        return min + (int) (Math.random()*((max - min) + 1));
    }

}

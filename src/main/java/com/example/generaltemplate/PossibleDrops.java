package com.example.generaltemplate;

import java.util.ArrayList;

public class PossibleDrops {
    private final ArrayList<Item> items = new ArrayList<>();

    public PossibleDrops(Item... inputtedItem) {
        for (Item item : inputtedItem) {
            addItem(item);
        }
    }

    public void addItem(Action action, int amount) {
        items.add(new Item(action, amount));
    }

    public void addItem(Action action, int amount, int dropChance) {
        items.add(new Item(action, amount, dropChance));
    }

    public void addItem(Item item) {
        addItem(item.getAction(), item.getAmount());
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

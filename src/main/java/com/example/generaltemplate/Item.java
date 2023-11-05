package com.example.generaltemplate;

public class Item {

    private Action action;
    private int dropChance;
    private int amount;

    public Item(Action action, int dropChance, int amount) {
        this.action = action;
        this.dropChance = dropChance;
        this.amount = amount;
    }

    public Item(Item item) {
        this(item.getAction(), item.getDropChance(), item.getAmount());
    }

    public void addAmount(int amountToAdd) {
        amount += amountToAdd;
    }

    public Action getAction() {
        return action;
    }

    public int getDropChance() {
        return dropChance;
    }

    public int getAmount() {
        return amount;
    }
}

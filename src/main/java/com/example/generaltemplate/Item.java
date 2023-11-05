package com.example.generaltemplate;

public class Item {

    private Action action;
    private int amount;
    private int dropChance;
    private boolean markedForDeletion = false;

    public Item(Action action, int amount) {
        this.action = action;
        this.amount = amount;
    }

    public Item(Item item) {
        this(item.getAction(), item.getAmount(), item.getDropChance());
    }

    public Item(Action action, int amount, int dropChance) {
        this.action = action;
        this.amount = amount;
        this.dropChance = dropChance;
    }

    public void addAmount(int amountToAdd) {
        amount += amountToAdd;
    }

    public void subtractAmount(int amountToSubtract) {
        amount -= amountToSubtract;
        if (amount == 0) {
            markedForDeletion = true;
        }
        if (amount < 0) {
            throw new RuntimeException("You subtracted a too big of an amount of items");
        }
    }

    public int getDropChance() {
        return dropChance;
    }

    public Action getAction() {
        return action;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isMarkedForDeletion() {
        return markedForDeletion;
    }
}

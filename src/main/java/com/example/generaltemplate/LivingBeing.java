package com.example.generaltemplate;

import java.util.ArrayList;

abstract public class LivingBeing {
    private String name;
    private Stats stats;
    private StatModifiersOwned statModifiersOwned;
    private String loc;
    private final ArrayList<Action> actions = new ArrayList<>();
    private final ArrayList<Item> items = new ArrayList<>();
    public LivingBeing(String name, String loc, int maxHealth, int strength, int defense, int awesomeness) {
        this.name = name;
        stats = new Stats(maxHealth, strength, defense, awesomeness, maxHealth);
        statModifiersOwned = new StatModifiersOwned();
        this.loc = loc;
    }

    public String getName() {
        return name;
    }
    public StatModifiersOwned getStatModifiersOwned() {
        return statModifiersOwned;
    }

    public String getLoc() {
        return loc;
    }

    public void loseHealth(int amount) {
        stats.setCurHealth(Math.max(stats.getCurHealth() - amount, 0));
    }
    public ArrayList<Action> getActions() {
        return actions;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Action getAction(String actionName) {
        for (Action action : actions) {
            if (action.getName().equals(actionName)) {
                return action;
            }
        }

        for (Item item : items) {
            if (item.getAction().getName().equals(actionName)) {
                return item.getAction();
            }
        }
        return null;
    }

    public void addItem(Item drop) {
        for (Item item: items) {
            if (item.getAction().getName().equals(drop.getAction().getName())) {
                item.addAmount(drop.getAmount());
                return;
            }
        }
        items.add(drop);
    }

    public void subtractItem(Item itemToSubtract, int amount) {
        for (Item item: items) {
            if (item.getAction().equals(itemToSubtract.getAction())) {
                item.subtractAmount(amount);
                if (item.isMarkedForDeletion()) {
                    items.remove(item);
                }
                return;
            }
        }
    }

    public boolean isDead() {return stats.getCurHealth() <= 0;}

    public void travelTo(String place) {
        loc = place;
    }

    public Stats getStats() {return stats;}

    abstract public String getStatsText();

    public void passTick() {
        getStatModifiersOwned().decrementStatDurations();
        getStatModifiersOwned().clearFinishedStats();
    }
}

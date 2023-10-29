package com.example.generaltemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StatModifiersOwned {
    private ArrayList<StatModifier> statModifiers = new ArrayList<>();
    private ArrayList<Integer> tempModifiers = new ArrayList<>();

    public void addStatModif(StatModifier statModifier, boolean temporary) {
        statModifiers.add(statModifier);
        if (temporary) {
            tempModifiers.add(statModifiers.size()-1);
        }
    }

    public Stats getTotalStatModif(Stats stat) {
        Stats modifiedStat = new Stats(stat.getMaxHealth(), stat.getStrength(), stat.getDefense(), stat.getAwesomeness(), stat.getCurHealth());
        for (StatModifier statModifier: statModifiers) {
            statModifier.modify(modifiedStat);
        }
        return modifiedStat;
    }

    public void clearTempStats() {
        if (!tempModifiers.isEmpty()) {
            Collections.sort(tempModifiers);
            Collections.reverse(tempModifiers);
            for (Integer tempModifierInd: tempModifiers) {
                statModifiers.remove((int) tempModifierInd);
            }
            tempModifiers.clear();
        }
    }
}

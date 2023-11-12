package com.example.generaltemplate;

import java.io.Serializable;
import java.util.ArrayList;

public class StatModifiersOwned implements Serializable {
    private final ArrayList<StatModifier> statModifiers = new ArrayList<>();

    public void addStatModif(StatModifier newStatModifier) {
        if (newStatModifier.getDuration() > 0) {
            for (StatModifier statModifier: statModifiers) {
                if (newStatModifier.getReason().equals(statModifier.getReason())) {
                    statModifier.addDuration(newStatModifier.getDuration());
                    return;
                }
            }
        }
        statModifiers.add(newStatModifier);
    }

    public Stats getTotalStatModif(Stats stat) {
        Stats modifiedStat = new Stats(stat.getMaxHealth(), stat.getStrength(), stat.getDefense(), stat.getAwesomeness(), stat.getCurHealth());
        for (StatModifier statModifier: statModifiers) {
            statModifier.modify(modifiedStat);
        }
        return modifiedStat;
    }

    public void clearFinishedStats() {
        for (int i = statModifiers.size()-1; i >= 0; i--) {
            if (statModifiers.get(i).getDuration() <= 0) {
                statModifiers.remove(i);
            }
        }
    }

    public void decrementStatDurations() {
        for (StatModifier statModifier : statModifiers) {
            statModifier.decrementDuration();
        }
    }

    public String getAllStatModifierText() {
        if (!statModifiers.isEmpty()) {
            StringBuilder result = new StringBuilder();
            result.append("Modifiers:");
            for (StatModifier statmodifier: statModifiers) {
                result.append("\n").append(statmodifier.getText());
            }
            return result.toString();
        }
        return "";
    }
}

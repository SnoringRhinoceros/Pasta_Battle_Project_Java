package com.example.generaltemplate;

import java.io.Serializable;

public class PC extends LivingBeing implements Serializable {
    private final PastaType pastaType;

    public PC(String name, PastaType pastaType) {
        super(name, "mainMap", 0, 0, 0, 0);
        this.pastaType = pastaType;
        if (pastaType.equals(PastaType.SPAGHETTI)) {
            getStats().setMaxHealth(40);
            getStats().setCurHealth(40);
            getStats().setStrength(5);
            getStats().setDefense(5);
            getStats().setAwesomeness(2);
            getActions().add(PossibleActions.BASIC_SWORD.getAction());
        } else if (pastaType.equals(PastaType.RAVIOLI)) {
            getStats().setMaxHealth(100);
            getStats().setCurHealth(100);
            getStats().setStrength(1);
            getStats().setDefense(15);
            getStats().setAwesomeness(1);
            getActions().add(PossibleActions.BASIC_HAMMER.getAction());
        } else if (pastaType.equals(PastaType.ROTINI)) {
            getStats().setMaxHealth(20);
            getStats().setCurHealth(20);
            getStats().setStrength(0);
            getStats().setDefense(0);
            getStats().setAwesomeness(10);
            getActions().add(PossibleActions.BASIC_SAUCE.getAction());
        }
        getActions().add(PossibleActions.FISTS.getAction());
    }

    @Override
    public String getStatsText() {
        return "Your stats:" + "\n"
                + "Health, " + getStats().getCurHealth() + "/" + getStats().getMaxHealth() + "\n"
                + "Strength, " + getStats().getStrength() + "\n"
                + "Defense, " + getStats().getDefense() + "\n"
                + "Awesomeness, " + getStats().getAwesomeness() + "\n";
    }

    public PastaType getPastaType() {
        return pastaType;
    }
}

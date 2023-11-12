package com.example.generaltemplate;

import java.io.Serializable;

public class PC extends LivingBeing implements Serializable {
    private final PastaType pastaType;

    public PC(String name, PastaType pastaType) {
        super(name, "mainMap", 0, 0, 0, 0);
        this.pastaType = pastaType;
        if (pastaType.equals(PastaType.SPAGHETTI)) {
            getStats().setMaxHealth(50);
            getStats().setCurHealth(50);
            getStats().setStrength(5);
            getStats().setDefense(5);
            getStats().setAwesomeness(2);
            getActions().add(PossibleActions.BASIC_SWORD.getAction());
            getEquippedArmor().add(new Item(PossibleActions.BASIC_ARMOR.getAction(), 1));
        } else if (pastaType.equals(PastaType.RAVIOLI)) {
            getStats().setMaxHealth(100);
            getStats().setCurHealth(100);
            getStats().setStrength(1);
            getStats().setDefense(10);
            getStats().setAwesomeness(1);
            getActions().add(PossibleActions.BASIC_HAMMER.getAction());
            getEquippedArmor().add(new Item(PossibleActions.BASIC_ARMOR.getAction(), 1));
        } else if (pastaType.equals(PastaType.ROTINI)) {
            getStats().setMaxHealth(20);
            getStats().setCurHealth(20);
            getStats().setStrength(0);
            getStats().setDefense(0);
            getStats().setAwesomeness(10);
            getActions().add(PossibleActions.BASIC_SAUCE.getAction());
            getEquippedArmor().add(new Item(PossibleActions.BASIC_ARMOR.getAction(), 1));
        }
        getActions().add(PossibleActions.FISTS.getAction());
    }

    @Override
    public String getStatsText() {
        Stats stats = getStatModifiersOwned().getTotalStatModif(getStats());
        return "Your stats:" + "\n"
                + "Health, " + stats.getCurHealth() + "/" + stats.getMaxHealth() + "\n"
                + "Strength, " + stats.getStrength()
                + " (" + getStats().getStrength() + ")" + "\n"
                + "Defense, " + stats.getDefense()
                + " (" + getStats().getDefense() + ")" + "\n"
                + "Awesomeness, " + stats.getAwesomeness()
                + " (" + getStats().getAwesomeness() + ")" + "\n";
    }

    public PastaType getPastaType() {
        return pastaType;
    }
}

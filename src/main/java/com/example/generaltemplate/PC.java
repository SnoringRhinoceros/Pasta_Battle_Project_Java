package com.example.generaltemplate;

public class PC extends LivingBeing {
    private final PastaType pastaType;

    public PC(String name, PastaType pastaType) {
        // default sets the base stats as that of spaghetti
        super(name, "mainMap", 0, 0, 0, 0);
        this.pastaType = pastaType;
        if (pastaType.equals(PastaType.SPAGHETTI)) {
            getStats().setMaxHealth(40);
            getStats().setCurHealth(40);
            getStats().setStrength(5);
            getStats().setDefense(5);
            getStats().setAwesomeness(5);
            getActions().add(new Action(PossibleActions.BASIC_SWORD));
        } else if (pastaType.equals(PastaType.RAVIOLI)) {
            getStats().setMaxHealth(100);
            getStats().setCurHealth(100);
            getStats().setStrength(1);
            getStats().setDefense(15);
            getStats().setAwesomeness(0);
            getActions().add(new Action(PossibleActions.BASIC_HAMMER));
        } else if (pastaType.equals(PastaType.ROTINI)) {
            getStats().setMaxHealth(20);
            getStats().setCurHealth(20);
            getStats().setStrength(0);
            getStats().setDefense(2180937);
            getStats().setAwesomeness(69);
            getActions().add(new Action(PossibleActions.BASIC_SAUCE));
        }
        getActions().add(new Action(PossibleActions.FISTS));
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

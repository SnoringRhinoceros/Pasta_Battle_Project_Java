package com.example.generaltemplate;

public class PC extends LivingBeing {
    private final PastaType pastaType;

    public PC(String name, PastaType pastaType) {
        // default sets the base stats as that of spaghetti
        super(name, "mainMap", 0, 0, 0, 0);
        this.pastaType = pastaType;
        if (pastaType.equals(PastaType.SPAGHETTI)) {
            setMaxHealth(40);
            setCurHealth(40);
            setStrength(5);
            setDefense(5);
            setAwesomeness(5);
            getActions().add(new Action(PossibleActions.BASIC_SWORD));
        } else if (pastaType.equals(PastaType.RAVIOLI)) {
            setMaxHealth(100);
            setCurHealth(100);
            setStrength(1);
            setDefense(15);
            setAwesomeness(0);
            getActions().add(new Action(PossibleActions.BASIC_SHIELD));
        } else if (pastaType.equals(PastaType.ROTINI)) {
            setMaxHealth(20);
            setCurHealth(20);
            setStrength(0);
            setDefense(0);
            setAwesomeness(69);
            getActions().add(new Action(PossibleActions.BASIC_SAUCE));
        }
        getActions().add(new Action(PossibleActions.FISTS));
    }

    @Override
    public String getStats() {
        return "Your stats:" + "\n"
                + "Health, " + getCurHealth() + "/" + getMaxHealth() + "\n"
                + "Strength, " + getStrength() + "\n"
                + "Defense, " + getDefense() + "\n"
                + "Awesomeness, " + getAwesomeness() + "\n";
    }

    public PastaType getPastaType() {
        return pastaType;
    }
}

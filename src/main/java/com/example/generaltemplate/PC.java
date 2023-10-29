package com.example.generaltemplate;

public class PC extends LivingBeing {
    private final PastaType pastaType;

    public PC(String name, PastaType pastaType) {
        // default sets the base stats as that of spaghetti
        super(name, "mainMap", 40, 10, 10, 0);
        this.pastaType = pastaType;
        if (pastaType.equals(PastaType.RAVIOLI)) {
            setMaxHealth(100);
            setStrength(1);
            setDefense(25);
            setAwesomeness(0);
        } else if (pastaType.equals(PastaType.ROTINI)) {
            setMaxHealth(20);
            setStrength(0);
            setDefense(0);
            setAwesomeness(69);
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
}

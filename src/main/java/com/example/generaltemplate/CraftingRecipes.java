package com.example.generaltemplate;

public enum CraftingRecipes {
    STRAIGHT_SWORD (PossibleActions.BASIC_SWORD, 2, PossibleActions.STRAIGHT_SWORD),
    MEAT_HAMMER (PossibleActions.BASIC_HAMMER, 2, PossibleActions.MEAT_HAMMER),
    MARINARA_SAUCE (PossibleActions.BASIC_SAUCE, 2, PossibleActions.MARINARA_SAUCE);



    private final PossibleActions ingredient;
    private final int howMany;
    private final PossibleActions result;

    CraftingRecipes(PossibleActions ingredient, int howMany, PossibleActions result) {
        this.ingredient = ingredient;
        this.howMany = howMany;
        this.result = result;
    }

    public PossibleActions getIngredient() {
        return ingredient;
    }

    public int getHowMany() {
        return howMany;
    }

    public PossibleActions getResult() {
        return result;
    }

    public CraftingRecipes[] getAll() {
        return values();
    }
}

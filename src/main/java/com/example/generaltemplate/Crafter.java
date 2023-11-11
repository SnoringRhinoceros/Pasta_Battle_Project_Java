package com.example.generaltemplate;

import java.io.Serializable;

public class Crafter implements Serializable {

    public boolean getItemCraftable(Item item) {
        for (CraftingRecipes recipe: CraftingRecipes.values()) {
            if (recipe.getIngredient().getAction().name().equals(item.getAction().name()) && recipe.getHowMany() == item.getAmount()) {
                return true;
            }
        }
        return false;
    }

    public String getNextItemCraftableDescription(Item item) {
        for (CraftingRecipes recipe: CraftingRecipes.values()) {
            if (recipe.getIngredient().getAction().equals(item.getAction())) {
                return "Next upgrade:\n   "
                        + recipe.getResult().getAction().name()
                        + "\n" + "Upgrade Description:\n"
                        + recipe.getResult().getAction().description()
                        + "\nAmount needed:\n  " + recipe.getHowMany()
                        + "\nCraftable:\n  " + getItemCraftable(item);
            }
        }
        return "";
    }
    public Item craft(Item item, LivingBeing personToSubtractItemFrom) {
        for (CraftingRecipes recipe : CraftingRecipes.values()) {
            if (recipe.getIngredient().getAction().equals(item.getAction())) {
                personToSubtractItemFrom.subtractItem(item, recipe.getHowMany());
                return new Item(recipe.getResult().getAction(), 1);
            }
        }
        return null;
    }
}

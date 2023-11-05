package com.example.generaltemplate;

public class Crafter {

    public boolean getItemCraftable(Item item) {
        for (CraftingRecipes recipe: CraftingRecipes.values()) {
            if (recipe.getIngredient().getAction().getName().equals(item.getAction().getName()) && recipe.getHowMany() == item.getAmount()) {
                return true;
            }
        }
        return false;
    }

    public String getNextItemCraftableDescription(Item item) {
        for (CraftingRecipes recipe: CraftingRecipes.values()) {
            if (recipe.getIngredient().getAction().equals(item.getAction())) {
                return "Next upgrade:\n   "
                        + recipe.getResult().getAction().getName()
                        + "\n" + "Upgrade Description:\n"
                        + recipe.getResult().getAction().getDescription()
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

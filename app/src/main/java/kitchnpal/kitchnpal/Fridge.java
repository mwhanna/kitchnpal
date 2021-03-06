package kitchnpal.kitchnpal;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import kitchnpal.sql.FridgeDatabaseHelper;


/**
 * Created by Jerry on 2017-02-25.
 */

public class Fridge {
    private List<Ingredient> ingredients = new ArrayList<>();
    private static Fridge fridge;
    private FridgeDatabaseHelper helper;

    private Fridge() {
        // make constructor private for singleton
    }

    public static Fridge getInstance() {
        if (fridge == null) {
            fridge = new Fridge();
            return fridge;
        }
        return fridge;
    }

    public void clearFridge() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient i) {
        if (i != null) {
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getIngredientName().equals(i.getIngredientName())) {
                    return;
                }
            }
            ingredients.add(i);
        }
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public boolean isIngredientInFridge(String name, Context context) {
        helper = new FridgeDatabaseHelper(context);
        return helper.isIngredientInFridge(name);
    }
}
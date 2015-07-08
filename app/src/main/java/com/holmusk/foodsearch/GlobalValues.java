/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch;

import android.app.Application;

import com.holmusk.foodsearch.model.FoodItem;


public class GlobalValues extends Application {
    private FoodItem selectedFoodItem;

    public FoodItem getSelectedFoodItem() {
        return selectedFoodItem;
    }

    public void setSelectedFoodItem(FoodItem selectedFoodItem) {
        this.selectedFoodItem = selectedFoodItem;
    }

}
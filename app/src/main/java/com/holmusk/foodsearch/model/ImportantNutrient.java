/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.model;

public class ImportantNutrient {
    private Nutrient sodium;
    private Nutrient polyunsaturated;
    private Nutrient protein;
    private Nutrient trans;
    private Nutrient sugar;
    private Nutrient monounsaturated;
    private Nutrient potassium;
    private Nutrient saturated;
    private Nutrient total_carbs;
    private Nutrient dietary_fibre;
    private Nutrient total_fats;
    private Nutrient cholesterol;
    private Nutrient calories;

    public Nutrient getSodium() {
        return sodium;
    }

    public void setSodium(Nutrient sodium) {
        this.sodium = sodium;
    }

    public Nutrient getPolyunsaturated() {
        return polyunsaturated;
    }

    public void setPolyunsaturated(Nutrient polyunsaturated) {
        this.polyunsaturated = polyunsaturated;
    }

    public Nutrient getProtein() {
        return protein;
    }

    public void setProtein(Nutrient protein) {
        this.protein = protein;
    }

    public Nutrient getTrans() {
        return trans;
    }

    public void setTrans(Nutrient trans) {
        this.trans = trans;
    }

    public Nutrient getSugar() {
        return sugar;
    }

    public void setSugar(Nutrient sugar) {
        this.sugar = sugar;
    }

    public Nutrient getMonounsaturated() {
        return monounsaturated;
    }

    public void setMonounsaturated(Nutrient monounsaturated) {
        this.monounsaturated = monounsaturated;
    }

    public Nutrient getPotassium() {
        return potassium;
    }

    public void setPotassium(Nutrient potassium) {
        this.potassium = potassium;
    }

    public Nutrient getSaturated() {
        return saturated;
    }

    public void setSaturated(Nutrient saturated) {
        this.saturated = saturated;
    }

    public Nutrient getTotal_carbs() {
        return total_carbs;
    }

    public void setTotal_carbs(Nutrient total_carbs) {
        this.total_carbs = total_carbs;
    }

    public Nutrient getDietary_fibre() {
        return dietary_fibre;
    }

    public void setDietary_fibre(Nutrient dietary_fibre) {
        this.dietary_fibre = dietary_fibre;
    }

    public Nutrient getTotal_fats() {
        return total_fats;
    }

    public void setTotal_fats(Nutrient total_fats) {
        this.total_fats = total_fats;
    }

    public Nutrient getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Nutrient cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Nutrient getCalories() {
        return calories;
    }

    public void setCalories(Nutrient calories) {
        this.calories = calories;
    }

    public int getDeclaredFieldsCount() {
        return getClass().getDeclaredFields().length;
    }
}

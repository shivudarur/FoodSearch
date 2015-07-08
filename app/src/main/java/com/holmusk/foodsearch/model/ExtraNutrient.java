/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.model;

public class ExtraNutrient {
    private Nutrient vitamin_a;
    private Nutrient retinol;
    private Nutrient calcium;
    private Nutrient vitamin_c;
    private Nutrient iron;
    private Nutrient b_carotene;

    public Nutrient getVitamin_a() {
        return vitamin_a;
    }

    public void setVitamin_a(Nutrient vitamin_a) {
        this.vitamin_a = vitamin_a;
    }

    public Nutrient getRetinol() {
        return retinol;
    }

    public void setRetinol(Nutrient retinol) {
        this.retinol = retinol;
    }

    public Nutrient getCalcium() {
        return calcium;
    }

    public void setCalcium(Nutrient calcium) {
        this.calcium = calcium;
    }

    public Nutrient getVitamin_c() {
        return vitamin_c;
    }

    public void setVitamin_c(Nutrient vitamin_c) {
        this.vitamin_c = vitamin_c;
    }

    public Nutrient getIron() {
        return iron;
    }

    public void setIron(Nutrient iron) {
        this.iron = iron;
    }

    public Nutrient getB_carotene() {
        return b_carotene;
    }

    public void setB_carotene(Nutrient b_carotene) {
        this.b_carotene = b_carotene;
    }

    public int getDeclaredFieldsCount() {
        return getClass().getDeclaredFields().length;
    }

}

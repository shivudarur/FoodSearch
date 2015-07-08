/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.model;


public class Portion {
    private String name;
    private Nutrients nutrients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

}

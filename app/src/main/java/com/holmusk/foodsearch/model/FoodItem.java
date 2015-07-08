/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.model;

import java.util.List;

public class FoodItem {
    private String _id;
    private String name;
    private List<Portion> portions;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Portion> getPortions() {
        return portions;
    }

    public void setPortions(List<Portion> portions) {
        this.portions = portions;
    }
}

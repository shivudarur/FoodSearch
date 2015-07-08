/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.model;

import java.util.List;

public class Nutrients {
    private List<Object> unhandled;
    private ImportantNutrient important;
    private ExtraNutrient extra;

    public List<Object> getUnhandled() {
        return unhandled;
    }

    public void setUnhandled(List<Object> unhandled) {
        this.unhandled = unhandled;
    }

    public ImportantNutrient getImportant() {
        return important;
    }

    public void setImportant(ImportantNutrient important) {
        this.important = important;
    }

    public ExtraNutrient getExtra() {
        return extra;
    }

    public void setExtra(ExtraNutrient extra) {
        this.extra = extra;
    }

}

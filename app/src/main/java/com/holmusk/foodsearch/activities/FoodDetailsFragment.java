/*
 * @author Shivanand Darur
 * @version 1.0
 */

package com.holmusk.foodsearch.activities;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.holmusk.foodsearch.GlobalValues;
import com.holmusk.foodsearch.R;
import com.holmusk.foodsearch.activities.HomeActivity;
import com.holmusk.foodsearch.model.ExtraNutrient;
import com.holmusk.foodsearch.model.FoodItem;
import com.holmusk.foodsearch.model.ImportantNutrient;
import com.holmusk.foodsearch.model.Nutrient;

import java.util.HashMap;
import java.util.Map;


/**
 * A placeholder fragment containing a simple view.
 */
public class FoodDetailsFragment extends Fragment {
    private static final int NUMBER_OF_COLUMNS = 3;
    private GlobalValues globalValues;
    private FoodItem selectedFoodItem;
    TableLayout mDetailstable;
    TableLayout.LayoutParams tableLayoutParams;
    TableRow.LayoutParams tableRowParams;

    public FoodDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mDetailstable = (TableLayout) view.findViewById(R.id.activity_food_details_tl_portion_details);
        tableLayoutParams = new TableLayout.LayoutParams();
        tableRowParams = new TableRow.LayoutParams();
        tableRowParams.weight = 1;
        globalValues = (GlobalValues) getActivity().getApplication();
        selectedFoodItem = globalValues.getSelectedFoodItem();
        constructTable();
        return view;
    }

    /**
     * function to create the table to dispay nutrients.
     */
    private void constructTable() {
        int selectedNutrient = getActivity().getIntent().getIntExtra(HomeActivity.PORTION, 1);
        mDetailstable.removeAllViews();
        TableRow tableRow = new TableRow(getActivity());
        tableRow.setBackgroundColor(Color.BLUE);
        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
            TextView textView = new TextView(getActivity());
            textView.setBackgroundColor(Color.CYAN);
            textView.setTextColor(Color.YELLOW);
            textView.setGravity(Gravity.CENTER);

            if (j == 0) {
                textView.setText(getString(R.string.nutrient));
            } else if (j == 1) {
                textView.setText(getString(R.string.unit));
            } else if (j == 2) {
                textView.setText(getString(R.string.value));
            }
            tableRow.addView(textView, tableRowParams);
        }
        mDetailstable.addView(tableRow, tableLayoutParams);
        switch (selectedNutrient) {
            case 1:
                constructImportantNutrientDetails();
                break;
            case 2:
                constructextraNutrientDetails();
                break;
            default:
                break;
        }
    }

    /**
     * Only Add non null values
     *
     * @param nutrientsMap
     * @param name
     * @param nutrient
     */
    private void addNutrient(HashMap<String, Nutrient> nutrientsMap,
                             String name, Nutrient nutrient) {
        if (nutrient != null) {
            nutrientsMap.put(name, nutrient);
        }
    }

    /**
     * Construct UI for extraNutrientDetails
     */
    private void constructextraNutrientDetails() {
        ExtraNutrient selectedExtraNutrient = selectedFoodItem.getPortions()
                .get(0).getNutrients().getExtra();
        HashMap<String, Nutrient> nutrientsMap = new HashMap<String, Nutrient>();
        addNutrient(nutrientsMap, "B_carotene",
                selectedExtraNutrient.getB_carotene());
        addNutrient(nutrientsMap, "Calcium", selectedExtraNutrient.getCalcium());
        addNutrient(nutrientsMap, "Iron", selectedExtraNutrient.getIron());
        addNutrient(nutrientsMap, "Retinol", selectedExtraNutrient.getRetinol());
        addNutrient(nutrientsMap, "Vitamin_a",
                selectedExtraNutrient.getVitamin_a());
        addNutrient(nutrientsMap, "Vitamin_c",
                selectedExtraNutrient.getVitamin_c());
        for (Map.Entry<String, Nutrient> e : nutrientsMap.entrySet()) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setBackgroundColor(Color.BLUE);
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                TextView textView = new TextView(getActivity());
                textView.setBackgroundColor(Color.CYAN);
                textView.setGravity(Gravity.CENTER);
                if (j == 0) {
                    textView.setText(e.getKey());
                } else if (j == 1) {
                    textView.setText(e.getValue().getUnit());
                } else if (j == 2) {
                    textView.setText(String.valueOf(e.getValue().getValue()));
                }
                tableRow.addView(textView, tableRowParams);
            }
            mDetailstable.addView(tableRow, tableLayoutParams);
        }

    }

    /**
     * Construct UI for ImportantNutrientDetails
     */
    private void constructImportantNutrientDetails() {
        ImportantNutrient selectedImportantNutrient = selectedFoodItem
                .getPortions().get(0).getNutrients().getImportant();
        HashMap<String, Nutrient> nutrientsMap = new HashMap<String, Nutrient>();
        addNutrient(nutrientsMap, "Calories",
                selectedImportantNutrient.getCalories());
        addNutrient(nutrientsMap, "Cholesterol",
                selectedImportantNutrient.getCholesterol());
        addNutrient(nutrientsMap, "Dietary_fibre",
                selectedImportantNutrient.getDietary_fibre());
        addNutrient(nutrientsMap, "Monounsaturated",
                selectedImportantNutrient.getMonounsaturated());
        addNutrient(nutrientsMap, "Polyunsaturated",
                selectedImportantNutrient.getPolyunsaturated());
        addNutrient(nutrientsMap, "Potassium",
                selectedImportantNutrient.getPotassium());
        addNutrient(nutrientsMap, "Protein",
                selectedImportantNutrient.getProtein());
        addNutrient(nutrientsMap, "Saturated",
                selectedImportantNutrient.getSaturated());
        addNutrient(nutrientsMap, "Sodium",
                selectedImportantNutrient.getSodium());
        addNutrient(nutrientsMap, "Sugar", selectedImportantNutrient.getSugar());
        addNutrient(nutrientsMap, "Total_carbs",
                selectedImportantNutrient.getTotal_carbs());
        addNutrient(nutrientsMap, "Total_fats",
                selectedImportantNutrient.getTotal_fats());
        addNutrient(nutrientsMap, "Trans", selectedImportantNutrient.getTrans());
        for (Map.Entry<String, Nutrient> e : nutrientsMap.entrySet()) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setBackgroundColor(Color.BLUE);
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                TextView textView = new TextView(getActivity());
                textView.setBackgroundColor(Color.CYAN);
                textView.setGravity(Gravity.CENTER);
                if (j == 0) {
                    textView.setText(e.getKey());
                } else if (j == 1) {
                    textView.setText(e.getValue().getUnit());
                } else if (j == 2) {
                    textView.setText(String.valueOf(e.getValue().getValue()));
                }
                tableRow.addView(textView, tableRowParams);
            }
            mDetailstable.addView(tableRow, tableLayoutParams);
        }

    }
}

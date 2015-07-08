/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.adapters;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.holmusk.foodsearch.api.RestApiBridge;
import com.holmusk.foodsearch.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class SuggestionAdapter extends ArrayAdapter<String> {

    protected static final String TAG = "SuggestionAdapter";
    private static final int MAXIMUM_SUGGESTIONS = 10;
    private List<String> suggestions;
    Context context;
    List<FoodItem> newFoodItems;

    public SuggestionAdapter(Activity context, String nameFilter) {
        super(context, android.R.layout.simple_dropdown_item_1line);
        suggestions = new ArrayList<String>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return suggestions.size();
    }

    @Override
    public String getItem(int index) {
        return suggestions.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                RestApiBridge restApiBridge = new RestApiBridge();
                if (constraint != null) {
                    // A class that queries a web API, parses the data and
                    // returns Food Items
                    newFoodItems =
                            restApiBridge
                                    .fetchFoodItems(constraint.toString());
                    suggestions.clear();
                    int numberOfFoodItems = newFoodItems.size() < MAXIMUM_SUGGESTIONS ? newFoodItems.size() : MAXIMUM_SUGGESTIONS;
                    for (int i = 0; i < numberOfFoodItems; i++) {
                        suggestions.add(newFoodItems.get(i).getName());
                    }

                    // Now assign the values and count to the FilterResults
                    // object
                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint,
                                          FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return myFilter;
    }

    public FoodItem getFoodItem(int position) {
        return newFoodItems.get(position);
    }

}
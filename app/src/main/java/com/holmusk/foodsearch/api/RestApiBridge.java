/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.holmusk.foodsearch.model.FoodItem;
import com.holmusk.foodsearch.utils.StringConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class RestApiBridge {
    private static final String API_URL = "http://test.holmusk.com";
    RestAdapter restAdapter;

    public RestApiBridge() {
        restAdapter = new RestAdapter.Builder().setEndpoint(API_URL)
                .setLogLevel(LogLevel.FULL).setConverter(new StringConverter())
                .build();
    }

    public List<FoodItem> fetchFoodItems(String sName) {
        List<FoodItem> ListData = new ArrayList<FoodItem>();
        try {
            String temp = sName.replace(" ", "%20");
            IFoodsearchService methods = restAdapter
                    .create(IFoodsearchService.class);
            String total = methods.getFoodItems(temp);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<FoodItem>>() {
            }.getType();
            ListData = (List<FoodItem>) gson.fromJson(total.toString(),
                    listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData;

    }

}

/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.api;

import retrofit.http.GET;
import retrofit.http.Query;

public interface IFoodsearchService {
    @GET("/food/search")
    String getFoodItems(@Query("q") String key);
}

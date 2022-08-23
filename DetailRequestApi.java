package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.RecipeDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DetailRequestApi {
    @GET("recipes/{id}/information")
    Call<RecipeDetails> RECIPE_DETAILS_CALL(
           @Path("id") int id,
           @Query("apiKey")String apiKey
    );
}

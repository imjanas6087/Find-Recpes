package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.RecipeInstruction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallRecipeInstruction {
    @GET("recipes/{id}/analyzedInstructions")
    Call<List<RecipeInstruction>> Root_Call_Instruction (
            @Path("id") int i,
            @Query("apiKey") String apiKey
    );
}

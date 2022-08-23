package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("recipes/random")
    Call<Root>  ROOT_CALL(
            @Query("apiKey") String apiKey,
            @Query("number") String number,
            @Query("tags") List<String>tags
                          );

}

package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.RootSecond;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SecondRecyclerView {

    @GET("/recipes/{id}/similar")
    Call<List<RootSecond>> ROOT_SECOND_CALL(
            @Path("id") int id,
            @Query("number") String number,
            @Query("apiKey") String apiKey);
}

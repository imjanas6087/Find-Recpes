package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.RecipeDetails;
import com.example.findrecipes.Model.RootSecond;

import java.util.List;

public interface SimilarRecyclerView {
    void didDetailFetch(List<RootSecond> Root, String message);
    void fetchError(String message);
}

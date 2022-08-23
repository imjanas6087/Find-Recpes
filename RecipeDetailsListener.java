package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.RecipeDetails;

public interface RecipeDetailsListener {

    void didDetailFetch(RecipeDetails details, String message);
    void fetchError(String str);
}

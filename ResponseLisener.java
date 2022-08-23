package com.example.findrecipes.Retrofit;

import com.example.findrecipes.Model.Root;

public interface ResponseLisener {
    public void fetch(Root root,String message);
    public void fetchError(String message);
}

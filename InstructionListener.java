package com.example.findrecipes.Retrofit;

import android.widget.Button;

import com.example.findrecipes.Model.RecipeInstruction;

import java.util.List;

public interface InstructionListener {

    void didFetch(List<RecipeInstruction> instruction, String s);
    void errorFetch(String s);

}

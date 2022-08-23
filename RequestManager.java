package com.example.findrecipes.Retrofit;

import android.content.Context;

import com.example.findrecipes.Model.RecipeDetails;
import com.example.findrecipes.Model.RecipeInstruction;
import com.example.findrecipes.Model.Root;
import com.example.findrecipes.Model.RootSecond;
import com.example.findrecipes.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getResponse(ResponseLisener responseLisener, List<String> tags){
        ApiRequest request = retrofit.create(ApiRequest.class);
        Call<Root> call = request.ROOT_CALL(context.getString(R.string.api_key), "10",tags);
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if(!response.isSuccessful()){
                    responseLisener.fetchError(response.message());
                    return;
                }
                responseLisener.fetch(response.body(),response.message());

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                responseLisener.fetchError(t.getMessage());

            }
        });
    }

   public void getDetailsListener(RecipeDetailsListener listener, int id){
        DetailRequestApi detailRequestApi = retrofit.create(DetailRequestApi.class);
        Call<RecipeDetails> recipeDetailsCall = detailRequestApi.RECIPE_DETAILS_CALL(id, context.getString(R.string.api_key));
        recipeDetailsCall.enqueue(new Callback<RecipeDetails>() {
            @Override
            public void onResponse(Call<RecipeDetails> call, Response<RecipeDetails> response) {
                if(!response.isSuccessful()){
                    listener.fetchError(response.message());
                    return;
                }
               listener.didDetailFetch(response.body(),response.message());

            }
            @Override
            public void onFailure(Call<RecipeDetails> call, Throwable t) {
                listener.fetchError(t.getMessage());
            }
        });
   }

   public void getRecyclerSecond(SimilarRecyclerView similarRecyclerView, int id){
        SecondRecyclerView secondRecyclerView = retrofit.create(SecondRecyclerView.class);
        Call<List<RootSecond>> call = secondRecyclerView.ROOT_SECOND_CALL(id,"5" ,context.getString(R.string.api_key));
        call.enqueue(new Callback<List<RootSecond>>() {
            @Override
            public void onResponse(Call<List<RootSecond>> call, Response<List<RootSecond>> response) {
                if(!response.isSuccessful()){
                    similarRecyclerView.fetchError(response.message());
                    return;
                }
                similarRecyclerView.didDetailFetch(response.body(),response.message());

            }

            @Override
            public void onFailure(Call<List<RootSecond>> call, Throwable t) {
                similarRecyclerView.fetchError(t.getMessage());

            }
        });
   }

   public void getInstruction(InstructionListener instructionListener, int id){
        CallRecipeInstruction instruction = retrofit.create(CallRecipeInstruction.class);
        Call<List<RecipeInstruction>> call = instruction.Root_Call_Instruction(id,context.getString(R.string.api_key));
        call.enqueue(new Callback<List<RecipeInstruction>>() {
            @Override
            public void onResponse(Call<List<RecipeInstruction>> call, Response<List<RecipeInstruction>> response) {

                if(!response.isSuccessful()){
                    instructionListener.errorFetch(response.message());
                    return;
                }
                instructionListener.didFetch(response.body(),response.message());

            }

            @Override
            public void onFailure(Call<List<RecipeInstruction>> call, Throwable t) {
                instructionListener.errorFetch(t.getMessage());
            }
        });

   }
}

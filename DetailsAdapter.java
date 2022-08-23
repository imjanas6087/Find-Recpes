package com.example.findrecipes.Adaptor;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.ExtendedIngredient;
import com.example.findrecipes.Model.RecipeDetails;
import com.example.findrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.Myclass>{
    Context context;
    List<ExtendedIngredient>details;

    public DetailsAdapter(Context context, List<ExtendedIngredient> details) {
        this.context = context;
        this.details = details;
    }

    @NonNull
    @Override
    public DetailsAdapter.Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.details_recipe_adaptor,parent, false);
        return new Myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.Myclass holder, int position) {
        holder.textView1.setText(details.get(position).name);
        holder.textView1.setSelected(true);
        holder.textView2.setText(details.get(position).original);
        holder.textView2.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/"+ details.get(position).image).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class Myclass extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView imageView;
        public Myclass(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView_ad_Ingredient);
            textView2=itemView.findViewById(R.id.textView_ad_chicken);
            imageView=itemView.findViewById(R.id.ImageView_Ingredient);

        }
    }
}

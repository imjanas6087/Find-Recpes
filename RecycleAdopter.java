package com.example.findrecipes.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.Recipe;
import com.example.findrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class RecycleAdopter extends RecyclerView.Adapter<RecycleAdopter.Myclass> {

    Context context;
    List<Recipe>recipes;
    RecipeListener listener;

    public RecycleAdopter(Context context, List<Recipe> recipes, RecipeListener listener) {
        this.context = context;
        this.recipes = recipes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.random_recipes, parent, false);
        return new Myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, int position) {
        holder.textView_title.setText(recipes.get(position).title);
        holder.textView_title.setSelected(true);
        holder.textView_likes.setText(recipes.get(position).aggregateLikes+" likes");
        holder.textView_time.setText(recipes.get(position).readyInMinutes+" Minutes");
        Picasso.get().load(recipes.get(position).image).into(holder.ImageView_food);
        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.RecipeListenerMethod(String.valueOf(recipes.get(holder.getAdapterPosition()).id));
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class Myclass extends RecyclerView.ViewHolder {
        CardView random_list_container;
        TextView textView_title, textView_servings, textView_likes, textView_time;
        ImageView ImageView_food;

        public Myclass(@NonNull View itemView) {
            super(itemView);
            random_list_container = itemView.findViewById(R.id.random_list_container);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_servings = itemView.findViewById(R.id.textView_servings);
            textView_likes = itemView.findViewById(R.id.textView_likes);
            textView_time = itemView.findViewById(R.id.textView_time);
            ImageView_food = itemView.findViewById(R.id.ImageView_food);
        }



    }


}

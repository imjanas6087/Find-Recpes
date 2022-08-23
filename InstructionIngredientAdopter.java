package com.example.findrecipes.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.Ingredient;
import com.example.findrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionIngredientAdopter extends RecyclerView.Adapter<InstructionIngredientAdopter.MyHolder> {
    Context context;
    List<Ingredient>ingredients;

    public InstructionIngredientAdopter(Context context, List<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_instruction_steps_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/"+ingredients.get(position).image).into(holder.imageView_instruction_steps_items);
        holder.textView_instruction_step_item.setText(ingredients.get(position).name);
        holder.textView_instruction_step_item.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView_instruction_steps_items;
        TextView textView_instruction_step_item;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView_instruction_steps_items = itemView.findViewById(R.id.imageView_instruction_steps_items);
            textView_instruction_step_item = itemView.findViewById(R.id.textView_instruction_step_item);
        }
    }
}

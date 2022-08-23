package com.example.findrecipes.Adaptor;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.RecipeInstruction;
import com.example.findrecipes.R;


import java.util.List;

public class InsideAdaptor extends RecyclerView.Adapter<InsideAdaptor.Myholder> {

    Context context;
    List<RecipeInstruction> recipeInstructions;

    public InsideAdaptor(Context context, List<RecipeInstruction> recipeInstructions) {
        this.context = context;
        this.recipeInstructions = recipeInstructions;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_insruction, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        holder.instructionView.setText(recipeInstructions.get(position).name);
        holder.recycler_steps_instruction.setHasFixedSize(true);

        holder.recycler_steps_instruction.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
        InstructionStepsAdopter instructionStepsAdopter = new InstructionStepsAdopter(context, recipeInstructions.get(position).steps);
        holder.recycler_steps_instruction.setAdapter(instructionStepsAdopter);

    }

    @Override
    public int getItemCount() {
        return recipeInstructions.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView instructionView;
        RecyclerView recycler_steps_instruction;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            instructionView=itemView.findViewById(com.example.findrecipes.R.id.instructionView);
            recycler_steps_instruction=itemView.findViewById(com.example.findrecipes.R.id.recycler_steps_instruction);
        }
    }
}

package com.example.findrecipes.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.Step;
import com.example.findrecipes.R;

import java.util.List;

public class InstructionStepsAdopter extends RecyclerView.Adapter<InstructionStepsAdopter.Myholder> {

    Context context;
    List<Step> steps;

    public InstructionStepsAdopter(Context context, List<Step> steps) {
        this.context = context;
        this.steps = steps;
    }

    @NonNull
    @Override
    public InstructionStepsAdopter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_instruction_steps, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionStepsAdopter.Myholder holder, int position) {
        holder.textView_instruction_steps_number.setText(String.valueOf(steps.get(position).number));
        holder.textView_instruction_steps_title.setText(steps.get(position).step);

        holder.recyclerView_instruction_Ingredients.setHasFixedSize(true);
        holder.recyclerView_instruction_Ingredients.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
       InstructionIngredientAdopter instructionIngredientAdopter = new InstructionIngredientAdopter(context, steps.get(position).ingredients);
       holder.recyclerView_instruction_Ingredients.setAdapter(instructionIngredientAdopter);


        holder.recyclerView_instruction_equipment.setHasFixedSize(true);
        holder.recyclerView_instruction_equipment.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
       InstructionEquipmentAdopter instructionEquipmentAdopter = new InstructionEquipmentAdopter(context, steps.get(position).equipment);
        holder.recyclerView_instruction_equipment.setAdapter(instructionEquipmentAdopter);

    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textView_instruction_steps_number, textView_instruction_steps_title;
        RecyclerView recyclerView_instruction_equipment, recyclerView_instruction_Ingredients;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView_instruction_steps_number = itemView.findViewById(R.id.textView_instruction_steps_number);
            textView_instruction_steps_title = itemView.findViewById(R.id.textView_instruction_steps_title);
            recyclerView_instruction_equipment = itemView.findViewById(R.id.recyclerView_instruction_equipment);
            recyclerView_instruction_Ingredients = itemView.findViewById(R.id.recyclerView_instruction_Ingredients);
        }

    }
}

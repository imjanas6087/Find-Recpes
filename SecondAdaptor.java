package com.example.findrecipes.Adaptor;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findrecipes.Model.RootSecond;
import com.example.findrecipes.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class SecondAdaptor extends RecyclerView.Adapter<SecondAdaptor.Myholder> {
    Context context;
    List<RootSecond>rootSeconds;
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.findrecipes.R.layout.similar_recipes,parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView_similar_title.setText(rootSeconds.get(position).title);
        holder.textView_similar_servings.setText(rootSeconds.get(position).servings);
        Picasso.get().load(rootSeconds.get(position).id);

    }

    @Override
    public int getItemCount() {
        return rootSeconds.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textView_similar_title, textView_similar_servings;
        ImageView imageView_second_cycle;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView_similar_title=itemView.findViewById(com.example.findrecipes.R.id.textView_similar_title);
            textView_similar_servings=itemView.findViewById(com.example.findrecipes.R.id.textView_similar_servings);
            imageView_second_cycle=itemView.findViewById(com.example.findrecipes.R.id.imageView_second_cycle);

        }
    }
}

package com.example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {
    private List<Plant> mPlantList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        View plantView;
        ImageView plantImage;
        TextView plantName;
        EditText plantFunction;
        public ViewHolder(@NonNull View view) {
            super(view);
            plantView = view;
            plantImage = (ImageView) view.findViewById(R.id.plant_image);
            plantName = (TextView) view.findViewById(R.id.plant_name);
            plantFunction = (EditText) view.findViewById(R.id.edit_text);
        }
    }

    public PlantAdapter(List<Plant> plantList) {
        mPlantList = plantList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.plantView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Plant plant = mPlantList.get(position);
                Toast.makeText(v.getContext(),"这是"+plant.getName()+"的名字",Toast.LENGTH_SHORT).show();
            }
        });
        holder.plantImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Plant plant = mPlantList.get(position);
                Toast.makeText(v.getContext(),"这是"+plant.getName()+"的图片",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = mPlantList.get(position);
        holder.plantImage.setImageResource(plant.getImageId());
        holder.plantName.setText(plant.getName());
    }

    @Override
    public int getItemCount() {
        return mPlantList.size();
    }


}

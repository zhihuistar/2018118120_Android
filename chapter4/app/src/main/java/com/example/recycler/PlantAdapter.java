package com.example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {
    private List<Plant> mPlantList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView plantImage;
        TextView plantName;
        public ViewHolder(@NonNull View view) {
            super(view);
            plantImage = (ImageView) view.findViewById(R.id.plant_image);
            plantName = (TextView) view.findViewById(R.id.plant_name);
        }
    }

    public PlantAdapter(List<Plant> plantList) {
        mPlantList = plantList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
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

package com.example.foodwise.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodwise.Domain.Food;
import com.example.foodwise.R;
import java.util.ArrayList;

public class NearAdapter extends RecyclerView.Adapter<NearAdapter.viewholder> {

    ArrayList<Food> items;

    Context context;

    public NearAdapter(ArrayList<Food> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public NearAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.food_card, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NearAdapter.viewholder holder, int position) {
        holder.nameTxt.setText(items.get(position).getName());
        holder.priceTxt.setText("Rp. "+items.get(position).getPrice());

        Glide.with(context)
                .load(items.get(position).getImagepath())
                .placeholder(R.drawable.card_food)
                .error(R.drawable.card_food)
                .transform(new CenterCrop(), new RoundedCorners(30) )
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView nameTxt, priceTxt;
        ImageView image;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            nameTxt=itemView.findViewById(R.id.food_name);
            priceTxt=itemView.findViewById(R.id.food_price);
            image=itemView.findViewById(R.id.food_image);
        }
    }
}

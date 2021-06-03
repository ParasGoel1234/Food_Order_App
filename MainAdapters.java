package com.codewithparas.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithparas.foodorderapp.DetailActivity;
import com.codewithparas.foodorderapp.Models.MainModels;
import com.codewithparas.foodorderapp.R;

import java.util.ArrayList;

public class MainAdapters extends RecyclerView.Adapter<MainAdapters.viewholder>{

    ArrayList<MainModels>list;
    Context context;

    public MainAdapters(ArrayList<MainModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            final MainModels model = list.get(position);
            holder.foodimage.setImageResource(model.getImage());
            holder.price.setText(model.getPrice());
            holder.description.setText(model.getDescription());
            holder.mainName.setText(model.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("image", model.getImage());
                    intent.putExtra("price", model.getPrice());
                    intent.putExtra("description", model.getDescription());
                    intent.putExtra("name", model.getName());
                    intent.putExtra("type", 1);
                    context.startActivity(intent);

                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView foodimage;
        TextView mainName, price, description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodimage = itemView.findViewById(R.id.imageView);
            mainName = itemView.findViewById(R.id.ordername);
            price = itemView.findViewById(R.id.orderPrice);
            description = itemView.findViewById(R.id.description);


        }
    }
}

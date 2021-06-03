package com.codewithparas.foodorderapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithparas.foodorderapp.DBhelper;
import com.codewithparas.foodorderapp.DetailActivity;
import com.codewithparas.foodorderapp.Models.OrderModels;
import com.codewithparas.foodorderapp.R;

import java.util.ArrayList;

public class OrderAdepter extends RecyclerView.Adapter<OrderAdepter.viewHolder> {

    ArrayList<OrderModels> list;
    Context context;

    public OrderAdepter(ArrayList<OrderModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrderModels models = list.get(position);
        holder.OrderImage.setImageResource(models.getOrderImage());
        holder.OrderNumber.setText(models.getOrdernumber());
        holder.Price.setText(models.getPrice());
        holder.soldItem.setText(models.getSolditemname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", Integer.parseInt(models.getOrdernumber()));
                intent.putExtra("type", 2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context).setTitle("Delete Item").setMessage("Are you sure to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBhelper helper = new DBhelper(context);
                                if(helper.deleteOrder(models.getOrdernumber()) > 0){
                                    Toast.makeText(context, "item is deleted...", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView OrderImage;
        TextView soldItem, Price, OrderNumber;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            OrderImage = itemView.findViewById(R.id.orderimage);
            soldItem = itemView.findViewById(R.id.orderitemname);
            Price = itemView.findViewById(R.id.OrderitemPrice);
            OrderNumber = itemView.findViewById(R.id.orderNumber);
        }
    }

}

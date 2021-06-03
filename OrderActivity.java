package com.codewithparas.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.codewithparas.foodorderapp.Adapters.OrderAdepter;
import com.codewithparas.foodorderapp.Models.OrderModels;
import com.codewithparas.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper helper = new DBhelper(this);
        ArrayList<OrderModels>list = helper.getOrders();

        OrderAdepter adepter = new OrderAdepter(list, this);
        binding.OrderRecyclerView.setAdapter(adepter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.OrderRecyclerView.setLayoutManager(layoutManager);
    }
}
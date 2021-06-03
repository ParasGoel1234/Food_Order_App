package com.codewithparas.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.codewithparas.foodorderapp.Adapters.MainAdapters;
import com.codewithparas.foodorderapp.Models.MainModels;
import com.codewithparas.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModels>list = new ArrayList<>();
        list.add(new MainModels(R.drawable.image1, "Extra chess burger starting at rupees", "45", "Burger"));
        list.add(new MainModels(R.drawable.pizza, "Extra chess pizza starting at rupees", "69", "Pizza"));
        list.add(new MainModels(R.drawable.dosa, "south indian food", "99", "Dosa"));
        list.add(new MainModels(R.drawable.shahi, "shahi Paneer with rooti", "120", "Shahi Paneer"));
        list.add(new MainModels(R.drawable.momos, "fried and steamed momos starting at rupees", "40", "Momos"));
        list.add(new MainModels(R.drawable.chowmein, "Veg Chowmein snakes items ", "80", "Chowmein"));
        list.add(new MainModels(R.drawable.largeburger, "combo Pack of 4 burger", "200", "Large Burger"));
        list.add(new MainModels(R.drawable.pizza, "All snakes items are available starting at rupees", "69", "Pizza"));
        list.add(new MainModels(R.drawable.dosa, "south indian food Idli and Dosa starting at rupees", "99", "Dosa"));

        MainAdapters adepter = new MainAdapters(list, this);
        binding.recyclerview.setAdapter(adepter);

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(LayoutManager);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class ));

        }
        return super.onOptionsItemSelected(item);
    }
}
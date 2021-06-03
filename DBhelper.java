package com.codewithparas.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.codewithparas.foodorderapp.Models.OrderModels;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    final static String DBName = "MyDatabase.db";
    final static int DBVersion = 5;
    public DBhelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders" + "(id integer primary key autoincrement," +
                "name text," + "phone text," + "price int," + "image int," + "foodname text,"
                        + "description text," + "quantity int)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists orders");
        onCreate(db);
    }
    public boolean insertOrder(String name, String phone, int price, int image, String description, String foodName, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("foodName", foodName);
        values.put("description", description);
        values.put("quantity", quantity);

        long id = database.insert("orders", null, values);
        if(id <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<OrderModels>getOrders(){
        ArrayList<OrderModels>orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id, foodname, image,  price  from orders", null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModels models = new OrderModels();
                models.setOrdernumber(cursor.getInt(0) + "");
                models.setSolditemname(cursor.getString(1));
                models.setOrderImage(cursor.getInt(2));
                models.setPrice(cursor.getInt(3) + "");
                orders.add(models);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from orders where id =" + id, null);

        if(cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public boolean UpdateOrders(String name, String phone, int price, int image,
                                String description, String foodName, int quantity, int id) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("foodName", foodName);
        values.put("description", description);
        values.put("quantity", quantity);

        long row = database.update("orders", values, "id=" + id, null);
        if(row <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id=" + id, null);
    }
}

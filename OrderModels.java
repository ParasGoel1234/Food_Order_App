package com.codewithparas.foodorderapp.Models;

public class OrderModels {
    int orderImage;
    String solditemname, price, ordernumber;

    public OrderModels(int orderImage, String solditemname, String price, String ordernumber) {
        this.orderImage = orderImage;
        this.solditemname = solditemname;
        this.price = price;
        this.ordernumber = ordernumber;
    }

    public OrderModels() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSolditemname() {
        return solditemname;
    }

    public void setSolditemname(String solditemname) {
        this.solditemname = solditemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }
}

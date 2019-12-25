package com.example.seconddatabasereveiw;

public class Product {
    private int productID;
    private String Name;
    private String Color;

    public String getName() {
        return Name;
    }

    public int getProductID() {
        return productID;
    }

    public String getColor() {
        return Color;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}

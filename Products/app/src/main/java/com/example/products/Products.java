package com.example.products;

import java.io.Serializable;

public class Products implements Serializable {

    public String name;
    public int qty,price;

    public Products(String name, int price){
        this.name=name;

        this.price=price;
    }



}


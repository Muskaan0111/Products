package Model;

import java.io.Serializable;

public class Product implements Serializable {

    public String name;
    public int price,qty;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}


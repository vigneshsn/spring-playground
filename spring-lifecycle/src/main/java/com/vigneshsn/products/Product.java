package com.vigneshsn.products;

import java.io.Serializable;

public class Product implements Serializable{
    public String id;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String name;
}

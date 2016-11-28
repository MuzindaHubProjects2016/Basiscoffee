package com.example.parabasis.basiscoffee.model;

/**
 * Created by Tapiwanashe on 20/10/2016.
 */

public class Coffee {
    String name;
    String price;
    String fact;

    public Coffee() {
    }

    public Coffee(String name, String price, String fact) {
        this.name = name;
        this.price = price;
        this.fact = fact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}

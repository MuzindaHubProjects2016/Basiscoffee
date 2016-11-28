package com.example.parabasis.basiscoffee.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Tapiwanashe on 25/10/2016.
 */

public class CartItem extends RealmObject {

    String coffeename, coffeeprice, coffefact;
    int quantity;
    @PrimaryKey
    long ordertime;

    public CartItem() {
    }

    public CartItem(String coffeename, String coffeeprice, String coffefact, int quantity, long ordertime) {
        this.coffeename = coffeename;
        this.coffeeprice = coffeeprice;
        this.coffefact = coffefact;
        this.quantity = quantity;
        this.ordertime = ordertime;

    }

    public String getCoffeename() {
        return coffeename;
    }

    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    public String getCoffeeprice() {
        return coffeeprice;
    }

    public void setCoffeeprice(String coffeeprice) {
        this.coffeeprice = coffeeprice;
    }

    public String getCoffefact() {
        return coffefact;
    }

    public void setCoffefact(String coffefact) {
        this.coffefact = coffefact;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(long ordertime) {
        this.ordertime = ordertime;
    }
}

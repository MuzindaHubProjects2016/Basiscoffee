package com.example.parabasis.basiscoffee.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by parabasis on 10/26/2016.
 */
public class CartView extends RealmObject {
    String cname, cprice, cfact;
    int quantity;
    @PrimaryKey
    long ordertime;

    public CartView() {
    }

    public CartView(String coffeename, String coffeeprice, String coffefact, int quantity, long ordertime) {

        this.cname=cname;
        this.cprice=cprice;
        this.cfact=cfact;
        this.quantity=quantity;
        this.ordertime=ordertime;


    }

    public String getCprice() {
        return cprice;
    }

    public void setCprice(String cprice) {
        this.cprice = cprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCfact() {
        return cfact;
    }

    public void setCfact(String cfact) {
        this.cfact = cfact;
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

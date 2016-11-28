package com.example.parabasis.basiscoffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parabasis.basiscoffee.model.CartItem;

import io.realm.Realm;

public class OrderSpecs extends AppCompatActivity {

    TextView coffeename, coffeedetails;
    EditText quantity;
    String name, price, fact;
   int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderspecs);
        Realm.init(this);

        coffeename = (TextView) findViewById(R.id.coffename);
        coffeedetails = (TextView) findViewById(R.id.coffeedetails);
        quantity = (EditText) findViewById(R.id.quantity);
         name = getIntent().getStringExtra("name");
        price = getIntent().getStringExtra("price");
        fact = getIntent().getStringExtra("fact");
        coffeename.setText(name);
        coffeedetails.setText("Price: "+price);
    }


    public void addToCart(View view) {
        if (quantity.getText().toString().length() > 0) {
            amount = Integer.parseInt(quantity.getText().toString());
            CartItem cartItem = new CartItem(name, price, fact, amount, System.currentTimeMillis());

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.copyToRealm(cartItem);
            realm.commitTransaction();
            onBackPressed();
            Toast.makeText(this, "item added to cart", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "please enter quantity", Toast.LENGTH_LONG).show();
        }
    }
}

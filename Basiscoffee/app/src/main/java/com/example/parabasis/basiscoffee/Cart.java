package com.example.parabasis.basiscoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parabasis.basiscoffee.adapters.CartItemsAdapter;
import com.example.parabasis.basiscoffee.model.CartItem;

import io.realm.Realm;
import io.realm.RealmResults;


public class Cart extends AppCompatActivity {
    ListView Cartlist;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
         checkout = (Button) findViewById(R.id.checkout);
        Cartlist = (ListView) findViewById(R.id.Cartlist);


        // Initialize Realm
        Realm.init(this);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        // Query Realm for all orders
        final RealmResults<CartItem> items = realm.where(CartItem.class).findAll();

        CartItemsAdapter cartItemsAdapter = new CartItemsAdapter(this, items);

        Cartlist.setAdapter(cartItemsAdapter);


        Toast.makeText(this, String.valueOf(items.size()), Toast.LENGTH_LONG).show();

    }

    public void checkout(View view) {
        startActivity((new Intent(this,Paying.class)));


        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        // obtain the results of a query
        final RealmResults<CartItem> results = realm.where(CartItem.class).findAll();

// All changes to data must happen in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                results.deleteAllFromRealm();
            }
        });

    }
}

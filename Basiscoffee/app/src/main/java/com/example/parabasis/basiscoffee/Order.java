package com.example.parabasis.basiscoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.parabasis.basiscoffee.model.Coffee;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {
    ListView listViewInventories;
    private ArrayAdapter inventoryItemsAdapter;
    DatabaseReference ref;
    FirebaseListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        listViewInventories = (ListView) findViewById(R.id.listViewInventories);
        ref = FirebaseDatabase.getInstance().getReference();

        mAdapter = new FirebaseListAdapter<Coffee>(this, Coffee.class, R.layout.coffee_item, ref.child("coffees")) {
            @Override
            protected void populateView(View v, Coffee model, int position) {
                ((TextView) v.findViewById(R.id.coffeeName)).setText(model.getName());
                ((TextView) v.findViewById(R.id.coffeePrice)).setText(model.getPrice());
                ((TextView) v.findViewById(R.id.coffeeFact)).setText(model.getFact());
            }
        };

        listViewInventories.setAdapter(mAdapter);

        listViewInventories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Coffee coffee = (Coffee)mAdapter.getItem(position);
                Intent i = new Intent(Order.this, OrderSpecs.class);
                i.putExtra("name", coffee.getName());
                i.putExtra("price", coffee.getPrice());
                i.putExtra("fact", coffee.getFact());
                startActivity(i);
            }
        });

    }


    public void goToCart(View view) {
        startActivity((new Intent(this,Cart.class)));

    }
}


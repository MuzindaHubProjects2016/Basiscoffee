package com.example.parabasis.basiscoffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parabasis.basiscoffee.model.Coffee;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Createmenu extends AppCompatActivity implements View.OnClickListener {

    //Creating Views
    private EditText etitem, etprice, etdidiyouknow;
    private Button bsave;
    String name, price, fact;
    DatabaseReference ref;

    //Array list for storing all the inventoryItems
    private ArrayList<String> inventoryItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createmenu);

        //we are getting the link to our firebase database
        ref = FirebaseDatabase.getInstance().getReference();

        //Initializing views
        etitem = (EditText) findViewById(R.id.etitem);
        etprice = (EditText) findViewById(R.id.etprice);
        etdidiyouknow = (EditText) findViewById(R.id.etdidyouknow);

        bsave = (Button) findViewById(R.id.bsave);
        bsave.setOnClickListener(this);
    }

    private void saveInventory() {
        //Getting texts from editTexts
        name = etitem.getText().toString().trim();
        price = etprice.getText().toString().trim();
        fact = etdidiyouknow.getText().toString().trim();

        Coffee coffee = new Coffee(name, price, fact);

        ref.child("coffees").push().setValue(coffee);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bsave:
                saveInventory();
                break;
        }
    }


}
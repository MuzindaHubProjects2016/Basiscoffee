package com.example.parabasis.basiscoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bCreateAccount,border,binventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        border = (Button) findViewById(R.id.border);
        binventory = (Button) findViewById(R.id.binventory);


        border.setOnClickListener(this);
        binventory.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.border:
                startActivity((new Intent(this,SplashOrder.class)));
                break;

            case R.id.binventory:
                startActivity((new Intent(this,Createmenu.class)));
                break;


        }
    }

}

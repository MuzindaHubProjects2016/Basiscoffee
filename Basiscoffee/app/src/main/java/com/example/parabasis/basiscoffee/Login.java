package com.example.parabasis.basiscoffee;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Login extends AppCompatActivity implements View.OnClickListener {
   private Button blogin;
  private   EditText etusername, etpassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);





         etusername = (EditText) findViewById(R.id.etUsername);
        etusername.setText(id);
        etpassword = (EditText) findViewById(R.id.etPassword);
        blogin = (Button) findViewById(R.id.bLogin);

        blogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public void goToRegister(View view) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void login(View view) {
        userLogin();
    }

    private void userLogin(){
        String username = etusername.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

    }
}

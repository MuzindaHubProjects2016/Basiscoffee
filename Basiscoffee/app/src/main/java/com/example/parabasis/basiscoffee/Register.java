package com.example.parabasis.basiscoffee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parabasis.basiscoffee.model.User;
import com.google.firebase.database.DatabaseReference;

//import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity  {

    String android_id;
    EditText name, password;
    DatabaseReference ref;
  //  FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
 //       name = (EditText) findViewById(R.id.nameText);
      //  password = (EditText) findViewById(R.id.passwordText);
      //  ref = FirebaseDatabase.getInstance().getReference();

       // firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

    }


    public void register(View view) {
        if (name.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
            User user = new User(name.getText().toString(), android_id, password.getText().toString());
           ref.child("users").child(android_id).child("account").setValue(user);
           // registerUser();
            Intent i = new Intent(this, Order.class);
           startActivity(i);
        } else {
            Toast.makeText(this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
        }
    }
    private void  registerUser(){
        String username = name.getText().toString().trim();
        String pass = password.getText().toString().trim();

        progressDialog.setMessage("registering user");
        progressDialog.show();

       // firebaseAuth.createUserWithEmailAndPassword(username,pass)

             //   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                  //  @Override
                 //   public void onComplete(@NonNull Task<AuthResult> task) {
                  //     if(task.isSuccessful()){
                   //        Toast.makeText(Register.this, "registered successfully", Toast.LENGTH_LONG).show();
                   //    }
                   //     else {
                       //    Toast.makeText(Register.this, "could not register try again", Toast.LENGTH_LONG).show();
                  //     }
                 //  }
              //  });
    }
}

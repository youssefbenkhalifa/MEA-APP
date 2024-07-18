package com.example.meaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

    }
    public void signInBtn(View view){
        EditText emailField = findViewById(R.id.email);
        String email = emailField.getText().toString();
        EditText passwordField = findViewById(R.id.password);
        String password = passwordField.getText().toString();
        Intent intent = new Intent(SignIn.this, homepage.class);
      //  if(email.equals("email@email.com") && password.equals("12345")){
            startActivity(intent);
    //    }

    };
    public void moveToSignUp(View view){
        Intent intent = new Intent(SignIn.this, signUp.class);
        startActivity(intent);
    }
}
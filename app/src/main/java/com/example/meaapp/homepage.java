package com.example.meaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class homepage extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);

    };
    public void moveToBot(View view){
        Intent intent = new Intent(homepage.this,chatpage.class );
        startActivity(intent);
    }
    public void moveToBook(View view){
        Intent intent = new Intent(homepage.this, SearchFlight.class);
        startActivity(intent);
    }
    public void moveToDetails(View view){
        startActivity(new Intent(homepage.this, Profile.class));
    }


}
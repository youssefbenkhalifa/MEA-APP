package com.example.meaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchFlight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_flight);
    }
    public void moveTOSearch(View view){
        Intent intent = new Intent(SearchFlight.this, BookFlight.class);

        startActivity(intent);
    }
    public void hideArrival(View v){
        ConstraintLayout arrivalF = (ConstraintLayout) findViewById(R.id.arrivalF);
        arrivalF.setVisibility(View.INVISIBLE);
    }
    public void showArrival(View v){
        ConstraintLayout arrivalF = (ConstraintLayout) findViewById(R.id.arrivalF);
        arrivalF.setVisibility(View.VISIBLE);
    }

}


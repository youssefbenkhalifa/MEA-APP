package com.example.meaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        EditText dep_holder = findViewById(R.id.dep);
        String dep = dep_holder.getText().toString();
        EditText arr_holder = findViewById(R.id.arr);
        String arr = arr_holder.getText().toString();
        EditText dep_date_holder = findViewById(R.id.dep_date);
        String dep_date = dep_date_holder.getText().toString();
        EditText nb_holder = findViewById(R.id.nb);
        String nb = dep_date_holder.getText().toString();

        intent.putExtra("dep",dep);
        intent.putExtra("arr",arr);
        intent.putExtra("dep_date",dep_date);
        intent.putExtra("nb",nb);






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


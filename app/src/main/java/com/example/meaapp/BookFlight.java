package com.example.meaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookFlight extends AppCompatActivity {
    FirebaseFirestore db;
    static final String TAG = "Read Data Activity";
    LinearLayout layout;
    String dep;
    String arr;
    String dep_date;
    String nb;
    String price;
    String city_dep;
    String city_arr;
    String dep_time;
    String dep_day;
    String arr_time;
    String arr_day;
    String flight_length;
    String flight_nb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_flight);
        Intent intent = getIntent();
        dep = intent.getStringExtra("dep");
        arr = intent.getStringExtra("arr");
        dep_date = intent.getStringExtra("dep_date");
        nb = intent.getStringExtra("nb");
        db = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.container);

        db.collection("Flight")
                .whereEqualTo("dep_city",dep).whereEqualTo("arr_city",arr).whereGreaterThan("capacity_left",0)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()){

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                price = document.get("price").toString();
                                Timestamp dep_stamp = document.getTimestamp("dep_time");
                                Timestamp arr_stamp = document.getTimestamp("arr_time");
                                flight_nb = document.get("flight_nb").toString();
                                Date date1 = dep_stamp.toDate();
                                Date date2 = arr_stamp.toDate();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault()); // "HH:mm:ss" for 24-hour time, "hh:mm:ss a" for 12-hour time with AM/PM
                                dep_day = sdf.format(date1).toString();
                                dep_time = timeFormat.format(date1).toString();
                                arr_day = sdf.format(date2).toString();
                                arr_time =  timeFormat.format(date2).toString();
                                flight_length = document.get("flight_length").toString();
                                city_dep = document.get("dep_city_name").toString();
                                city_arr = document.get("arr_city_name").toString();


                                Log.d(TAG, price);
                                addCard();


                            }



                        }else {

                            Toast.makeText(BookFlight.this,"Failed",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }


    private void addCard(){
        View view = getLayoutInflater().inflate(R.layout.flight_info,null);
        int marginInPixels = 80; // Margin in pixels

// Create MarginLayoutParams if the view's layout params are not already of that type
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(marginInPixels, marginInPixels, marginInPixels, marginInPixels);
        view.setLayoutParams(layoutParams);
        TextView dep_air = view.findViewById(R.id.dep_air);
        TextView arr_air = view.findViewById(R.id.arr_air);
        TextView price_holder = view.findViewById(R.id.price);
        TextView dep_city_holder = view.findViewById(R.id.dep_city);
        TextView arr_city_holder = view.findViewById(R.id.arr_city);
        TextView dep_time_holder = view.findViewById(R.id.dep_time);
        TextView arr_time_holder = view.findViewById(R.id.arr_time);
        TextView flight_time_holder = view.findViewById(R.id.flight_time);
        TextView arr_day_holder = view.findViewById(R.id.arr_day);
        TextView dep_day_holder = view.findViewById(R.id.dep_day);
        dep_city_holder.setText(city_dep);
        arr_city_holder.setText(city_arr);
        dep_time_holder.setText(dep_time);
        dep_day_holder.setText(dep_day);
        arr_time_holder.setText(arr_time);
        arr_day_holder.setText(arr_day);
        flight_time_holder.setText(flight_length+" Minutes");
        dep_air.setText(dep);
        arr_air.setText(arr);
        price_holder.setText(" $ "+price);
        layout.addView(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookFlight.this,ConfirmBooking.class);
                intent.putExtra("city_dep",city_dep);
                intent.putExtra("city_arr",city_arr);
                intent.putExtra("dep_time",dep_time);
                intent.putExtra("dep_day",dep_day);
                intent.putExtra("arr_time",arr_time);
                intent.putExtra("arr_day",arr_day);
                intent.putExtra("flight_length",flight_length);
                intent.putExtra("dep_air",arr);
                intent.putExtra("arr_air",arr);
                intent.putExtra("price",price);
                intent.putExtra("flight_nb",flight_nb);
                startActivity(intent);

            }


        });
    }
}
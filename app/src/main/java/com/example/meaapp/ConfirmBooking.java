package com.example.meaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Text;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class ConfirmBooking extends AppCompatActivity {
    String flight_nb;
    String firstName;
    String lastName;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirm_booking);

        Intent intent = getIntent();
        flight_nb = intent.getStringExtra("flight_nb");
        TextView flight_holder = findViewById(R.id.fl_nb);
        flight_holder.setText("Flight Number : "+flight_nb);
        TextView tv = findViewById(R.id.TV);;
        Button book = findViewById(R.id.bookBtn);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseFirestore.getInstance();
                EditText firstName_holder = findViewById(R.id.editTextText2);
                EditText lastName_holder = findViewById(R.id.emailTxt);
                firstName = firstName_holder.getText().toString();
                lastName = lastName_holder.getText().toString();
                String bookingRef = RandomStringGenerator.generateRandomString();
                Map<String,Object> user = new HashMap<>();
                user.put("first_name",firstName);
                user.put("last_name",lastName);
                user.put("booking_ref",bookingRef.toUpperCase());
                user.put("flight_nb",flight_nb);
                db.collection("Booking").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                    // tv.setText("Ref: "+ bookingRef.toUpperCase());
                     Intent intent2 = new Intent(ConfirmBooking.this,Booked.class);
                     intent2.putExtra("ref",bookingRef.toUpperCase());
                     startActivity(intent2);

                        //Toast.makeText(ConfirmBooking.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(ConfirmBooking.this,"FAIL",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        
        



    }
}
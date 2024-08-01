package com.example.meaapp;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {
    Button read;
    FirebaseFirestore db;
    static final String TAG = "Read Data Activity";
    private ListView listView;
    private ArrayList<User> adapter;
    private List<User> userList = new ArrayList<>();
    private String name;
    private String miles;
    private String email;
    private  String birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db = FirebaseFirestore.getInstance();
        TextView name_holder = findViewById(R.id.name);
        TextView miles_holder = findViewById(R.id.milesBalValue);
        TextView freq_holder = findViewById(R.id.frequentFlyerNb);
        EditText email_holder = findViewById(R.id.editEmail);
        EditText dob_holder = findViewById(R.id.editDateOfBirth);
        EditText phone_holder = findViewById(R.id.editPhoneNumber);
        EditText password_holder = findViewById(R.id.editPassword);
        read = findViewById(R.id.updateBtn);
        db.collection("User")
                .whereEqualTo("freq_code","MEA12345")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()){

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                String name = document.get("name").toString();
                                String miles = document.get("miles_bal").toString();
                                String email = document.get("email").toString();
                                String phone = document.get("phone").toString();
                                String birth = document.get("birth").toString();
                                name_holder.setText(name);
                                miles_holder.setText(miles);
                                freq_holder.setText("MEA12345");
                                email_holder.setText(email);
                                phone_holder.setText(phone);
                                dob_holder.setText(birth);
                                password_holder.setText("***********");

                            }
                            


                        }else {

                            Toast.makeText(Profile.this,"Failed",Toast.LENGTH_LONG).show();

                        }

                    }
                });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


    }
 /*   private void createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        RetrofitClient.getInstance().getUserService().createUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Profile.this, "User created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Profile.this, "Failed to create user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                Toast.makeText(Profile.this, "An error occurred", Toast.LENGTH_SHORT).show();

            }


        });
    }*/
}
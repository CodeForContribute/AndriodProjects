package com.gmail.raushaniiitu.localrestaurantfinderapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase; // reference to rootNode
    private DatabaseReference databaseReference; // reference to sub-rootNode
    EditText Name, UserName, UserPassword, UserEmail, UserPhoneNumber;
    Button signUpBtn, signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_sign_up);

        // Hooks to all xml elements in activity_sign_up.xml
        Name = findViewById(R.id.user_name_id);
        UserName = findViewById(R.id.user_userName_id);
        UserPassword = findViewById(R.id.user_password_id);
        UserEmail = findViewById(R.id.user_email_id);
        UserPhoneNumber = findViewById(R.id.user_phoneNumber_id);
        signUpBtn = findViewById(R.id.user_sign_up_btn);
        signInBtn = findViewById(R.id.user_sign_in_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                System.out.println("Sign Up btn clicked!!!!!!!");
                //firebaseDatabase = FirebaseDatabase.getInstance();
                //System.out.println("database Object " + firebaseDatabase.toString());
                //databaseReference = firebaseDatabase.getReference("Users");
                //System.out.println("DataBase reference: " + databaseReference.getDatabase().getReference().toString());
                //databaseReference.child("users").setValue("Avinash kumar");
                //databaseReference.setValue("Avinash kumar");
                startActivity(new Intent(getApplicationContext(),RestaurantsList.class));
            }
        });

    }
}

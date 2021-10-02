package com.gmail.raushaniiitu.whatsappclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gmail.raushaniiitu.whatsappclone.Models.Users;
import com.gmail.raushaniiitu.whatsappclone.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding activitySignUpBinding;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        activitySignUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(activitySignUpBinding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating account");
        progressDialog.setMessage("we're creating your account");
        activitySignUpBinding.signUpBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do the authentication
                String UserName = activitySignUpBinding.edtUserName.getText().toString();
                String UserEmailAddress = activitySignUpBinding.edtEmail.getText().toString();
                String UserPassword = activitySignUpBinding.edtPassword.getText().toString();
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(UserEmailAddress, UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Users user = new Users(UserName, UserEmailAddress, UserPassword);
                            String UserId = task.getResult().getUser().getUid();
                            //store the user Under the User Node in Real-time DataBase
                            firebaseDatabase.getReference().child("Users").child(UserId).setValue(user);
                            Toast.makeText(getApplicationContext(), "User created Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        activitySignUpBinding.tvAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.gmail.raushaniiitu.localrestaurantfinderapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import android.content.ContentValues.*;

public class SignInPage extends AppCompatActivity {
    //variable for FireBase Auth class
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    //variable for our text input
    //field for phone and OTP
    private EditText edtPhone, edtOTP;
    //buttons for generating OTP and verifying OTP
    private Button verifyOTPButton, generateOTPButton;
    //string for storing our verification ID
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        //below line is for getting instance of our FireBaseAuth
        mAuth = FirebaseAuth.getInstance();
        //initialising variables for button and EditText
        edtPhone = findViewById(R.id.idEdtPhoneNumber);
        edtOTP = findViewById(R.id.idEdtOtp);
        verifyOTPButton = findViewById(R.id.idBtnVerify);
        generateOTPButton = findViewById(R.id.idBtnGetOtp);

    }

    //------------------------------- DataBase - FireBase -----------------------------
    // retrieve an instance of your database using getInstance() and reference
    //You can save a range of data types to the database this way, including Java objects.
    // When you save an object the responses from any getters will be saved as children of this location.
    public void getInstance() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("message");
        databaseReference.setValue("Hello World");
    }

    // read from DataBase
    public void onDataChange() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called with the initial value and again
                // whenever data at this location is updated
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value" + databaseError.toException());
            }
        });
    }

//    private void signInWithCredential(PhoneAuthCredential credential){
//        //inside this method we are checking of the code entered is correct or not
//        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    // if the code is correct and the task is successful
//                    // we are sending our user to new activity
//                    Intent intent = new Intent(SignInPage.this,RestaurantsList.class);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    Toast.makeText(SignInPage.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }

//    private void sendVerificationCode(String number){
//        // this method is used for getting
//        // OTP on user phone number.
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber(number)            // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.
//    }

//    private void verifyOTPCode(String code){
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);
//        //after getting credentials we are calling sign In method
//        signInWithCredential(credential);
//    }
}
package com.gmail.raushaniiitu.localrestaurantfinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RestaurantsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantslist);
    }

    public void OpenKrishnaSweetsHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(),KrishaSweets.class);
        startActivity(intent);
        finish();
    }

    public void OpenPaneerHouseHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(),PaneerHouse.class);
        startActivity(intent);
        finish();
    }

    public void OpenJammiePizzaHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(),JammiePizza.class);
        startActivity(intent);
        finish();
    }

    public void OpenBiryaniHouseHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(),BiryaniHouse.class);
        startActivity(intent);
        finish();
    }
}
package com.gmail.raushaniiitu.fooddeliveryapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView backgroundImage, logo;
    TextView shopName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        backgroundImage = findViewById(R.id.bg_image_view_id);
        logo = findViewById(R.id.logo_image_view_id);
        shopName = findViewById(R.id.shop_name_id);
        lottieAnimationView = findViewById(R.id.lottie_animation_id);

        backgroundImage.animate().translationY(-2400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        shopName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);


    }
}
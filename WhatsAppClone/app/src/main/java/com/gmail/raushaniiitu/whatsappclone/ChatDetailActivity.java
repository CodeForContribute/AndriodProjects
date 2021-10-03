package com.gmail.raushaniiitu.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gmail.raushaniiitu.whatsappclone.databinding.ActivityChatDetailBinding;

public class ChatDetailActivity extends AppCompatActivity {
//    ActivityChatDetailBinding binding;
    ActivityChatDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
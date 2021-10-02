package com.gmail.raushaniiitu.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    RecyclerView recyclerView;
    List<ModelClass> userLists = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecyclerView();
    }

    public void initData() {
        userLists.add(new ModelClass(R.drawable.avi, "Avinash", "How are you?", "10:45 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Brijesh", "I am fine", "15:08 pm"));
        userLists.add(new ModelClass(R.drawable.avi, "Sam", "You Know?", "1:02 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Divya", "How are you?", "12:55 pm"));
        userLists.add(new ModelClass(R.drawable.avi, "Simran", "This is Easy", "13:50 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Karan", "I am Don", "1:08 am"));
        userLists.add(new ModelClass(R.drawable.avi, "Sameer", "You Know this?", "4:02 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Baby", "How ?", "11:55 pm"));
        userLists.add(new ModelClass(R.drawable.avi, "Anjali", "How are you?", "10:45 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Brijesh", "I am fine", "15:08 pm"));
        userLists.add(new ModelClass(R.drawable.avi, "Sam", "You Know?", "1:02 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Divya", "How are you?", "12:55 pm"));
        userLists.add(new ModelClass(R.drawable.avi, "Simran", "This is Easy", "13:50 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Karan", "I am Don", "1:08 am"));
        userLists.add(new ModelClass(R.drawable.avi, "Sameer", "You Know this?", "4:02 am"));
        userLists.add(new ModelClass(R.drawable.boy, "Baby", "How ?", "11:55 pm"));
    }

    public void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(userLists);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
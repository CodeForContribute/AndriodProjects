package com.gmail.raushaniiitu.whatsappclone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gmail.raushaniiitu.whatsappclone.Adapter.UsersAdapter;
import com.gmail.raushaniiitu.whatsappclone.Models.Users;
import com.gmail.raushaniiitu.whatsappclone.databinding.FragmentChatsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * create an instance of this fragment.
 */
public class ChatsFragment extends Fragment {
    FragmentChatsBinding binding;
    ArrayList<Users> userLists = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;

    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatsBinding.inflate(inflater, container, false);
        UsersAdapter adapter = new UsersAdapter(userLists, getContext());
        binding.chatRecyclerViewId.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager((getContext()));
        binding.chatRecyclerViewId.setLayoutManager(layoutManager);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userLists.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Users user = dataSnapshot.getValue(Users.class);
                    user.getUserId(dataSnapshot.getKey());
                    userLists.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return binding.getRoot();
    }
}
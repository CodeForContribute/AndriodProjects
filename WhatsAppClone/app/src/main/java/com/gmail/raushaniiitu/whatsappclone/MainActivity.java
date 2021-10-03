package com.gmail.raushaniiitu.whatsappclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gmail.raushaniiitu.whatsappclone.Adapter.FragmentAdapter;
import com.gmail.raushaniiitu.whatsappclone.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // below line of code is to attaching the java class to Layout.xml file to get the
        // resources later without calling findViewById(R.id.view_id)
        // Also help in adding setOnClickListener Even for desired views
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        //Objects.requireNonNull(getSupportActionBar()).hide();
        // get the firebase Authentication Instance
        firebaseAuth = FirebaseAuth.getInstance();
        // first create ViewPager for Recycler View(where Recycler view will be a Fragment)
        activityMainBinding.viewPagerId.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        // second add the ViewPager to respecting tabLayout positions
        activityMainBinding.tabLayoutId.setupWithViewPager(activityMainBinding.viewPagerId);
    }

    @Override
    // for creating menu such as Settings,Logout on right Top Corner (...)
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Actions based on the selected MenuOptions in the Top-right Corner
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                firebaseAuth.signOut();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.payments:
                Toast.makeText(getApplicationContext(), "payments clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.new_broadcast:
                Toast.makeText(getApplicationContext(), "new_broadcast clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.new_group:
                Toast.makeText(getApplicationContext(), "new_group clicked", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
package com.example.da1.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.da1.Fragments.HomeFragment;
import com.example.da1.Fragments.MyQuizFragment;
import com.example.da1.Fragments.ProfileFragment;
import com.example.da1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNav_homeactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment())
                .commit();

        bottomNav_homeactivity = findViewById(R.id.bottomNav_homeactivity);
        bottomNav_homeactivity.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:{

                        fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment())
                                .commit();
                        break;
                    }
                    case R.id.Store:{
                        break;
                    }
                    case R.id.myQuiz:{
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, new MyQuizFragment())
                                .commit();
                        break;
                    }
                    case R.id.Settings:{
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProfileFragment())
                                .commit();
                        break;
                    }
                }
                return true;
            }
        });
    }

    public void goCreate(){
        Intent intent = new Intent(HomeActivity.this, QuizCreationActivity.class);
        startActivity(intent);
        finish();
    }
}
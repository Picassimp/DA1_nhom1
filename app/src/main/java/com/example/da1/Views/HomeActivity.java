package com.example.da1.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.da1.Fragments.HomeFragment;
import com.example.da1.Fragments.MyQuizFragment;
import com.example.da1.Fragments.ProfileFragment;
import com.example.da1.Model.Subject;
import com.example.da1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNav_homeactivity;

    //khai báo ArrayList<SUBJECT>
    static ArrayList<Subject> subjectArrayList = new ArrayList<>();
    //khai báo FireBase
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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


        //cho bảng subject vào ArrayList<SUBJECT>
        db.collection("SUBJECTS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Map<String, Object> map = document.getData();
                                String SUBJECT_NAME = map.get("SUBJECT_NAME").toString();

//                                Map<String, Object> map = document.getData();
//                                String SUBJECT_NAME = document.getData().toString();
                                Subject subject = new Subject(SUBJECT_NAME);
                                subject.setSUBJECT_ID(document.getId());
                                subjectArrayList.add(subject);
                            }
                        } else {

                        }
                    }
                });
    }

    public void goCreate(){
        Intent intent = new Intent(HomeActivity.this, QuizCreationActivity.class);
        startActivity(intent);
        finish();
    }
}
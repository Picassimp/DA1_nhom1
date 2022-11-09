package com.example.da1.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.da1.Adapter.ViewPagerAdapter;
import com.example.da1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MyQuizFragment extends Fragment {


    public MyQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.tablayout_myquizfrag);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewpager_myquizfrag);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:{
                                tab.setText("Lịch sử");
                                break;
                            }
                            case 1:{
                                tab.setText("Quiz của tôi");
                                break;
                            }
                        }
                    }
                }
        ).attach();
    }
}
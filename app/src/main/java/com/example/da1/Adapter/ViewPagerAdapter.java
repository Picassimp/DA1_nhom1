package com.example.da1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.da1.Fragments.HistoryFragment;
import com.example.da1.Fragments.MyCreationFragment;
import com.example.da1.Fragments.MyQuizFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull MyQuizFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new HistoryFragment();
            case 1: return new MyCreationFragment();
        }
        return new HistoryFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

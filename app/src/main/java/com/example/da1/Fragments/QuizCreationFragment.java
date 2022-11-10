package com.example.da1.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.da1.Model.Quiz;
import com.example.da1.R;
import com.example.da1.Views.HomeActivity;
import com.example.da1.Views.QuizCreationActivity;

public class QuizCreationFragment extends Fragment {

    Quiz quiz;
    public QuizCreationFragment(Quiz quiz) {
        // Required empty public constructor
        this.quiz = quiz;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_creation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imgAdd = view.findViewById(R.id.img_quizCreationFragment_add);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuizCreationActivity)getActivity()).goCreateQues();
            }
        });
        TextView tv_quizCreationFragment_subject = view.findViewById(R.id.tv_quizCreationFragment_subject);
        tv_quizCreationFragment_subject.setText(quiz.getSubjectName());
    }
}
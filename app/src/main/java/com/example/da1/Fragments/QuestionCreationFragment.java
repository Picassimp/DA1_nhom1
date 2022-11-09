package com.example.da1.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.da1.R;
import com.example.da1.Views.QuizCreationActivity;

public class QuestionCreationFragment extends Fragment {

    public QuestionCreationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_creation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView addQuestion = view.findViewById(R.id.tv_questionCreationFragment_next);
        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi hàm thêm quiz
                ((QuizCreationActivity)getActivity()).goCreateQuiz();
            }
        });
    }
}
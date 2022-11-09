package com.example.da1.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.da1.Fragments.HomeFragment;
import com.example.da1.Fragments.QuestionCreationFragment;
import com.example.da1.Fragments.QuizCreationFragment;
import com.example.da1.R;

public class QuizCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_creation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuizCreationFragment())
                .commit();
    }

    public void goCreateQues(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuestionCreationFragment())
                .commit();
    }

    public void goCreateQuiz(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuizCreationFragment())
                .commit();
    }

    //viết hàm thêm ques
}
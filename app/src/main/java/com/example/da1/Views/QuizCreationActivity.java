package com.example.da1.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.da1.Adapter.ChooseSubjectAdapter;
import com.example.da1.Fragments.HomeFragment;
import com.example.da1.Fragments.QuestionCreationFragment;
import com.example.da1.Fragments.QuizCreationFragment;
import com.example.da1.Model.Quiz;
import com.example.da1.Model.Subject;
import com.example.da1.R;

import java.util.ArrayList;

public class QuizCreationActivity extends AppCompatActivity {

    //gọi subject Arraylist từ Home
    ArrayList<Subject> subjectArrayList = HomeActivity.subjectArrayList;

    //gọi Quiz
    Quiz quiz = new Quiz(null, null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_creation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuizCreationFragment(quiz))
                .commit();


    }

    public void goCreateQues(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuestionCreationFragment())
                .commit();
    }

    public void goCreateQuiz(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuizCreationFragment(quiz))
                .commit();
    }

    //viết hàm thêm ques

    public void chooseSubject(View view){
        //khai báo dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizCreationActivity.this);
        ArrayList<String> subjectName = new ArrayList<>();
        for (Subject s: subjectArrayList){
            subjectName.add(s.getSUBJECT_NAME());
        }
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.custom_subject_layout, null);
        ListView lv_customsubject_list = view1.findViewById(R.id.lv_customsubject_list);
        ChooseSubjectAdapter adapter = new ChooseSubjectAdapter(subjectName, QuizCreationActivity.this);
        lv_customsubject_list.setAdapter(adapter);

        builder.setView(view1);
        final AlertDialog show = builder.show();

        lv_customsubject_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                writeSubject(subjectName.get(position));
                show.dismiss();
            }
        });
    }

    public void writeSubject(String subject){
        quiz.setSubjectName(subject);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_quizCreationActivity_holder, new QuizCreationFragment(quiz))
                .commit();
        Log.d("TAG>>>", subject);

    }
}
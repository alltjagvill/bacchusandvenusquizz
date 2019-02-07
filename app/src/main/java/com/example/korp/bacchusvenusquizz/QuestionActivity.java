package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__activity);


        Quiz quiz = (Quiz) getIntent().getSerializableExtra("QUIZOBJECT");

        Log.d("QUIZOBJECT", quiz.title);

        for (int i = 0; i < quiz.questions.length; i++) {


            Log.d("MYCLASS", quiz.questions[i].question);
            Log.d("MYCLASS", quiz.questions[i].a_r);
            Log.d("MYCLASS", quiz.questions[i].a_w1);
            Log.d("MYCLASS", quiz.questions[i].a_w2);
            Log.d("MYCLASS", quiz.questions[i].a_w3);
        }


        /*String title = getIntent().getStringExtra("TITLE");
        String author = getIntent().getStringExtra("AUTHOR");
        String category = getIntent().getStringExtra("CATEGORY");
        Question[] questions = getIntent().getArray("QUESTIONS");
        Log.d("GET_EXTRA", title);
        Log.d("GET_EXTRA", author);
        Log.d("GET_EXTRA", category);
        Log.d("GET_EXTRA", questions[0]);*/


    }
}

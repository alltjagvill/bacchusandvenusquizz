package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.lang.reflect.Array;

public class QuestionActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__activity);


        Quiz quiz = (Quiz) getIntent().getSerializableExtra("QUIZOBJECT");

        Log.d("QUIZOBJECT", quiz.title);

        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);
       // mProgressBar.setProgress(timer);
        Log.d("TIMER", Integer.toString(timer));





    }


    public void startTimer() {
        new CountDownTimer(10000, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + timer + millisUntilFinished);
                Log.d("TIMER", Integer.toString(timer));
                timer++;
                mProgressBar.setProgress(timer * 100 / (10000 / 10));

            }



            @Override
            public void onFinish() {
                mProgressBar.setProgress(100);
                //Do what you want
                //timer = 0;

            }
        }.start();
    }

    public void startQuestion(Quiz quiz, int position) {

        Log.d("QUIZOBJECT", quiz.questions[position].question);
        Log.d("QUIZOBJECT", quiz.questions[position].a_r);
        Log.d("QUIZOBJECT", quiz.questions[position].a_w1);
        Log.d("QUIZOBJECT", quiz.questions[position].a_w2);
        Log.d("QUIZOBJECT", quiz.questions[position].a_w3);
    }


}


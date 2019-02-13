package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ScoreActivity extends AppCompatActivity {
    ArrayList<String> rightAnswers;
    ArrayList<String> yourAnswers;
    ArrayList<String> questions;

    ArrayList<Answer> answerList = new ArrayList<>();

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), genre.class);
        startActivity(intent);
        finish();
    }

    int score = 0;
    //int count = 0;





    TextView scoreCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        rightAnswers = extras.getStringArrayList("RIGHTANSWERS");
        yourAnswers = extras.getStringArrayList("YOURANSWERS");
        questions = extras.getStringArrayList("QUESTIONS");


      //  ArrayList1 answerlist= (ArrayList1) extras.getSerializable("ANSWERLIST");

     //   ArrayAdapter adapter = new AnswerAdapter(this, answerList);

        String headline = extras.getString("TITLE");
        TextView title = findViewById(R.id.score_title);
        title.setText(headline);

        String nrOfAnswers = Integer.toString(rightAnswers.size());
        TextView nrOfAnswersCount = findViewById(R.id.maxScore);
        nrOfAnswersCount.setText(nrOfAnswers);

        scoreCount = findViewById(R.id.yourScore);

        countScore();



    }

    public void countScore() {

        String questionString = getString(R.string.question);
        String rightAnswerString = getString(R.string.rightAnswer);
        String yourAnswerString = getString(R.string.yourAnswer);
        String right;
        String guessed;
        String question;
        for (int i = 0; i < rightAnswers.size(); i++) {

            //answerList.add(questionString + questions.get(i));
            //answerList.add(rightAnswerString + rightAnswers.get(i));
            //answerList.add(yourAnswerString + yourAnswers.get(i));

            right = rightAnswers.get(i);
            guessed = yourAnswers.get(i);
            question = questions.get(i);

            Answer answerObj = new Answer(question, right, guessed);

            answerList.add(answerObj);



            //Log.d("SCORE", right);
            //Log.d("SCORE", guessed);

            if (guessed.equals(right)) {
                score++;


                }



        }

        ListView answerView = findViewById(R.id.answerListView);
        /*ArrayAdapter rightAnswerAdapter = new RightAnswerAdapter(this, rightAnswers);
        ArrayAdapter yourAnswerAdapter = new YourAnswerAdapter(this, yourAnswers);
        answerView.setAdapter(rightAnswerAdapter);
        answerView.setAdapter(yourAnswerAdapter);*/
        AnswerAdapter adapter = new AnswerAdapter(this, answerList);
        answerView.setAdapter(adapter);


        Log.d("SCORE", Integer.toString(score));
        Log.d("SCORE1", String.valueOf(score));

        scoreCount.setText(String.valueOf(score));

    }

    public void scoreTimerCount() {



    }
}
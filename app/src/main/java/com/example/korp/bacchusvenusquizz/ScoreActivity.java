package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;


public class ScoreActivity extends AppCompatActivity {

    //Create arraylists
    ArrayList<String> rightAnswers;
    ArrayList<String> yourAnswers;
    ArrayList<String> questions;
    ArrayList<Answer> answerList = new ArrayList<>();
    //****Create arraylists


    ImageView venus;
    TextView titleClick;
    Button btn;

    View rootView;
    String savedName;
    SharedPreferences sharedPref;
    final String MYPREFERENCES = "MYPREFERENCES";
    final String NAME_KEY = "namekey";


    //Gets back to category selection (prevents ordinary back press)
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ActivityGenre.class);
        startActivity(intent);
        finish();
    }
    //***Gets back to category selection (prevents back press

    int score = 0;
    TextView scoreCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

//Get stuff from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        rightAnswers = extras.getStringArrayList("RIGHTANSWERS");
        yourAnswers = extras.getStringArrayList("YOURANSWERS");
        questions = extras.getStringArrayList("QUESTIONS");
        String headline = extras.getString("TITLE");
        //***Get stuff from previous activity





        //Sets headline of current quiz
        TextView title = findViewById(R.id.score_title);
        title.setText(headline);
        //***Sets headline of current quiz


        String nrOfAnswers = Integer.toString(rightAnswers.size());
        TextView nrOfAnswersCount = findViewById(R.id.maxScore);
        nrOfAnswersCount.setText(nrOfAnswers);
        sharedPref = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        savedName = sharedPref.getString(NAME_KEY, null);

        TextView teamName = findViewById(R.id.scoreName);

        teamName.setText(savedName);


        scoreCount = findViewById(R.id.yourScore);

        countScore();




    }

    public void countScore() {

        String right;
        String guessed;
        String question;

        for (int i = 0; i < rightAnswers.size(); i++) {

            right = rightAnswers.get(i);
            guessed = yourAnswers.get(i);
            question = questions.get(i);

            Answer answerObj = new Answer(question, right, guessed);

            answerList.add(answerObj);

            if (guessed.equals(right)) {
                score++;
                }

        }

        ListView answerView = findViewById(R.id.answerListView);
        AnswerAdapter adapter = new AnswerAdapter(this, answerList);
        answerView.setAdapter(adapter);

        scoreCount.setText(String.valueOf(score));

    }


}
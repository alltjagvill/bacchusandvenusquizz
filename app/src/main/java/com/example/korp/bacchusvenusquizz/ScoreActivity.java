package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.Serializable;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int score = 0;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        ArrayList<String> rightAnswers = extras.getStringArrayList("RIGHTANSWERS");
        ArrayList<String> yourAnswers = extras.getStringArrayList("YOURANSWERS");

        for (int i = 0; i < rightAnswers.size(); i++) {

            String right = rightAnswers.get(i);
            String guessed = yourAnswers.get(i);

            if (guessed.equals(right)) {
                score++;
            }

            Log.d("SCORE", Integer.toString(score));

        }

    }
}
package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


public class ScoreActivity extends AppCompatActivity {

    //Create arraylists
    ArrayList<String> rightAnswers;
    ArrayList<String> yourAnswers;
    ArrayList<String> questions;
    ArrayList<Answer> answerList = new ArrayList<>();
    //****Create arraylists

    //Gets back to category selection (prevents ordinary back press)
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), genre.class);
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
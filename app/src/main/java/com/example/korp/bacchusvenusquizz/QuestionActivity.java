package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    int timer;
    int position = 0;
    int timePerQuestion;
    int quizLength;

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> rightAnswers = new ArrayList<String>();
    ArrayList<String> yourAnswers = new ArrayList<String>();

    ProgressBar mProgressBar;

    @Override
    public void onBackPressed() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__activity);

        String noAnswer = getString(R.string.noAnwser);

        Quiz quiz = (Quiz) getIntent().getSerializableExtra("QUIZOBJECT");
        quizLength = quiz.questions.length;

        //Countdowntimer stuff
        timePerQuestion = quiz.timePerQuestion * 1000;
        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);

        TextView questionTitle = findViewById(R.id.questionTitle);
        questionTitle.setText(quiz.title);



        //Creating a arraylist with all the right answers and populate yourAnswers with default "No answer"

        for (int i = 0; i < quizLength; i++) {
            questions.add(quiz.questions[i].question);
            Log.d("QUESTION", questions.get(i));

            rightAnswers.add(quiz.questions[i].a_r);
            Log.d("ANSWERS1", rightAnswers.get(i));

            yourAnswers.add(noAnswer);
            Log.d("ANSWERS1", yourAnswers.get(i));

        }




        //Set onclick listener on the buttons
        Button b1 = findViewById(R.id.answer1);
        Button b2 = findViewById(R.id.answer2);
        Button b3 = findViewById(R.id.answer3);
        Button b4 = findViewById(R.id.answer4);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionSelected(v);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionSelected(v);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionSelected(v);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                questionSelected(v);
            }
        });

        startQuestion(quiz, timePerQuestion);
    }

    /* -------------------------------- Methods ------------------------------*/

    //Start a timer and goes to next question if question not answered
    public void startTimer(final Quiz quiz1, final int timePerQuestion) {


        new CountDownTimer(timePerQuestion, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                //Log.d("TIMER1", Integer.toString(timePerQuestion));
                Log.v("Log_tag", "Tick of Progress" + timer + millisUntilFinished);

                timer++;
                mProgressBar.setProgress(timer * 100 / (timePerQuestion / 10));
            }

            @Override
            public void onFinish() {

                mProgressBar.setRotation(0);
                timer = 0;
                position = position + 1;
                startQuestion(quiz1, timePerQuestion);
            }
        }.start();


    }

    //Starts the question in line and starts the timer
    public void startQuestion(Quiz quiz, int timePerQuestion) {

        Log.d("POSITON", Integer.toString(position));
        if (position >= quizLength) {

            Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);

            //Bundle extras = new Bundle();

           // ArrayList[] toScore = {questions, rightAnswers, yourAnswers};
            //ArrayList<ArrayList> toScore = new ArrayList1<question>();


            intent.putExtra("TITLE", quiz.title);
            intent.putStringArrayListExtra("RIGHTANSWERS", rightAnswers);
            intent.putStringArrayListExtra("YOURANSWERS", yourAnswers);
            intent.putStringArrayListExtra("QUESTIONS", questions);


           // intent.putExtra("ANSWERLIST", toScore);

            startActivity(intent);
        }
        else {



            Random rand = new Random();
            int buttonPositionNumber = rand.nextInt(4) + 1;

            TextView theQuestion = findViewById(R.id.question);
            theQuestion.setText(quiz.questions[position].question);

            Button b1 = findViewById(R.id.answer1);
            Button b2 = findViewById(R.id.answer2);
            Button b3 = findViewById(R.id.answer3);
            Button b4 = findViewById(R.id.answer4);

            setDefaultColor(b1, b2, b3, b4);



            //Sets text random on buttons
            if (buttonPositionNumber == 1) {

                b1.setText(quiz.questions[position].a_r);
                b2.setText(quiz.questions[position].a_w1);
                b3.setText(quiz.questions[position].a_w2);
                b4.setText(quiz.questions[position].a_w3);
            }

            else if (buttonPositionNumber == 2) {

                b2.setText(quiz.questions[position].a_r);
                b3.setText(quiz.questions[position].a_w1);
                b4.setText(quiz.questions[position].a_w2);
                b1.setText(quiz.questions[position].a_w3);

            }

            else if (buttonPositionNumber == 3) {

                b3.setText(quiz.questions[position].a_r);
                b4.setText(quiz.questions[position].a_w1);
                b1.setText(quiz.questions[position].a_w2);
                b2.setText(quiz.questions[position].a_w3);

            }

            else if (buttonPositionNumber == 4) {

                b4.setText(quiz.questions[position].a_r);
                b1.setText(quiz.questions[position].a_w1);
                b2.setText(quiz.questions[position].a_w2);
                b3.setText(quiz.questions[position].a_w3);

            }

            else {
                Log.d("CRASH", "Could not set text on buttons");
            }

            startTimer(quiz, timePerQuestion);
        }
    }

    public void questionSelected(View view) {

        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);
        Button answer4 = findViewById(R.id.answer4);

        setDefaultColor(answer1, answer2, answer3, answer4);


        if (view.getId() == R.id.answer1) {


            String answer = answer1.getText().toString();
            yourAnswers.set(position, answer);
            answer1.setBackgroundColor(Color.RED);



        }
        else if (view.getId() == R.id.answer2) {


            String answer = answer2.getText().toString();
            yourAnswers.set(position, answer);
            answer2.setBackgroundColor(Color.RED);
        }

        else if (view.getId() == R.id.answer3) {


            String answer = answer3.getText().toString();
            yourAnswers.set(position, answer);
            answer3.setBackgroundColor(Color.RED);

        }

        else if (view.getId() == R.id.answer4) {


            String answer = answer4.getText().toString();
            yourAnswers.set(position, answer);
            answer4.setBackgroundColor(Color.RED);


        }


    }

    public void setDefaultColor(Button button1, Button button2, Button button3, Button button4) {

        button1.setBackgroundColor(R.drawable.rounded_button_corner);
        button2.setBackgroundColor(R.drawable.rounded_button_corner);
        button3.setBackgroundColor(R.drawable.rounded_button_corner);
        button4.setBackgroundColor(R.drawable.rounded_button_corner);

    }

}


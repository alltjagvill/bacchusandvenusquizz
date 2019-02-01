package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class genre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);


        }

    public void startSex(View sexView) {
        Intent sex = new Intent(getApplicationContext(), ListQuizz.class);
        sex.putExtra("CATEGORY", "sex");
        startActivity(sex);
    }

    public void startMemes(View memesView) {
        Intent memes = new Intent(getApplicationContext(), ListQuizz.class);
        memes.putExtra("CATEGORY", "memes");
        startActivity(memes);
    }

    public void startAlcohol(View alcoholView) {
        Intent alcohol = new Intent(getApplicationContext(), ListQuizz.class);
        alcohol.putExtra("CATEGORY", "alcohol");
        startActivity(alcohol);
    }

    public void startMisc(View miscView) {
        Intent misc = new Intent(getApplicationContext(), ListQuizz.class);
        misc.putExtra("CATEGORY", "misc");
        startActivity(misc);
    }
}

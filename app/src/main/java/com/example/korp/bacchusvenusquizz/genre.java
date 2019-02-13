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
        Intent sex = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_sex);
        sex.putExtra("CATEGORY", "sex");
        sex.putExtra("HEADLINE", title);

        startActivity(sex);
    }

    public void startMemes(View memesView) {
        Intent memes = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_memes);
        memes.putExtra("CATEGORY", "memes");
        memes.putExtra("HEADLINE", title);
        startActivity(memes);
    }

    public void startAlcohol(View alcoholView) {
        Intent alcohol = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_alcohol);
        alcohol.putExtra("CATEGORY", "alcohol");
        alcohol.putExtra("HEADLINE", title);
        startActivity(alcohol);
    }

    public void startMisc(View miscView) {
        Intent misc = new Intent(getApplicationContext(), ListQuizActivity.class);
        String title = getString(R.string.headline_misc);
        misc.putExtra("CATEGORY", "misc");
        misc.putExtra("HEADLINE", title);
        startActivity(misc);
    }
}

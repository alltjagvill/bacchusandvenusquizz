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
        Intent sex = new Intent(getApplicationContext(), Category_Sex.class);

        startActivity(sex);
    }

    public void startMemes(View memesView) {
        Intent memes = new Intent(getApplicationContext(), Category_Memes.class);

        startActivity(memes);
    }

    public void startAlcohol(View alcoholView) {
        Intent alcohol = new Intent(getApplicationContext(), Category_Alcohol.class);
        startActivity(alcohol);
    }

    public void startMisc(View miscView) {
        Intent misc = new Intent(getApplicationContext(), Category_Misc.class);
        startActivity(misc);
    }
}

package com.example.korp.bacchusvenusquizz;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class Category_Memes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__memes);

        final AssetManager assetManager = getAssets();

        try {
            String[] memesQuizz = assetManager.list("memes");
            if (memesQuizz == null) {

            }
            else {
                for (int i = 0; i < memesQuizz.length; i++) {
                    String filename = memesQuizz[i];
                }
            }
            ListView memesQuizzListView = findViewById(R.id.memes_quizzes);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, memesQuizz);
            memesQuizzListView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

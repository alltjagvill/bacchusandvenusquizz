package com.example.korp.bacchusvenusquizz;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class Category_Sex extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__sex);

        final AssetManager assetManager = getAssets();



      try {
            String[] sexQuizzes = assetManager.list("sex");
            if (sexQuizzes == null) {

            }
            else {
                for (int i = 0; i < sexQuizzes.length; i++) {
                    String filename = sexQuizzes[i];
                    Log.i("SEXQUIZZ", sexQuizzes[i]);
                }
            }

            ListView sexQuizzesListView = findViewById(R.id.sex_quizzes);
          ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sexQuizzes);
          sexQuizzesListView.setAdapter(adapter);

      } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

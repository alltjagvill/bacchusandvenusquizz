package com.example.korp.bacchusvenusquizz;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class ListQuizzes extends AppCompatActivity {
    //My other activities sends what "category" folder it should list files
    public void list(String category) {

        //Creating folder variable
        String category1 = "\"" + category + "\"";


        //Creates array with file names
        final AssetManager assetManager = getAssets();

        try {
            String[] list = assetManager.list(category1);
            if (list == null) {

            }
            else {
                for (int i = 0; i < list.length; i++) {
                    String filename = list[i];
                }
            }

            //Creates a variable to get right ListView id
            String quizzes = category + "_quizzes";
            int id = getResources().getIdentifier(quizzes, "id", getPackageName());

            //Put the array into the ListView
            ListView quizzessView = findViewById(id);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class ListQuizzes  {

    //Categories sends what "category" folder it should list files
    public void list(String category, AppCompatActivity activity) {

        //Creating folder variable
        String category1 = "\"" + category + "\"";
        Log.i("folder", category1);

        //Creates array with file names
        final AssetManager assetManager = activity.getAssets();

        try {
            String[] list = assetManager.list(category);//category1);
            if (list == null) {
                Log.i("NOASSETS", "Do not get assets");

            }
            else {
                for (int i = 0; i < list.length; i++) {
                    String filename = list[i];
                    Log.i("filename", list[i]);
                }
            }

            //Creates a variable to get right ListView id
            String quizzes = category + "_quizzes";
            int id = activity.getResources().getIdentifier(quizzes, "id", activity.getPackageName());
            Log.i("quizzes", quizzes);

            //Put the array into the ListView
            ListView quizzessView = activity.findViewById(id);
            ArrayAdapter adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.korp.bacchusvenusquizz;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListQuizz extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_quizz);

        String category = getIntent().getStringExtra("CATEGORY");
        String categoryName = category + "List";

        final AssetManager assetManager = getAssets();

        try {
            String[] list = assetManager.list(category);

            ArrayList<Quiz> categoryNameList = new ArrayList<>();


            String filename;
            Gson gson = new Gson();

            if (list == null) {
                Log.i("NOASSETS", "Do not get assets");

            }
            else {

                    for ( String d : list) {

                        String json = loadJSONFromAsset(category, d);

                        Log.i("JSON", json);

                        Quiz obj = gson.fromJson(json, Quiz.class);
                        categoryNameList.add(obj);



                    }




            }



            //Put the array into the ListView
            ListView quizzessView = findViewById(R.id.quizz_list);
            ArrayAdapter adapter = new QuizAdapter(this, categoryNameList);
            quizzessView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Reads the json-file and convert it to a string
    public String loadJSONFromAsset(String folder, String file) {
        String path = folder + "/" + file;
        String json = null;
        try {
            InputStream is = this.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ListQuizz extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_quizz);

        String category = getIntent().getStringExtra("CATEGORY");
        String categoryName = category + "List";

        final AssetManager assetManager = getAssets();

        try {
            String[] list = assetManager.list(category);

            final ArrayList<Quiz> categoryNameList = new ArrayList<>();


            String filename;
            Gson gson = new Gson();

            if (list == null) {


            }
            else {

                    for ( String d : list) {

                        String json = loadJSONFromAsset(category, d);


                        Quiz obj = gson.fromJson(json, Quiz.class);
                        categoryNameList.add(obj);
                        }

            }



            //Put the array into the ListView
            final ListView quizzessView = findViewById(R.id.quizz_list);
            ArrayAdapter adapter = new QuizAdapter(this, categoryNameList);
            quizzessView.setAdapter(adapter);




            //Create click listener
            quizzessView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Bundle extras = new Bundle();

                    Quiz selectedQuiz = (Quiz) quizzessView.getItemAtPosition(position);
                    Intent sendQuiz = new Intent(getApplicationContext(), QuestionActivity.class);
                    sendQuiz.putExtra("QUIZOBJECT", selectedQuiz);

                    /*extras.putString("TITLE", selectedQuiz.title);
                    String title = selectedQuiz.title;
                    sendQuiz.putExtra("TITLE", selectedQuiz.title);
                    sendQuiz.putExtra("AUTHOR", selectedQuiz.author);
                    sendQuiz.putExtra("CATEGORY", selectedQuiz.category);
                    sendQuiz.putExtra("QUESTIONS", selectedQuiz.questions);*/

                    startActivity(sendQuiz);


                }
            });




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

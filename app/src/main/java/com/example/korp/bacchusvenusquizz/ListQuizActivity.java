package com.example.korp.bacchusvenusquizz;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListQuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_quizz);

        Intent intent = getIntent();
        String category = intent.getStringExtra("CATEGORY");
        String headlineText = intent.getStringExtra("HEADLINE");
        TextView headline = (TextView) findViewById(R.id.quiz_list_title);

        Log.d("HEADLINE", headlineText);
        headline.setText(headlineText);

        final AssetManager assetManager = getAssets();

       /* try {
            String path = Environment.getExternalStorageDirectory().toString() + "/bovquiz/" + category + "/";
            //  Log.d("DUH", "Path: " + path);
            File directory = new File(path);
            File[] files = directory.listFiles();
            // Log.d("DUH", "Size: "+ files.length);
            final ArrayList<Quiz> categoryNameList = new ArrayList<>();
            Gson gson = new Gson();

            if (files == null) {

            } else {

                for (File d : files) {
                    String name = d.getName();
                    Log.d("DUH", name);
                    String json = loadJSONFromAsset(path, name);
                    Quiz obj = gson.fromJson(json, Quiz.class);
                    categoryNameList.add(obj);
                    //Log.d("DUH", "FileName:" + files[d].getName());
                }


        }
        } catch(NullPointerException e){
            e.printStackTrace();
        }*/

        try {
            String[] list = assetManager.list(category);

            final ArrayList<Quiz> categoryNameList = new ArrayList<>();

            Gson gson = new Gson();

            if (list == null) {

            } else {
                for (String d : list) {

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

                    Quiz selectedQuiz = (Quiz) quizzessView.getItemAtPosition(position);
                    Intent sendQuiz = new Intent(getApplicationContext(), QuestionActivity.class);
                    sendQuiz.putExtra("QUIZOBJECT", selectedQuiz);

                    startActivity(sendQuiz);


                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        //Reads the json-file and convert it to a string
        public String loadJSONFromAsset (String folder, String file){
            String path = folder + "/" + file;
            Log.d("DUH", file);
            String json;
        /*try {

            //FileInputStream is = new FileInputStream(Environment.getExternalStorageDirectory().toString() + "/bovquiz/" + path);
           // reader = new BufferedReader(new InputStreamReader(Environment.getExternalStorageDirectory().toString() + "/bovquiz/" + path));
            InputStream is = Environment.getExternalStorageDirectory() + "/bovquiz/" + path;
            *//*{
                @Override
                public int read() throws IOException {
                    return 0;
                }
            };*//*
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }*/
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


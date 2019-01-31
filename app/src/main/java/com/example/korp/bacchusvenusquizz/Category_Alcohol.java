package com.example.korp.bacchusvenusquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Category_Alcohol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__alcohol);

        ListQuizzes list = new ListQuizzes();

        list.list("alcohol");
    }
}

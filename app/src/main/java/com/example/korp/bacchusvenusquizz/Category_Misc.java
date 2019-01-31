package com.example.korp.bacchusvenusquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Category_Misc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__misc);

        ListQuizzes list = new ListQuizzes();
        list.list("misc");
    }
}

package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizAdapter extends ArrayAdapter<Quiz> {

    public QuizAdapter(Context context, ArrayList<Quiz> quiz) {
        super(context, 0, quiz);
    }

    @Override
    public View getView(int position, View counterView, ViewGroup parent) {

        Quiz quiz = getItem(position);
        if (counterView == null) {
            counterView = LayoutInflater.from(getContext()).inflate(R.layout.quizlisting, parent, false);
        }

        TextView name = counterView.findViewById(R.id.quizName);
        TextView author = counterView.findViewById(R.id.author);
        TextView date = counterView.findViewById(R.id.date);

        name.setText(quiz.title);
        author.setText(quiz.author);
        date.setText(quiz.date);
        return counterView;


    }
}

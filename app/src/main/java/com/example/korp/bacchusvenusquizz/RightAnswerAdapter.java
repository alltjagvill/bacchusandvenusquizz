package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RightAnswerAdapter extends ArrayAdapter<String> {

    public RightAnswerAdapter (Context context, ArrayList<String> value) {
        super(context, 0, value);
    }

    @Override
    public View getView(int position, View counterView, ViewGroup parent) {

        String rightAnswer = getItem(position);
        if (counterView == null) {
            counterView = LayoutInflater.from(getContext()).inflate(R.layout.answerlisting, parent, false);
        }

        TextView theRightAnswer = counterView.findViewById(R.id.rightAnswer);
       // TextView author = counterView.findViewById(R.id.author);
        //TextView date = counterView.findViewById(R.id.date);

        theRightAnswer.setText(rightAnswer);
        //author.setText(quiz.author);
       // date.setText(quiz.date);
        return counterView;


    }
}

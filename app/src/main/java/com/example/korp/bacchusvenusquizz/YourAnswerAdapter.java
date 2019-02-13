package com.example.korp.bacchusvenusquizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class YourAnswerAdapter extends ArrayAdapter<String> {

    public YourAnswerAdapter (Context context, ArrayList<String> value) {
        super(context, 0, value);
    }

    @Override
    public View getView(int position, View counterView, ViewGroup parent) {

        String yourAnswer = getItem(position);
        if (counterView == null) {
            counterView = LayoutInflater.from(getContext()).inflate(R.layout.answerlisting, parent, false);
        }

        TextView theYourAnswer = counterView.findViewById(R.id.yourAnswer);
        // TextView author = counterView.findViewById(R.id.author);
        //TextView date = counterView.findViewById(R.id.date);

        theYourAnswer.setText(yourAnswer);
        //author.setText(quiz.author);
        // date.setText(quiz.date);
        return counterView;


    }
}

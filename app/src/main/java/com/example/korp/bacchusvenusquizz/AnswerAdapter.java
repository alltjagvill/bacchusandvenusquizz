package com.example.korp.bacchusvenusquizz;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AnswerAdapter extends ArrayAdapter<Answer> {

    public AnswerAdapter(Context context, ArrayList<Answer> answer) {
        super(context, 0, answer);
    }

    @Override
    public View getView(int position, View counterView, ViewGroup parent) {

        Answer answer = getItem(position);
        if (counterView == null) {
            counterView = LayoutInflater.from(getContext()).inflate(R.layout.answerlisting, parent, false);
        }

        TextView questionTextView = counterView.findViewById(R.id.theQuestion);
        TextView rightAnswerTextView = counterView.findViewById(R.id.rightAnswer);
        TextView yourAnswerTextView = counterView.findViewById(R.id.yourAnswer);

        questionTextView.setText(answer.question);
        rightAnswerTextView.setText(answer.rightAnswer);
        yourAnswerTextView.setText(answer.yourAnswer);

        if (answer.yourAnswer.equals(answer.rightAnswer))
            yourAnswerTextView.setBackgroundColor(Color.GREEN);
        else
            yourAnswerTextView.setBackgroundColor(Color.RED);

        return counterView;


    }
}





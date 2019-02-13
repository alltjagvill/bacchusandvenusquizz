package com.example.korp.bacchusvenusquizz;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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

        TextView question = counterView.findViewById(R.id.theQuestion);
        TextView rightAnswer = counterView.findViewById(R.id.rightAnswer);
        TextView yourAnswer = counterView.findViewById(R.id.yourAnswer);

        question.setText(answer.question);
        rightAnswer.setText(answer.rightAnswer);
        yourAnswer.setText(answer.yourAnswer);
        return counterView;


    }
}





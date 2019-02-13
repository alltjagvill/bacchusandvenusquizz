package com.example.korp.bacchusvenusquizz;

import java.io.Serializable;

public class Answer implements Serializable {
    String question;
    String rightAnswer;
    String yourAnswer;

    public Answer (String question, String rightAnswer, String yourAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.yourAnswer = yourAnswer;
    }
}

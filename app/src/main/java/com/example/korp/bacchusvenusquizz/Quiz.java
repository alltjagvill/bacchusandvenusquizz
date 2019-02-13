package com.example.korp.bacchusvenusquizz;

import java.io.Serializable;

public class Quiz implements Serializable {

 String title;
 String category;
 String author;
 String date;
 int timePerQuestion;
 Question[] questions;
}
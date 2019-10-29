package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.sayitahminoyunu.GuessActivity.sayac;

public class ExpenseModel extends AppCompatActivity {
    private int id;
    private String date;

    public ExpenseModel(int score) {
        sayac = score;
        this.date = Utility.getNow();
    }

    public ExpenseModel(int score, String date) {
        sayac = score;
        this.date = date;
    }

    public ExpenseModel(int id, int score, String date) {
        this.id = id;
        sayac = score;
        this.date = date;
    }

    public int getScore() {
        return sayac;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        sayac = score;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

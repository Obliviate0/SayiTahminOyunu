package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.sayitahminoyunu.GuessActivity.sayac;

public class ExpenseModel extends AppCompatActivity {
    private int id;
    private String date;
    private int hamle = sayac;

    public ExpenseModel(int score) {
        this.id = id;
        hamle = score;
        this.date = Utility.getNow();
    }


    public int getScore() {
        return hamle;
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
        hamle = score;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

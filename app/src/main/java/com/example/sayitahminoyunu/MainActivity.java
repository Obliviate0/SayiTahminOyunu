package com.example.sayitahminoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.sayitahminoyunu.GuessActivity.sayac;

public class MainActivity extends AppCompatActivity {
    private Button buttonBaslat;
    private Button buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBaslat = findViewById(R.id.buttonBaslat);
        buttonScore = findViewById(R.id.buttonScore);

        //Butona Tiklayinca Ne Yapacagini Yaziyoruz
        buttonBaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GuessActivity.class);//GuessActivitye Geciyoruz
                sayac = 0; //Geri Gelince Sayac Uzerine Saymasın Diye Sıfırlıyoruz
                startActivity(i);
            }
        });

        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScoreActivity.class);//ScoreActivitye Geciyoruz
                startActivity(i);
            }
        });
    }
}
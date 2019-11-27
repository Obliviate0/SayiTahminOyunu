package com.example.sayitahminoyunu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static com.example.sayitahminoyunu.Guess2StartActivity.sayi;

public class Guess2Activity extends AppCompatActivity {
    private Button buttonUp;
    private Button buttonDown;
    private TextView textRndGuess;
    private TextView textSayiGosterge;
    private int randomNumber;
    private int max;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess2);

        buttonUp = findViewById(R.id.buttonUp);
        buttonDown = findViewById(R.id.buttonDown);
        textRndGuess = findViewById(R.id.textRndGuess);
        textSayiGosterge = findViewById(R.id.textSayiGostege);

        min=0;
        max=100;

        textSayiGosterge.setText("Tutulan Sayi = " + sayi);

        Random r = new Random();
        randomNumber = r.nextInt(max-min+1) + min;//ilk 0-100 arası bir sayı tutuyor
        Log.d(String.valueOf(randomNumber), "onCreate: ");
        textRndGuess.setText(""+randomNumber);

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min=randomNumber+1;
                Random r = new Random();
                randomNumber = r.nextInt(max-min+1) + min;
                Log.d(String.valueOf(randomNumber), "onClick: ");
                textRndGuess.setText(""+randomNumber);

            }
        });

        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                max=randomNumber;

                Random r = new Random();
                randomNumber = r.nextInt(max-min+1) + min;
                Log.d(String.valueOf(randomNumber), "onClick: ");
                textRndGuess.setText(""+randomNumber);
            }
        });


        }

    }
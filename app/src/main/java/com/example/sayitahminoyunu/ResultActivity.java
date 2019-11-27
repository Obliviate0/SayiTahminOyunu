package com.example.sayitahminoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.sayitahminoyunu.GuessActivity.sayac;

public class ResultActivity extends AppCompatActivity {
    private Button buttonNewGame;
    private TextView textResult;
    private ImageView imageFrog;
    private boolean frogKermit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageFrog = findViewById(R.id.imageFrog);
        textResult = findViewById(R.id.textResult);
        buttonNewGame = findViewById(R.id.buttonNewGame);

        frogKermit = getIntent().getBooleanExtra("frogKermit",false);

        //Sonuc False Gelirse Calisacak Olan Kisim
        if (frogKermit){
            imageFrog.setImageResource(R.drawable.image_omg);//Resimi Degistirmek İcin
            textResult.setText("OMG "+ sayac +". Denemede Buldunuz");//Yaziyi Degistirmek İcin
        }
        //False Gelirse Calisacak Olan Kisim
        else{
            imageFrog.setImageResource(R.drawable.image_like);//Resimi Degistirmek İcin
            textResult.setText("Tebrikler "+ sayac +". Denemede Buldunuz");}//Yaziyi Degistirmek İcin

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this,GuessActivity.class);
                sayac = 0;//Yeniden Oyunu Baslatinca Yaptigimiz Hamleyi Ustune Saymamasi Icin Sifirliyoruz
                startActivity(i);
                finish();
            }
        });
    }
}

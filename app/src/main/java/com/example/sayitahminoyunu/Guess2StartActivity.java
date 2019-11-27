package com.example.sayitahminoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Guess2StartActivity extends AppCompatActivity {
    private Button buttonStart;
    private EditText textSayi;
    public static int sayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess2start);

        buttonStart = findViewById(R.id.buttonStart);
        textSayi = findViewById(R.id.textSayi);

     buttonStart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             //Bos Ise 0a Eşitlemek Icın Kontrol Ediyoruz
             String sayiString = textSayi.getText().toString();
             if (sayiString.equals("")) {
                 sayiString = "0";
             }
             try {
                 // int yapmaya calis
                 sayi = Integer.parseInt(sayiString);
             } catch (Exception e) {
                 // yapamazsa sifir olsun
                 sayi = 0;
             }
             Intent i = new Intent(Guess2StartActivity.this,Guess2Activity.class);
             startActivity(i);

         }
     });

    }
}
package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.sayitahminoyunu.GuessActivity.sayac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonBaslat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBaslat = findViewById(R.id.buttonBaslat);

        //Butona Tiklayinca Ne Yapacagini Yaziyoruz
        buttonBaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GuessActivity.class);//GuessActivitye Geciyoruz
                sayac = 0; //Geri Gelince Sayac Uzerine Saymasın Diye Sıfırlıyoruz
                startActivity(i);
            }
        });

    }
}

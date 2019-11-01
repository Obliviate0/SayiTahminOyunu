package com.example.sayitahminoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {
    public static int sayac = 0;
    private TextView StatusText;
    private EditText InputNumber;
    private Button CheckButton;
    private int rndNumber;
    private Database addRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        StatusText = findViewById(R.id.StatusText);
        InputNumber = findViewById(R.id.InputNumber);
        CheckButton = findViewById(R.id.CheckButton);

        Random r = new Random();
        rndNumber = r.nextInt(101);// 0-100 arası Random Sayı Oluşturma


        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayac = sayac + 1 ; // Tahmin Et Butonuna Basınca Yaptığımız Hamle Sayısını Arttırmak

                //Bos Ise 0a Eşitlemek Icın Kontrol Ediyoruz
                String amountString = InputNumber.getText().toString();
                if (amountString.equals("")) {
                    amountString = "0";
                }
                int tahmin;
                try {
                    // int yapmaya calis
                    tahmin = Integer.parseInt(amountString);
                } catch (Exception e) {
                    // yapamazsa sifir olsun
                    tahmin = 0;
                }

                // Tahmin Tutulan Sayıya Eşit İse
                if (tahmin == rndNumber){

                    Database database = new Database(GuessActivity.this);
                    database.addRecord(new ExpenseModel(sayac));

                    //Sayaç 6ya Eşit Veya Küçükse Çıkacak Olan Sonuç Ekranı
                    if (sayac <= 6){
                        Intent i = new Intent(GuessActivity.this,ResultActivity.class);//Sonuc Ekranina Geciyoruz
                        i.putExtra("frogKermit",true);
                        startActivity(i);
                        finish();

                    }

                    //Sayaç 6dan Büyükse Çıkacak Olan Sonuç Ekranı
                    if (sayac > 6){
                        Intent i = new Intent(GuessActivity.this,ResultActivity.class);//Sonuc Ekranina Geciyoruz
                        i.putExtra("frogKermit",false);
                        startActivity(i);
                        finish();
                    }

                }
                //Tahmin Tutulan Sayıdan Büyükse Verilecek Talimat
                if (tahmin > rndNumber){
                    StatusText.setText("Azalt");
                }
                //Tahmin Tutulan Sayıdan Küçükse Verilecek Talimat
                if (tahmin < rndNumber){
                    StatusText.setText("Arttır");
                }

                InputNumber.setText(""); //Tahmin Et Butonuna Bastıktan Sonra Girilen Veriyi Temizler

            }
        });
    }

    }

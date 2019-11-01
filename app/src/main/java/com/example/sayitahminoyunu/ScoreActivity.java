package com.example.sayitahminoyunu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    private Button buttonDeneme;

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        buttonDeneme = findViewById(R.id.buttonDeneme);
        listView = findViewById(R.id.listVieww);

        //Butona Tiklayinca Ne Yapacagini Yaziyoruz
        buttonDeneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database database = new Database(ScoreActivity.this);
                ArrayList<ExpenseModel> lList = database.getAllRecords();
                ArrayAdapter<ExpenseModel> adapter = new ArrayAdapter<>(ScoreActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1, lList);
                listView.setAdapter(adapter);
            }
        });
    }
}
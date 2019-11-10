package com.example.sayitahminoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ScoreActivity  extends AppCompatActivity {

    Button returnMainMenu;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        returnMainMenu = findViewById(R.id.buttonReturnMainMenu);
        recyclerView = findViewById(R.id.liste);

        returnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void listExpenses(){
        Database db = new Database(this);
        ArrayList<ExpenseModel> myList = db.getAllRecords();
        MyListAdapter adapter = new MyListAdapter(this, myList);
        recyclerView.setAdapter(adapter);
    }
}

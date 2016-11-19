package com.example.briandesouza.saveitwhilewecan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent i;
    private TextView overallButton, toButton, monthButton, tipBoxButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overallButton = (TextView) findViewById(R.id.overallScore);
        toButton = (TextView) findViewById(R.id.todayScore);
        monthButton = (TextView) findViewById(R.id.monthScore);
        tipBoxButton = (TextView) findViewById(R.id.tipBox);


    }

    public void userInput(View v) {
        i = new Intent(MainActivity.this, DailyInputActivity.class);
        startActivity(i);
    }
}

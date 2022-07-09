package com.harrihidayat.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextListview(View view){
        Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
        startActivity(intent);
    }

    public void nextPopup(View view){
        Intent intent = new Intent(MainActivity.this, PopupActivity.class);
        startActivity(intent);
    }

    public void nextAlarm(View view){
        Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
        startActivity(intent);
    }
}
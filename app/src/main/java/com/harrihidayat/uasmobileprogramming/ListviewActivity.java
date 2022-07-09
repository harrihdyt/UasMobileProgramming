package com.harrihidayat.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListviewActivity extends AppCompatActivity {

    ListView lv;

    private String[] menu = {"Sate", "Baso", "Ayam Goreng", "Ayam Bakar", "Rendang", "Gado-gado", "Ikan Bakar", "Seafood", "Western", "Nasi Goreng"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,menu);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You have Selected: " + menu[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
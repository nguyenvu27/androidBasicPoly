package com.example.lab3_android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab3_android.R;
import com.example.lab3_android.model.Product;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    String[] lv = {"Android cơ bản", "Android nâng cao", "Thiết kế giao diện Android",
            "Test và triển khai ứng dụng Android", "NodeJS", "Game 2D"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        listView = (ListView) findViewById(R.id.lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv) ;
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view ;
        Toast.makeText(this, ""+tv.getText(), Toast.LENGTH_SHORT).show();
    }
}

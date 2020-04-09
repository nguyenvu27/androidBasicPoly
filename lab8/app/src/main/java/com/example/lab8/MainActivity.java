package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab8.activity.Bai1Activity;
import com.example.lab8.activity.Bai2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Bai1(View view) {
        Intent intent = new Intent(MainActivity.this, Bai2Activity.class) ;
        startActivity(intent);
    }

    public void Bai2(View view) {
        Intent intent = new Intent(MainActivity.this, Bai1Activity.class) ;
        startActivity(intent);
    }
}

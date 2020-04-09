package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.activity.Bai3Activity;
import com.example.myapplication.activity.External;
import com.example.myapplication.activity.Internal;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Internal(View view) {
        Intent intent = new Intent(MainActivity.this, Internal.class);
        startActivity(intent);
    }

    public void External(View view) {
        Intent intent = new Intent(MainActivity.this, External.class);
        startActivity(intent);
    }

    public void Bai3(View view) {
        Intent intent = new Intent(MainActivity.this, Bai3Activity.class);
        startActivity(intent);
    }
}

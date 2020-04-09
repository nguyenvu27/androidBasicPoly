package com.example.lab3_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab3_android.activity.Bai1Activity;
import com.example.lab3_android.activity.Bai2Activity;
import com.example.lab3_android.activity.Bai3Activity;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnBai1);
        button2 = findViewById(R.id.btnBai2);
        button3 = findViewById(R.id.btnBai3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai1Activity.class) ;
                startActivity(intent);
        }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai2Activity.class) ;
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai3Activity.class) ;
                startActivity(intent);
            }
        });
    }
}

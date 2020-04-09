package com.example.lab3_android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab3_android.R;

public class KQActivity extends AppCompatActivity {
    TextView tvKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kq);

        tvKQ = findViewById(R.id.resultKQ);
        Intent intent = getIntent();
        int a = Integer.parseInt(intent.getExtras().getString("a"));
        int b = Integer.parseInt(intent.getExtras().getString("b"));
        int c = Integer.parseInt(intent.getExtras().getString("c"));
        float detal = b * b - 4 * a * c;

        if (detal < 0) {
            tvKQ.setText("Phương trình vô nghiệm");
        } else if (detal == 0) {
            tvKQ.setText("Phương trình có nghiệm kép: x=" + (-b) / (2 * a));
        } else {
            float x1 = (float) ((-b + Math.sqrt(detal)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(detal)) / (2 * a));
            tvKQ.setText("Phương trình có 2 nghiệm: x1=" + x1 + "\nx2=" + x2);
        }
    }
}

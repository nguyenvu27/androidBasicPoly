package com.example.lab4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4.R;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.KQ);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("but");
        int a = bundle.getInt("soA");
        int b = bundle.getInt("soB");
        int bscnn = BSCNN(a, b);
        textView.setText(String.valueOf(bscnn));

    }

    //USCLN
    public int USCLN(int a, int b) {
        if (b == 0) {
            return a;

        } else {
            return USCLN(b, a % b);
        }
    }

    //BSCNN
    public int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }
}

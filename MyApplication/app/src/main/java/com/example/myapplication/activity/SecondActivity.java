package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.tv);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String name = bd.getString("name");
            textView.setText(name);
        }
    }


    public void shutdown(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

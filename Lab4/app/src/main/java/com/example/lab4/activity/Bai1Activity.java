package com.example.lab4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab4.MainActivity;
import com.example.lab4.R;

public class Bai1Activity extends AppCompatActivity {
    EditText txtSoA, txtSoB;
    Button btnBSCNN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        txtSoA = findViewById(R.id.edSo1);
        txtSoB = findViewById(R.id.edSo2);
        btnBSCNN = findViewById(R.id.btnBSCNN);

        btnBSCNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai1Activity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("soA", Integer.parseInt(txtSoA.getText().toString()));
                bundle.putInt("soB", Integer.parseInt(txtSoB.getText().toString()));
                intent.putExtra("but", bundle);
                startActivity(intent);
            }
        });
    }
//
//    //USCLN
//    public int USCLN(int a, int b) {
//        if (b == 0) {
//            return a;
//
//        } else {
//            return USCLN(b, a % b);
//        }
//    }
//
//    //BSCNN
//    public int BSCNN(int a, int b) {
//        return (a * b) / USCLN(a, b);
//    }
}

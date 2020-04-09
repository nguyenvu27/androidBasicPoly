package com.example.assignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.R;


public class ThemLopActivity extends AppCompatActivity {
    EditText txtMalop, txtTenLop;
    Button btnLuuLop, btnXoaTrang;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);

        txtMalop = findViewById(R.id.edtMaLop);
        txtTenLop = findViewById(R.id.edtTenLop);
        btnLuuLop = findViewById(R.id.btnLuuLop);
        btnXoaTrang = findViewById(R.id.btnXoaTrang);


    }}

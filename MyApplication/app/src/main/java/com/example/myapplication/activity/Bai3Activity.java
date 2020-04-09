package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class Bai3Activity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUser, edtPass;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user";
    String PASS_KEY = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        btnLogin = findViewById(R.id.btnLogin);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        checkBox = findViewById(R.id.checkbox);

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        edtUser.setText(sharedPreferences.getString(USERNAME_KEY, ""));
        edtPass.setText(sharedPreferences.getString(PASS_KEY, ""));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();

                if (user.equals("") && pass.equals("")) {
                    Toast.makeText(Bai3Activity.this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (checkBox.isChecked()) {
                        editor = sharedPreferences.edit();
                        editor.putString(USERNAME_KEY, edtUser.getText().toString().trim());
                        editor.putString(PASS_KEY, edtPass.getText().toString());
                        editor.commit();
                    }
                    Intent intent = new Intent(Bai3Activity.this, SecondActivity.class);
                    intent.putExtra("name", edtUser.getText().toString());
                    startActivity(intent);
                    Toast.makeText(Bai3Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

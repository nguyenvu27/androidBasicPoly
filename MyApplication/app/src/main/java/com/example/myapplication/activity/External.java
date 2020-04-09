package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class External extends AppCompatActivity {
    //    EditText fileName, text;
    private EditText edtText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        edtText2 = findViewById(R.id.editText2);
//
//        fileName = findViewById(R.id.fileName);
//        text = findViewById(R.id.text);
    }

    public void loadFromSD(View view) {
        try {

            String file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";
            Scanner scanner = new Scanner(new File(file));
            String data = "";
            while (scanner.hasNext()) {
                data = data + scanner.nextLine();
            }
            scanner.close();
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

        }


    }

    public void saveToSD(View view) {
        String text = edtText2.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Can nhap thong tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // xin quyen, hoi y kien nguoi dung xem co dong y cho ghi vao the nho ko ?
        if (ContextCompat.checkSelfPermission(External.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // viet cau lenh xin quyen or hoi y kien nguoi dung
            ActivityCompat.requestPermissions(External.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 999);

        } else {
            try {

                String file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                outputStreamWriter.write(text);
                outputStreamWriter.close();
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.e("ABC", e.getMessage());
            }
        }

    }

//    private boolean isExternalStorageWritable() {
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void writeFile(View v) {
//        if (isExternalStorageWritable() && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
//            File textFile = new File(Environment.getExternalStorageDirectory(), fileName.getText().toString()) ;
//            try{
//                FileOutputStream fos = new FileOutputStream(textFile) ;
//                fos.write(text.getText().toString().getBytes());
//                fos.close();
//                Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public boolean checkPermission(String permission){
//        int check = ContextCompat.checkSelfPermission(this, permission) ;
//        return (check == PackageManager.PERMISSION_GRANTED) ;
//    }
}

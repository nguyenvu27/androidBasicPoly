package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Internal extends AppCompatActivity {
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        edtText = findViewById(R.id.editText);
    }

    public void saveToCache(View view) {

        String text = edtText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Can nhap thong tin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            File cacheDir = getCacheDir();
            String fileName = "myCache.cache";

            File file = new File(cacheDir, fileName);
            file.createNewFile();

            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

        } catch (IOException ex) {


        }


    }

    public void loadFromCache(View view) {

        try {
            File cacheDir = getCacheDir();
            String fileName = "myCache.cache";

            File file = new File(cacheDir, fileName);

            Scanner scanner = new Scanner(file);

            String data = "";
            while (scanner.hasNext()) {
                data = data + scanner.nextLine();
            }
            scanner.close();

            Toast.makeText(this, data, Toast.LENGTH_LONG).show();


        } catch (IOException ex) {


        }

    }
}

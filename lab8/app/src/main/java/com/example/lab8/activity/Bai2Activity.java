package com.example.lab8.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab8.R;

public class Bai2Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        editText = findViewById(R.id.edt);
        button = findViewById(R.id.btn);
        webView = findViewById(R.id.wv);
        webView.setWebViewClient(new WebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString().trim();
                webView.loadUrl("http://"+url);
            }
        });
    }
}

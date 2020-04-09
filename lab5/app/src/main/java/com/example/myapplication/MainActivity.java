package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapters.MyAdapter;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edName, edPhone, edAddress;
    Button btnAdd;
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Student> arrayList;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edName = findViewById(R.id.edtName);
        edPhone = findViewById(R.id.edtPhone);
        edAddress = findViewById(R.id.edtAdress);
        listView = findViewById(R.id.lv);
        databaseHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<>();
//        LoadDataInListView();
    }

    private void LoadDataInListView() {
        arrayList = databaseHelper.getAllData();
        myAdapter = new MyAdapter(this, arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    public void insert(View v) {
//        boolean result = databaseHelper.insertData(edName.getText().toString(), edPhone.getText().toString(), edAddress.getText().toString());
//        if (result) {
//            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
//        }
        if (edName.getText().toString().equals("") || edPhone.getText().toString().equals("") || edAddress.toString().equals("")) {
            Toast.makeText(this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();

        }
        if (edName.length() < 5 || edPhone.length() < 5 || edAddress.length() < 5) {
            Toast.makeText(this, "Bạn cần nhập đủ 5 kí tự", Toast.LENGTH_SHORT).show();
        } else {
            boolean result = databaseHelper.insertData(edName.getText().toString(), edPhone.getText().toString(), edAddress.getText().toString());
            if (result) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                arrayList = databaseHelper.getAllData();
                myAdapter = new MyAdapter(this, arrayList);
                listView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

                edName.setText("");
                edPhone.setText("");
                edAddress.setText("");
            }
        }
    }
}

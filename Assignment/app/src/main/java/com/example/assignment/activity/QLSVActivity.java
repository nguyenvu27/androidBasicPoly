package com.example.assignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.assignment.R;
import com.example.assignment.adapters.MyAdapter2;
import com.example.assignment.database.DatabaseHelper;
import com.example.assignment.model.Student2;

import java.util.ArrayList;

public class QLSVActivity extends AppCompatActivity {
    EditText edName, edDate;
    Button btnAdd;
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Student2> arrayList;
    MyAdapter2 myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlsv);

        Spinner spinner = findViewById(R.id.sp);
        ArrayList<String> array = new ArrayList<>();
        array.add("Android cơ bản");
        array.add("Android nâng cao");
        array.add("Thiết kế giao diện Android");
        array.add("Android cơ bản");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        edName = findViewById(R.id.edtName);
        edDate = findViewById(R.id.edtDate);
        listView = findViewById(R.id.lv2);
        databaseHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<>();

//        LoadDataInListView();
    }

    private void LoadDataInListView() {
//        arrayList = databaseHelper.getAllData();
//        myAdapter = new MyAdapter(this, arrayList);
//        listView.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();

    }

    public void insert(View v) {
        if (edName.getText().toString().equals("") || edDate.getText().toString().equals("")) {
            Toast.makeText(this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            boolean result = databaseHelper.insertData2(edName.getText().toString(), edDate.getText().toString());
            if (result) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                arrayList = databaseHelper.getAllData2();
                myAdapter = new MyAdapter2(this, arrayList);
                listView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

                edName.setText("");
                edDate.setText("");
            }
        }
    }
}
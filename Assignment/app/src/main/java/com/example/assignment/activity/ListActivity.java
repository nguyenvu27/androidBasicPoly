package com.example.assignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.assignment.R;
import com.example.assignment.adapters.MyAdapter;
import com.example.assignment.database.DatabaseHelper;
import com.example.assignment.model.Student;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Student> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.lv);
        databaseHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<>();
        LoadDataInListView();


    }

    private void LoadDataInListView() {
        arrayList = databaseHelper.getAllData();
        myAdapter = new MyAdapter(this, arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}

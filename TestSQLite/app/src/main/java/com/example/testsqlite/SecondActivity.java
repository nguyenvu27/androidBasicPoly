package com.example.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.testsqlite.adapters.MyAdapter;
import com.example.testsqlite.database.DatabaseHelper;
import com.example.testsqlite.model.Student;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Student> arrayList ;
    MyAdapter myAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.lv2);
        databaseHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<>() ;
        LoadDataInListView();
    }
    private void LoadDataInListView() {
        arrayList = databaseHelper.getAllData() ;
        myAdapter = new MyAdapter(this, arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}

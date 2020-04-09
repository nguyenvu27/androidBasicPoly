package com.example.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testsqlite.adapters.MyAdapter;
import com.example.testsqlite.database.DatabaseHelper;
import com.example.testsqlite.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edName, edAge;
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
        edAge = findViewById(R.id.edtAge);
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

    public void disPlay(View v) {
        Cursor cursor = (Cursor) databaseHelper.getAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            stringBuffer.append("Name:" + cursor.getString(1) + "\n");
            stringBuffer.append("Age:" + cursor.getString(2) + "\n");
        }
        Toast.makeText(this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
    }

    public void insert(View v) {
        boolean result = databaseHelper.insertData(edName.getText().toString(), edAge.getText().toString());
        if (result) {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        }
    }

    public void Second(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}

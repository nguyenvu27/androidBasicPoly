package com.example.testsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.testsqlite.model.Student;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE StudentInfo ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS StudentInfo ");
        onCreate(db);
    }

    public boolean insertData(String name, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("AGE", age);
        long result = db.insert("StudentInfo", null, contentValues);

        if (result == -1) return false;
        else return true;

    }

//    public Cursor getAllData() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(" SELECT * FROM StudentInfo ", null);
//        return cursor;
//    }

    public ArrayList<Student> getAllData() {
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM StudentInfo ", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            Student student = new Student(id, name, age);

            arrayList.add(student);
        }
        return arrayList;

    }
}

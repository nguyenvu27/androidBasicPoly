package com.example.assignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assignment.model.Student;
import com.example.assignment.model.Student2;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "student.db, student2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE StudentInfo ( ID INTEGER PRIMARY KEY AUTOINCREMENT, MALOP TEXT, TENLOP TEXT )");
        db.execSQL(" CREATE TABLE StudentInfo2 ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DATE TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS StudentInfo ");
        db.execSQL(" DROP TABLE IF EXISTS StudentInfo2");
        onCreate(db);
    }

    public boolean insertData(String malop, String tenlop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MALOP", malop);
        contentValues.put("TENLOP", tenlop);
        long result = db.insert("StudentInfo", null, contentValues);

        if (result == -1) return false;
        else return true;

    }


    public boolean insertData2(String name, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("DATE", date);
        long result = db.insert("StudentInfo2", null, contentValues);

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
            String malop = cursor.getString(1);
            String tenlop = cursor.getString(2);
            Student student = new Student(id, malop, tenlop);

            arrayList.add(student);
        }
        return arrayList;

    }

    public ArrayList<Student2> getAllData2() {
        ArrayList<Student2> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM StudentInfo2 ", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            Student2 student2 = new Student2(id, name, date);

            arrayList.add(student2);
        }
        return arrayList;

    }
}

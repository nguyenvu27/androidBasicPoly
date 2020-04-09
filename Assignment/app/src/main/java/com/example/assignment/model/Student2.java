package com.example.assignment.model;

public class Student2 {
    int id;
    String name, date;


    public Student2(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Student2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

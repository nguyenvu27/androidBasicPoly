package com.example.assignment.model;

public class Student {
    int id;
    String malop, tenlop;

    public Student(int id, String malop, String tenlop) {
        this.id = id;
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}

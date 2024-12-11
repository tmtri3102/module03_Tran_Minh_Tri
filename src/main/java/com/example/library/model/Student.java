package com.example.library.model;

public class Student {
    private int studentId;
    private String fullName;
    private String studentClass;

    public Student(int studentId, String fullName, String studentClass) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.studentClass = studentClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}

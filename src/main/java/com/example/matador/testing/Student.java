package com.example.matador.testing;

public class Student {
    private int studentId;
    private String name;
    private String major;

    public Student(int studentId, String name, String major) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
    }

    public Student() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

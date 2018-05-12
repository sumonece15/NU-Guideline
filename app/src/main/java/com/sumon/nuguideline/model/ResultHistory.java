package com.sumon.nuguideline.model;

/**
 * Created by sumon on 5/11/2018.
 */

public class ResultHistory {

    private String studentName;
    private String studentCgpa;
    private String studentSemester;

    public ResultHistory(String studentName, String studentCgpa, String studentSemester) {
        this.studentName = studentName;
        this.studentCgpa = studentCgpa;
        this.studentSemester = studentSemester;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCgpa() {
        return studentCgpa;
    }

    public void setStudentCgpa(String studentCgpa) {
        this.studentCgpa = studentCgpa;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }
}

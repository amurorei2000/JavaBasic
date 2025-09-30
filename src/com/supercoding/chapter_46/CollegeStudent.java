package com.supercoding.chapter_46;

abstract class CollegeStudent {
    protected String studentNumber;
    protected String name;
    protected double gpa;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s{studentNumber='%s', name='%s', gpa=%s}", getClass().getSimpleName(),  studentNumber, name, gpa);
    }
}

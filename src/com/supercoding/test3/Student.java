package com.supercoding.test3;

public class Student {
    private String name; // 이름
    private String gender; // 성별

    private int score;

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getGender() {
        return gender;
    }

    public Student(String name, String gender, int score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }
}

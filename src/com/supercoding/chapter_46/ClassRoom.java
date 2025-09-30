package com.supercoding.chapter_46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoom<T extends CollegeStudent> {

    protected String className;
    protected Map<String, T> studentMap = new HashMap<>();
    protected List<String> studentNames = new ArrayList<>();

    public ClassRoom(String name) {
        this.className = name;
    }

    public void addStudent(T student) {
        String studentName = student.getName();
        String studentNumber = student.getStudentNumber();
        studentMap.put(studentNumber, student);
        studentNames.add(studentName);
    }


    public T getStudentByStudentNumber(String studentNumber) {
         T foundStudent = studentMap.get(studentNumber);
         return foundStudent;
    }

    public void printStudentNames() {
        String nameStrings = String.format("이 클래스 룸(%s)은 학생들 %s가 있습니다.", className, studentNames.toString());
        System.out.println(nameStrings);
    }
}

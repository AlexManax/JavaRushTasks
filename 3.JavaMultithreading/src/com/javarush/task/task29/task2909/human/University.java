package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student:students) {
            if (student.getAverageGrade()==averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = 0d;
        for (Student student:students) {
            if (student.getAverageGrade()>max) max = student.getAverageGrade();
        }
        return getStudentWithAverageGrade(max);
    }

    public Student getStudentWithMinAverageGrade() {
        double min = Double.MAX_VALUE;
        for (Student student:students) {
            if (student.getAverageGrade()<min) min = student.getAverageGrade();
        }
        return getStudentWithAverageGrade(min);
    }

    public void expel(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
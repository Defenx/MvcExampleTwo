package com.example.studentsapp.domain.model;

public class Student implements Comparable<Student> {

    private String name;
    private Double performance;

    public static Student createNew(String name, Double performance) {
        return new Student(name, performance);
    }

    private Student(String name, Double performance) {
        this.name = name;
        this.performance = performance;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public Double getPerformance() {
        return performance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", performance='" + performance + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return getPerformance().compareTo(o.getPerformance());
    }
}

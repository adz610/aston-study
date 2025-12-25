package org.example;

import java.util.Map;

public class Student {
    private final String name;
    private String group;
    private int course;
    private final Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        double sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

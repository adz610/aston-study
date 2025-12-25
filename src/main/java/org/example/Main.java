package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Иванов Иван", "ИТ11", 1, Map.of("Математика", 2,
                                                                                     "Программирование", 3,
                                                                                     "Физика", 2)));

        students.add(new Student("Цветкова Юлия", "ИТ11", 1, Map.of("Математика", 5,
                                                                                       "Программирование", 4,
                                                                                       "Физика", 3)));

        students.add(new Student("Смирнов Степан", "ИТ12", 1, Map.of("Математика", 4,
                                                                                        "Программирование", 5,
                                                                                        "Физика", 4)));

        students.add(new Student("Иванова Дарья", "ИТ12", 1, Map.of("Математика", 3,
                                                                                       "Программирование", 3,
                                                                                       "Физика", 3)));
        removeStudentsWithBadGrades(students);
        promoteStudentsWithGoodGrades(students);
        printStudents(students, 2);

        System.out.println();

        PhoneBook book = new PhoneBook();
        book.add("Иванов", "+7 (928) 111-22-33");
        book.add("Цветкова", "+7 (988) 444-55-66");
        book.add("Смирнов", "+7 (989) 777-88-99");
        book.add("Иванов", "+7 (928) 123-45-67");

        System.out.println("Номера телефонов людей с фамилией \"Иванов\": " + book.get("Иванов"));
        System.out.println("Номера телефонов людей с фамилией \"Цветкова\": " + book.get("Цветкова"));
        System.out.println("Номера телефонов людей с фамилией \"Смирнов\": " + book.get("Смирнов"));
    }

    private static void removeStudentsWithBadGrades(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    private static void promoteStudentsWithGoodGrades(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    private static void printStudents(Set<Student> students, int course) {
        System.out.println("На " + course + " курсе обучаются:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
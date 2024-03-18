package udemy.lambda.test_predicate;

import java.util.List;
import java.util.function.Predicate;

public class Student {

    protected String name;
    protected double avg;
    protected int age;
    protected int course;
    protected char gender;

    public Student(String name, double avg, int age, int course, char gender) {
        this.name = name;
        this.avg = avg;
        this.age = age;
        this.course = course;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", avg=" + avg +
                ", age=" + age +
                ", course=" + course +
                ", gender=" + gender +
                '}';
    }

    public static void displayUsingFilter(List<Student> students, Predicate<Student> predicate, String message) {

        if (message != null) System.out.println(message);

        for (Student s: students)
            if (predicate.test(s)) System.out.println(s);

    }

    public String getName() {
        return name;
    }

    public double getAvg() {
        return avg;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public char getGender() {
        return gender;
    }
}

package udemy.lambda.test_function;

import udemy.lambda.test_predicate.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Maksym", 3.67, 17, 1, 'M');
        Student s2 = new Student("Artem", 4.5, 18, 1, 'M');
        Student s3 = new Student("Bohdan", 5.0, 28, 4, 'M');
        Student s4 = new Student("Random", 2.94, 23, 3, 'M');
        Student s5 = new Student("ABC", 4.1, 19, 2, 'F');
        Student s6 = new Student("Random", 4.95, 26, 4, 'F');

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);

//        Function<Student, Double> f = student -> student.getAvg();

        double averageOfAllStudents = averageGrades(list, s -> (double)s.getCourse());
        System.out.println(averageOfAllStudents);

    }

    private static double averageGrades(List<Student> list, Function<Student, Double> function) {
        double result = 0;


        for (Student s: list) {
            result += function.apply(s);
        }

        return result / list.size();
    }

}


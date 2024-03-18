package udemy.lambda.test_predicate;

import udemy.lambda.test_predicate.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

        Predicate<Student> p1 = (Student student) -> student.getGender() == 'M';
        Predicate<Student> p2 = (Student student) -> student.getAvg() >= 4.5;

        Student.displayUsingFilter(list, p1.and(p2), "Gender: M and Avg >= 4.5");
        Student.displayUsingFilter(list, p1.or(p2), "Gender: M or Avg >= 4.5");
        Student.displayUsingFilter(list, p2.negate(), "Avg lower 4.5");

//        Student.displayUsingFilter(list, s -> s.getAge() >= 21, "Filter age >= 21");
//        Student.displayUsingFilter(list, s -> s.getGender() == 'M', "Filter gender = M");

        // ===================================================================================================

//        StudentInfo.printStudentsOverGrade(list, 4);
//        System.out.println();
//        StudentInfo.printStudentsUnderAge(list, 21);
//        System.out.println();
//        StudentInfo.printStudentsMixCondition(list, 19, 4, 'M');

//        StudentInfo studentInfo = new StudentInfo();
//
//        studentInfo.testStudent(list, new CheckOverGrade());
        // Anonymous class
//        studentInfo.testStudent(list, new StudentCheck() {
//            @Override
//            public boolean check(Student s) {
//                return s.getAge() < 18;
//            }
//        });

        // Lambda
//        studentInfo.testStudent(list, s -> s.getAge() <= 18);


//        System.out.println("before sort:");
//        System.out.println(list);
//        Collections.sort(list, (Student std1, Student std2) -> std1.getAge() - std2.getAge());
//        System.out.println("after sort");
//        System.out.println(list);



    }
}

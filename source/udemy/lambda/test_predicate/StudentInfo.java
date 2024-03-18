package udemy.lambda.test_predicate;

import java.util.List;

public class StudentInfo {


    public void testStudent(List<Student> students, StudentCheck sc) {
        for (Student s : students) {
            if (sc.check(s)) System.out.println(s);
        }
    }


    // ================================================

    public StudentInfo() {
    }

    public static void printStudentsOverGrade(List<Student> students, double grade) {
        System.out.println("Over grade: " + grade);
        for (Student s : students) {
            if (s.getAvg() > grade) System.out.println(s);
        }

    }

    public static void printStudentsUnderAge(List<Student> students, int age) {
        System.out.println("Under age: " + age);
        for (Student s : students) {
            if (s.getAge() < age) System.out.println(s);
        }
    }

    public static void printStudentsMixCondition(List<Student> students, int age, double avg, char gender) {

        System.out.println("Gender: " + gender + ". Age >= " + age + ". Avg >= " + avg);

        for (Student s : students) {
            if (s.getAge() >= age && s.getAvg() >= avg && s.getGender() == gender) System.out.println(s);
        }
    }

}

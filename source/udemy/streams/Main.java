package udemy.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("World");
        data.add("ABCDEFG");
        data.add("Some string");

        System.out.println(data);

//        for (int i = 0; i < data.size(); i++)
//            data.set(i, String.valueOf(data.get(i).length()));
//        System.out.println(data);

        List<Integer> replaced = data.stream().map(el -> el.length()).collect(Collectors.toList());
        System.out.println(replaced);

        Student s1 = new Student("Maksymmmmmm", 'M', 1, 17, 4.99);
        Student s2 = new Student("Mariia", 'F', 2, 19, 4.41);
        Student s3 = new Student("Bohdan", 'M', 1, 18, 3.59);
        Student s4 = new Student("Ala", 'F', 2, 20, 4.58);
        Student s5 = new Student("Artem", 'M', 3, 18, 4.20);
        Student s6 = new Student("Ktos", 'F', 2, 20, 4.91);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        System.out.println(students);

        students.stream().forEach(Student::printNameAndGender);
        List<Student> filtered = students.stream().filter(element -> element.getAge() >= 20 && element.getAverageGrade() >= 4.5).collect(Collectors.toList());
        System.out.println(filtered);

        Stream<Student> studentStream = Stream.of(s1, s2, s3, s4, s5);
        List<Student> men = studentStream.filter(st -> st.getSex() == 'M').collect(Collectors.toList());
        System.out.println(men);
        System.out.println();
        System.out.println();


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        int result = integers.stream().reduce((accumulator, element) -> accumulator * element).get(); // returns Optional<T> !!!
        System.out.println(result);

        int[] array = {3, 11, 5, 9, 0, 13};
        System.out.println(Arrays.toString(array));
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

        List<Student> sortedStudents = men.stream().sorted((st1, st2) -> Double.compare(st2.getAverageGrade(), st1.getAverageGrade())).collect(Collectors.toList());
        System.out.println(sortedStudents);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int res = Arrays.stream(arr)
                .filter(i -> i % 2 != 0) // 1 3 5 7 9
                .map(el -> el % 3 == 0 ? el / 3 : el) // 1 1 5 7 3
                .reduce(0, (acc, el) -> acc + el); // 17


        System.out.println("Result -> " + res);

        Stream<Student> stream = Stream.of(s1, s2, s3, s4, s5, s6);
        List<Student> studentList = stream
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .filter(student -> student.getSex() == 'F')
                .sorted((st1, st2) -> Double.compare(st1.getAverageGrade(), st2.getAverageGrade()))
                .collect(Collectors.toList());

        System.out.println(studentList);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Stream<Integer> stream1 = Stream.of(5, 3, 9, 12, 30, 25, 14);
        Stream<Integer> stream2 = Stream.of(8, 19, 15, 23, 91, 15);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2);

        List<Integer> listSorted = stream3.sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(listSorted);
        Stream<Integer> stream4 = Stream.of(1, 3, 5, 5, 10, 10, 2, 6);
        List<Integer> removedDuplicates = stream4.distinct().sorted().collect(Collectors.toList());
        System.out.println(removedDuplicates);

        // WE CANNOT REUSE STREAM
//        System.out.println(stream4.count());

        List<Integer> nums = List.of(-1, 1, 3, 40, 10, 9, -3, -22, -39, -3, -11);
        nums = nums.stream().filter(n -> n < 0).collect(Collectors.toList());
        System.out.println(nums);
        long negative = nums.stream().filter(n -> n < 0).count();
        System.out.println(negative);
        System.out.println();
        System.out.println();
        System.out.println();


        Stream<Student> studentStream1 = Stream.of(s1, s2, s3, s4, s5, s6);
        Faculty faculty1 = new Faculty("Computer Science");
        faculty1.addStudent(s1);
        faculty1.addStudent(s3);
        faculty1.addStudent(s5);
        Faculty faculty2 = new Faculty("Economics");
        faculty2.addStudent(s2);
        faculty2.addStudent(s4);
        faculty2.addStudent(s6);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);
        faculties.add(faculty2);
        faculties.stream()
                .flatMap(
                        faculty -> faculty.getStudents()
                                .stream().map(student -> {
                                    student.setName(student.getName().toUpperCase());
                                    return student;
                                })
                ).forEach(s -> System.out.println(s.getName()));

        System.out.println(faculties);
        System.out.println(s1);
        System.out.println();
        System.out.println();
        System.out.println();

        Student std1 = new Student("test1", 'M', 3, 20, 4.67);
        Student std2 = new Student("fdsfdsfds", 'M', 1, 18, 3.91);
        Student std3 = new Student("fdsfdsfds", 'M', 2, 19, 4.00);
        Student std4 = new Student("aaaaaa", 'F', 1, 18, 4.81);
        Student std5 = new Student("bbbbbb", 'F', 3, 23, 3.41);
        Student std6 = new Student("vccxcxzcxzcxzcxz", 'M', 2, 22, 3.67);
        Student std7 = new Student("Ababababba", 'F', 3, 21, 4.21);
        List<Student> list = List.of(std1, std2, std3, std4, std5, std6, std7);

        Map<Integer, List<Student>> groupingByCourseStudents = list.stream()
                .map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                }).collect(Collectors.groupingBy(el -> el.getCourse()));

        System.out.println(groupingByCourseStudents.get(1));
        System.out.println(groupingByCourseStudents.get(2));
        System.out.println(groupingByCourseStudents.get(3));

        Map<Boolean, List<Student>> partitionedByGrade = students.stream().
                collect(Collectors.partitioningBy(el -> el.getAverageGrade() >= 4.5));

        for (Map.Entry<Boolean, List<Student>> entry : partitionedByGrade.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Student s = list.stream()
                .filter(student -> student.getSex() == 'F')
                .findFirst().get();
        System.out.println(s);


        Student minAgeStudent = list.stream().min((student1, student2) -> student1.getAge() - student2.getAge()).get();
        Student maxAgeStudent = list.stream().min((student1, student2) -> student2.getAge() - student1.getAge()).get();
        System.out.println(minAgeStudent);
        System.out.println(maxAgeStudent);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        list.stream().filter(student -> student.getAge() >= 20).forEach(System.out::println);
        System.out.println("---------------------------");
        list.stream().filter(student -> student.getAge() >= 20).limit(2).forEach(System.out::println);
        System.out.println("---------------------------");
        list.stream().filter(student -> student.getAge() >= 20).skip(2).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        List<Integer> courses = list.stream()
                .mapToInt(el -> el.getCourse())
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        List<Double> grades = list.stream()
                .mapToDouble(el -> el.getAverageGrade())
                .boxed()
                .collect(Collectors.toList());
        Double gradesSum = list.stream()
                .mapToDouble(el -> el.getAverageGrade())
                .reduce(Double::sum).getAsDouble();

        System.out.println(courses);
        System.out.println(grades);
        System.out.println(gradesSum);
    }

}

class Student implements Comparable<Student> {

    private String name;

    private char sex;

    private int course;

    private int age;

    private double averageGrade;

    public Student(String name, char sex, int course, int age, double averageGrade) {
        this.name = name;
        this.sex = sex;
        this.course = course;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public static void printNameAndGender(Student student) {
        if (student.getSex() == 'F') {
            System.out.println(student.getName() + " is women");
        } else {
            System.out.println(student.getName() + " is men");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", course=" + course +
                ", age=" + age +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int result = 0;
        if (this.name.length() > o.getName().length()) {
            result = 1;
        } else if (this.name.length() < o.getName().length())
            result = -1;

        return result;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

package gui.GUI_7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main15 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/maksymbilyk/Desktop/programming/PJAIT/JAVA1/source/gui/GUI_7/file.txt"));

            String data = "";

            while ((data = reader.readLine()) != null) {
                String[] splittedData = data.split(" ");
                students.add(new Student(splittedData[0], splittedData[1], Integer.parseInt(splittedData[2])));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        students.stream().filter(s -> s.getPoints() >= 50).forEach(System.out::print);
        System.out.println();
        students.stream().filter(s -> s.getPoints() >= 50).sorted(new StudentComparator()).forEach(System.out::println);

        Map<String, List<Student>> groupedByStudents = students.stream().collect(Collectors.groupingBy(s -> s.getGroup()));
        for (Map.Entry<String, List<Student>> entry : groupedByStudents.entrySet()) {
            System.out.println("{ " + entry.getKey() + " = " + entry.getValue() + " }");
        }
    }

}

class Student {

    private String name;
    private String group;
    private int points;

    public Student(String name, String group, int points) {
        this.name = name;
        this.group = group;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return points == student.points && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, points);
    }

    @Override
    public String toString() {
        return "[ " + this.group + " " + this.name + " " + this.points + " ]";
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getGroup().compareTo(o2.getGroup());
        if (result == 0) result = Integer.compare(o1.getPoints(), o2.getPoints());
        return result;
    }
}
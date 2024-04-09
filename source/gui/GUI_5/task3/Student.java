package gui.GUI_5.task3;

import java.util.Objects;

public class Student {

    private String firstName;

    private String lastName;

    private int birthdayYear;

    private int studentId;

    private Group studentGroup;

    private static int uniqueNumberCounter = 0;

    public Student(String firstName, String lastName, int birthdayYear) {
        uniqueNumberCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
        this.studentId = uniqueNumberCounter;
        this.studentGroup = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Group getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(Group studentGroup) {
        this.studentGroup = studentGroup;
    }

    public void removeFromGroup() {
        this.studentGroup = null;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "(" + this.studentId + ") " + this.firstName + " " + this.lastName + ", " + this.birthdayYear + " group ---> " + (this.getStudentGroup() != null ? this.getStudentGroup() : "not in group");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthdayYear == student.birthdayYear && studentId == student.studentId && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthdayYear, studentId, studentGroup);
    }
}

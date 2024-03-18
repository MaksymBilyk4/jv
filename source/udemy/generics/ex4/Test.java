package udemy.generics.ex4;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        SchoolChild schoolChild1 = new SchoolChild("Ivan", 12);
        SchoolChild schoolChild2 = new SchoolChild("Den", 13);

        Student student1 = new Student("Maksym", 17);
        Student student2 = new Student("Artem", 18);

        Employee employee1 = new Employee("Andrii", 40);
        Employee employee2 = new Employee("Alex", 34);

        Team<SchoolChild> schoolTeam1 = new Team<>("SchoolChildren -> First");
        Team<SchoolChild> schoolTeam2 = new Team<>("SchoolChildren -> Second");
        schoolTeam1.addNewParticipant(schoolChild1);
        schoolTeam1.addNewParticipant(schoolChild2);
        schoolTeam2.addNewParticipant(new SchoolChild("ABC", 12));
        schoolTeam2.addNewParticipant(new SchoolChild("DEF", 13));


        // schoolTeam.addNewParticipant(student1); // error because of generics

        Team<Student > studentTeam = new Team<>("StudentTeam");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("EmployeeTeam");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolTeam1.playWith(schoolTeam2);

    }

}

package udemy.comparators.model;

public class Employee implements Comparable<Employee>{

    private static int EMPLOYEE_ID_COUNTER = 0;

    private int id;
    private String name;
    private String surname;
    private int salary;

    public Employee(String name, String surname, int salary) {
        EMPLOYEE_ID_COUNTER++;

        this.id = EMPLOYEE_ID_COUNTER;

        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getId() - employee.getId();
    }
}

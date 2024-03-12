package udemy.comparators;

import udemy.comparators.comp.EmployeeSalaryComparator;
import udemy.comparators.comp.EmployerFullNameComparator;
import udemy.comparators.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class COMP {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        fruits.add("Watermelon");
        fruits.add("Melon");
        fruits.add("Apple");
        fruits.add("Banana");

        System.out.println("BEFORE sort [fruits]: ");
        System.out.println(fruits);
        Collections.sort(fruits);
        System.out.println("AFTER sort [fruits]: ");
        System.out.println(fruits);


        List<Employee> employees = new ArrayList<>();
        Employee m = new Employee("Maksym", "Bilyk", 999999);
        Employee u = new Employee("Unknown", "Employee", 333);
        Employee r = new Employee("Random", "Object", 666);
        employees.add(r);
        employees.add(m);
        employees.add(u);

        System.out.println();

        System.out.println("Before sorting [Employees - id]: ");
        System.out.println(employees);
        Collections.sort(employees);
        System.out.println("After sorting [Employees - id]: ");
        System.out.println(employees);


        System.out.println();
        System.out.println("Sorted by salary: ");
        Collections.sort(employees, new EmployeeSalaryComparator());
        System.out.println(employees);

        System.out.println();
        System.out.println("Sorted by full name: ");
        Collections.sort(employees, new EmployerFullNameComparator());
        System.out.println(employees);

    }

}

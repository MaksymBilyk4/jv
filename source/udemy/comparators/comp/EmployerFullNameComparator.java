package udemy.comparators.comp;

import udemy.comparators.model.Employee;

import java.util.Comparator;

public class EmployerFullNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {

        int compareResult =  e1.getName().compareTo(e2.getName());
        return compareResult != 0 ? compareResult : e1.getSurname().compareTo(e2.getSurname());
    }
}

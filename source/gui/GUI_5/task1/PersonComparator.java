package gui.GUI_5.task1;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    private PersonSortCriteria sortBy;

    public PersonComparator(PersonSortCriteria personSortCriteria) {
        this.sortBy = personSortCriteria;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return this.sortBy == PersonSortCriteria.BY_NAME ? o1.getName().compareTo(o2.getName()) : Integer.compare(o1.getAge(), o2.getAge());
    }
}

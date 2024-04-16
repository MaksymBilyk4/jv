package gui.GUI_6;

import java.util.Collection;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public static boolean inCollection(Collection<Person> collection, String name, int birthYear) {
        return collection.contains(new Person(name, birthYear));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear);
    }

    @Override
    public int compareTo(Person o) {
        int result = this.birthYear - o.getBirthYear();
        if (result == 0) {
            result = this.name.compareTo(o.getName());
        }
        return result;
    }
}

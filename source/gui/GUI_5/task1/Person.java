package gui.GUI_5.task1;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "( " + this.name + ", " + this.age + " )";
    }

    @Override
    public int compareTo(Person person) {
        int comparison = this.name.compareTo(person.getName());

        if (comparison == 0) {
            comparison = Integer.compare(this.age, person.getAge());
        }

        return comparison;
    }
}

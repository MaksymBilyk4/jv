package gui.GUI_6;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Person> lista = Arrays.asList(
                new Person("Anna", 2000),
                new Person("Bartek", 2001),
                new Person("Maria", 2002)
        );
        System.out.println(Person.inCollection(lista, "Bartek", 2001));
        System.out.println(Person.inCollection(lista, "Daria", 2001));
        Set<Person> tZbior = new TreeSet<>(lista);
        System.out.println(Person.inCollection(tZbior, "Bartek", 2001));
        System.out.println(Person.inCollection(tZbior, "Daria", 2001));
        Set<Person> hZbior = new HashSet<>(lista);
        System.out.println(Person.inCollection(hZbior, "Bartek", 2001));
        System.out.println(Person.inCollection(hZbior, "Daria", 2001));

    }

}

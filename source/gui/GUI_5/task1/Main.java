package gui.GUI_5.task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> lista = Arrays.asList(
                new Person("Anna", 23),
                new Person("Maria", 22),
                new Person("Anna", 20),
                new Person("Wojciech", 21)
        );
        // sortowanie według podanego komparatora (po imię)
        Collections.sort(lista, new PersonComparator(PersonSortCriteria.BY_NAME));
        System.out.println(lista);

        // sortowanie według podanego komparatora (po wieku)
        Collections.sort(lista, new PersonComparator(PersonSortCriteria.BY_AGE));

        // lub zamiast komparatora "po wieku" napisać wyrażenie lambda w miejscu /* ... */
        Collections.sort(lista, new PersonComparator(PersonSortCriteria.BY_AGE));
        System.out.println(lista);

        // sortowanie według porządku naturalnego określonego w klasie Osoba
        Collections.sort(lista);
        System.out.println(lista);
    }

}

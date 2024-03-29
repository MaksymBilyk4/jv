package udemy.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(10);

        list.add("Maksym");
        list.add("Bohdan");
        list.add(0, "Alex");
        System.out.println(list);

        list.set(0, "Bla bla bla");
        System.out.println(list);

        list.remove(0);
        list.remove(list.get(0));
        System.out.println(list);

        list.addAll(0, List.of("Hello", "World"));
        System.out.println(list);

        list.clear();

        System.out.println(list);
        list.add("Hello");
        list.add("Java");
        list.add("World");
        list.add("Test");
        list.add("Java");

        System.out.println(list.indexOf("Java"));
        System.out.println(list.lastIndexOf("Java"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("Test"));

        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] sbs = new StringBuilder[]{sb1, sb2, sb3, sb4};
        List<StringBuilder> builders = Arrays.asList(sbs); // length immutable
        System.out.println(builders);
        sb1.append("CDE");
        System.out.println(Arrays.toString(sbs));
        System.out.println(builders);

        List<String> strings = new ArrayList<>();
        strings.add("Java");
        strings.add("JavaScript");
        strings.add("C++");
        strings.add("C#");
        strings.add("Kotlin");
        strings.add("React");

        System.out.println(strings);
        strings.removeAll(List.of("React", "JavaScript"));

        System.out.println(strings);
        strings.retainAll(List.of("Java", "C++", "Objective-C"));
        System.out.println(strings);

        strings.add("Python");
        strings.add("C#");
        System.out.println(strings);

        System.out.println(
                strings.containsAll(List.of("Python", "Java", "C++"))
        );

//        List<String> subStrings = strings.subList(0,2);
//        System.out.println(subStrings);

        Object[] objects = strings.toArray();
        String[] objects1 = strings.toArray(new String[0]);
        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects1));

        List<Integer> ints = List.of(1,2,3); // !!!! IMMUTABLE

    }

}

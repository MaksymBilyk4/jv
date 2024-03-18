package udemy.lambda.test_predicate;


import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("!!!!");
        strings.add("String");
        strings.add("Cat");
        strings.add("Maksym");
        strings.add("Java");

        System.out.println(strings);

        strings.removeIf(str -> str.length() < 5);
        System.out.println(strings);


    }

}

package udemy.collection;

import java.util.*;

public class Iterators {

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("World");
        data.add("Java");
        data.add("C++");

        Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(isPalindrome("dataatad"));

    }

    public static boolean isPalindrome (String s) {

        List<Character> characters = new LinkedList<>();
        for (char ch : s.toCharArray())
            characters.add(ch);


        ListIterator<Character> begin = characters.listIterator();
        ListIterator<Character> end = characters.listIterator(characters.size());
        boolean isPalindrome = true;

        while (begin.hasNext()  && end.hasPrevious()) {

            if (begin.next() != end.previous()) {
                isPalindrome = false;
                break;
            }

        }

        return isPalindrome;

    }

}

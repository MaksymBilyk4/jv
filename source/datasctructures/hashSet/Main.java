package datasctructures.hashSet;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("1");
        stringHashSet.add("2");
        stringHashSet.add("3");
        stringHashSet.add("4");
        stringHashSet.add("5");
        stringHashSet.add("6");
        stringHashSet.add("7");
        stringHashSet.add("8");
        stringHashSet.add("10");
        stringHashSet.add("8");
        stringHashSet.add("8");
        stringHashSet.add("11");
        stringHashSet.add("12");

        stringHashSet.displaySet();
        System.out.println(stringHashSet.size());
        System.out.println(Arrays.toString(stringHashSet.getBuckets()));

        stringHashSet.clear();
        System.out.println(stringHashSet.size());
        System.out.println(Arrays.toString(stringHashSet.getBuckets()));

        stringHashSet.add("hell");
        stringHashSet.add("wdsas");
        stringHashSet.add("dsadsa");
        stringHashSet.add("aa");
        stringHashSet.add("world");
        stringHashSet.add("hello");

        System.out.println(Arrays.toString(stringHashSet.getBuckets()));
        stringHashSet.displaySet();
        System.out.println(stringHashSet.contains("aa"));
        System.out.println(stringHashSet.contains("ala"));
        System.out.println(stringHashSet.contains("hello"));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(stringHashSet.getBuckets()));

        System.out.println(stringHashSet.remove("hello"));
        System.out.println(stringHashSet.remove("world"));
        System.out.println(stringHashSet.remove("dsadsa"));
        System.out.println(stringHashSet.remove("fdsfdsfdsfsdfsd"));
        System.out.println(Arrays.toString(stringHashSet.getBuckets()));
    }

}

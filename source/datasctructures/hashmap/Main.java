package datasctructures.hashmap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("HashMap<String, Integer>:");
//
//            System.out.print("Input key: ");
//            String key = scanner.next();
//
//            System.out.print("Input value: ");
//            int value = scanner.nextInt();
//
//            map.put(key, value);
//            map.displayMap();
//            System.out.println(Arrays.toString(map.getBuckets()));
//        }

        map.put("Hello", 1);
        map.put("World", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);

        System.out.println(map.size());
//        System.out.println(map.isEmpty());
        System.out.println(Arrays.toString(map.getBuckets()));
//        map.displayMap();
//        System.out.println(map.get("F"));
//        System.out.println(map.get("f"));
//        System.out.println(map.contains("F"));
//        System.out.println(map.contains("f"));
        System.out.println(map.remove("Hello"));
        System.out.println(map.remove("World"));
        System.out.println(map.remove("F"));
        System.out.println(Arrays.toString(map.getBuckets()));
        System.out.println(map.size());
    }

}

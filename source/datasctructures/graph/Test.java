package datasctructures.graph;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        HashMap<String, List<String>> map = new HashMap<>();


        List<String> myFriends = List.of("Bohdan", "Dollar", "Bartek");
        map.put("Maksym", myFriends);

        List<String> bohdanFriends = List.of("Oleksandr", "Nikita");
        map.put("Bohdan", bohdanFriends);

        List<String> dollarFriends = List.of("Arek");
        List<String> bartekFriends = List.of("Sarah");

        map.put("Dollar", dollarFriends);
        map.put("Bartek", bartekFriends);

        map.put("Arek", List.of());
        map.put("Sarah", List.of());

        Deque<String> deque = new ArrayDeque<>(map.get("Maksym"));
        Set<String> visited = new HashSet<>();

        while (!deque.isEmpty()) {
            String firstPerson = deque.removeFirst();
            if (!visited.contains(firstPerson)) {

                if (isSearched(firstPerson)) {
                    System.out.println(firstPerson + " is a searched person");
                    break;
                } else {
                    visited.add(firstPerson);
                    if (map.get(firstPerson) != null) {
                        deque.addAll(map.get(firstPerson));
                    }
                }
            }
        }

    }

    public static boolean isSearched(String name) {
        return Objects.equals(name, "Arek");
    }

}

class WakeUp {
    public static void main(String[] args) {

        HashMap<String, List<String>> routine = new HashMap<>();

        routine.put("root", List.of("WakeUp"));
        routine.put("WakeUp", List.of("Shower", "Teeth"));
        routine.put("Teeth", List.of("Eat breakfast", "Drink coffee"));

        Deque<String> deque = new ArrayDeque<>(routine.get("root"));
        Set<String> visited = new HashSet<>();

        while (!deque.isEmpty()) {
            String task = deque.removeFirst();
            if (!visited.contains(task)) {
                System.out.println(task);
                if (routine.get(task) != null) {
                    deque.addAll(routine.get(task));
                    visited.add(task);
                }
            }
        }

    }
}
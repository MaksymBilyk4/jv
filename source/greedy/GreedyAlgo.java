package greedy;

import java.util.*;

public class GreedyAlgo {


    public static void main(String[] args) {
        Lesson art = new Lesson("Art", 9.00, 10.00);
        Lesson eng = new Lesson("Eng", 9.5, 10.5);
        Lesson math = new Lesson("Math", 10.00, 11.00);
        Lesson cs = new Lesson("CS", 10.3, 11.5);
        Lesson music = new Lesson("Music", 11.00, 12.00);
        List<Lesson> lessons = Arrays.asList(eng, cs, math, music, art);

        System.out.println(schedule(lessons));


        HashMap<String, HashSet<String>> radioAndState = new HashMap<>();

        // A B C D E
        radioAndState.put("radio2", new HashSet<>(Set.of("B", "C")));
        radioAndState.put("radio1", new HashSet<>(Set.of("A", "B")));
        radioAndState.put("radio3", new HashSet<>(Set.of("C", "D", "E")));
        radioAndState.put("radio4", new HashSet<>(Set.of("D", "A")));
        radioAndState.put("radio5", new HashSet<>(Set.of("E", "B")));

        System.out.println(findOptimalStation(radioAndState));

    }

    private static HashSet<String> findOptimalStation(HashMap<String, HashSet<String>> radioAndStates) {
        HashSet<String> statesNeeded = new HashSet<>();
        for (HashSet<String> states : radioAndStates.values()) {
            statesNeeded.addAll(states);
        } // All states to cover

        HashSet<String> selectedStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            HashSet<String> statesCoveredByBest = new HashSet<>();

            // radio : states
            for (Map.Entry<String, HashSet<String>> station : radioAndStates.entrySet()) {
                HashSet<String> coveredStates = new HashSet<>(station.getValue()); // current station's states that it covers
                coveredStates.retainAll(statesNeeded); // states that are not covered

                // if uncovered states size bigger then previous uncovered states, that means that current station covers more stations that previous chosen one
                if (coveredStates.size() > statesCoveredByBest.size()) {
                    bestStation = station.getKey(); // set best station name
                    statesCoveredByBest = coveredStates; // write set of states
                }

            }

            statesNeeded.removeAll(statesCoveredByBest); // remove from needed states previously selected states
            selectedStations.add(bestStation); // add station's name
        }

        return selectedStations;

    }

    private static List<Lesson> schedule(List<Lesson> lessons) {
        List<Lesson> scheduled = new ArrayList<>();
        Collections.sort(lessons);

        Lesson currentLesson = lessons.getFirst();
        scheduled.add(currentLesson);

        for (int i = 1; i < lessons.size(); i++) {
            if (lessons.get(i).starts >= currentLesson.ends) {
                currentLesson = lessons.get(i);
                scheduled.add(currentLesson);
            }
        }


        return scheduled;
    }

}

class Lesson implements Comparable<Lesson> {

    String lessonName;
    Double starts;
    Double ends;

    public Lesson(String lessonName, Double starts, Double ends) {
        this.lessonName = lessonName;
        this.starts = starts;
        this.ends = ends;
    }

    @Override
    public int compareTo(Lesson o) {
        return Double.compare(starts, o.starts);
    }

    @Override
    public String toString() {
        return lessonName + " " + starts + " " + ends;
    }
}
package udemy.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {

        List<Double> doubles = new ArrayList<>();
        doubles.add(10.0);
        doubles.add(5.00);
        doubles.add(1.00);
        doubles.add(0.25);

        double sumResult = doubles.stream().reduce((acc, el) -> acc + el).get();
        double sumResultP = doubles.parallelStream().reduce((acc, el) -> acc + el).get();
        System.out.println("Sum result: " + sumResult);
        System.out.println("Sum result: " + sumResultP);

        double divisionResult = doubles.stream()
                .reduce((acc, el) -> acc / el).get();
        double divisionResultP = doubles.parallelStream()
                .reduce((acc, el) -> acc / el).get();

        System.out.println("Division result: " + divisionResult);
        System.out.println("Division result: " + divisionResultP); // incorrect

    }

}

package udemy.generics.ex3;

import java.util.ArrayList;
import java.util.List;


// <?> - wild card
// lists that are using wildcards, then they are immutable
public class Main {

    public static void main(String[] args) {

        // List<Number> numbers = new ArrayList<Integer>(); ---> error
        List<?> strings = new ArrayList<>(); // works
//        strings.add("Hello"); can't do it because of list's type <?>

//        List<? extends Number> numbers = new ArrayList<>();

        List<Double> doubles = List.of(3.14, 2.14, 3.33);
        List<Integer> ints = List.of(3, 6, 9);

        showListInfo(doubles);
        showListInfo(ints);

        double dSum = sum(doubles);
        double iSum = sum(ints);

        System.out.println(dSum);
        System.out.println(iSum);

        // =====================================================================================
        List<? extends Number> l1 = new ArrayList<>(); // classes under Number
        List<? super Number> l2 = new ArrayList<>(); // classes ABOVE Number

    }

    static void showListInfo(List<?> list) {
        System.out.println("Your list -> " + list);
    }

    static double sum(List<? extends Number> numbers) {
        double[] sum = new double[]{0};
        numbers.forEach(f ->
                sum[0] += f.doubleValue()
        );

        return sum[0];
    }

}

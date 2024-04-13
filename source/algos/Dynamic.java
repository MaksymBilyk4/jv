package algos;

import java.lang.reflect.Array;
import java.util.*;

public class Dynamic {

    public static void main(String[] args) {
        List<Product> items = new ArrayList<>();
        items.add(new Product("Laptop", 2000, 3));
        items.add(new Product("Guitar", 1500, 1));
        items.add(new Product("Stereo", 3000, 4));
        items.add(new Product("I-Phone", 2000, 1));
        System.out.println(items);
        System.out.println();
        System.out.println(knapsackProblem(items, 4));
    }

    public static List<Product> knapsackProblem(List<Product> items, int knapsackWeight) {
        int[][] prices = new int[items.size() + 1][knapsackWeight + 1];

        for (int i = 1; i < prices.length; i++) {
            Product currentProductToSteal = items.get(i - 1);
            for (int weight = 1; weight < prices[i].length; weight++) {
                if (currentProductToSteal.weight > weight) {
                    prices[i][weight] = prices[i - 1][weight];
                } else {
                    int spaceLeft = weight - currentProductToSteal.weight;
                    if (spaceLeft >= 0) {
                        prices[i][weight] = Math.max(prices[i - 1][weight], currentProductToSteal.price + prices[i - 1][spaceLeft]);
                    } else prices[i][weight] = Math.max(prices[i - 1][weight], currentProductToSteal.price);
                }
            }
        }

        printMatrix(prices);
        List<Product> itemsToSteal = new ArrayList<>();
        int i = prices.length - 1, weight = knapsackWeight;

        while (i > 0 && knapsackWeight > 0) {
            Product candidate = items.get(i - 1);
            if (prices[i][weight] != prices[i - 1][weight]) {
                itemsToSteal.addFirst(candidate);
                weight -= candidate.weight;
            }
            i--;
        }

        return itemsToSteal;
    }

    // GPT
//    public static void knapsackProblem(List<Product> items, int knapsackWeight) {
//        int[][] dp = new int[items.size() + 1][knapsackWeight + 1];
//
//        for (int i = 1; i <= items.size(); i++) {
//            Product item = items.get(i - 1);
//            for (int w = 1; w <= knapsackWeight; w++) {
//                if (item.weight <= w) {
//                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - item.weight] + item.price);
//                } else {
//                    dp[i][w] = dp[i-1][w];
//                }
//            }
//        }
//        printMatrix(dp);
//
//        System.out.println("Max value: " + dp[items.size()][knapsackWeight]);
//        printSelectedItems(dp, items, knapsackWeight);
//
//    }

//    public static void printSelectedItems(int[][] dp, List<Product> items, int weight) {
//        int i = items.size();
//        while (i > 0 && weight > 0) {
//            Product item = items.get(i - 1);
//            if (dp[i][weight] != dp[i-1][weight]) {
//                System.out.println(item);
//                weight -= item.weight;
//            }
//            i--;
//        }
//    }

//    public static void knapsackProblem(List<Product> items, int knapsackWeight) {
//        Product[][] products = new Product[items.size()][knapsackWeight];
//
//        printMatrix(products);
//
//        for (int i = 0; i < products.length; i++) { // row
//            for (int j = 0; j < products[i].length; j++) { // column - capacity of knapsack
//                for (int k = 0; k <= i; k++) {
//                    if (items.get(k).weight <= (j + 1)) products[i][j] = (items.get(k));
//                }
//            }
//        }
//
//        System.out.println();
//        printMatrix(products);
//
//    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix)
            System.out.println(Arrays.toString(arr));

    }

}

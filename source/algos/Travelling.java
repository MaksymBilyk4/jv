package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Travelling {

    public static void main(String[] args) {
        Attraction pv1 = new Attraction("Westminster Abbey", 0.5, 7);
        Attraction pv2 = new Attraction("Globe Theater", 0.5, 6);
        Attraction pv3 = new Attraction("National Gallery", 1, 9);
        Attraction pv4 = new Attraction("British Museum", 2, 9);
        Attraction pv5 = new Attraction("St. Paul's Cathedral", 0.5, 8);
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(pv1);
        attractions.add(pv2);
        attractions.add(pv3);
        attractions.add(pv4);
        attractions.add(pv5);
        bestVisitingProgram(attractions, 2.00);
    }

    public static void bestVisitingProgram(List<Attraction> attractions, double dayLimit) {
        HashSet<Double> uniqueDaysTake = new HashSet<>();
        for (double time = dayLimit; time > 0; ) {
            uniqueDaysTake.add(time);
            time -= 0.5;
        }

        // 0.5     1      1.5      2

        int[][] dp = new int[attractions.size() + 1][uniqueDaysTake.size() + 1];
        printMatrix(dp);

        for (int i = 1; i < dp.length; i++) {
            for (int d = 1; d < dp[i].length; d++) {
                Attraction candidate = attractions.get(i - 1);

                double currentTimeWeight = d / 2.00; //    0.5    1    1.5   2

                if (candidate.takesDays <= currentTimeWeight) { // 0.5
                    int remainingIndex = (int) ((currentTimeWeight - candidate.takesDays) * 2);
                    if (remainingIndex >= 0) {
                        dp[i][d] = Math.max(dp[i - 1][d], candidate.rate + dp[i - 1][remainingIndex]);
                    } else dp[i][d] = Math.max(dp[i - 1][d], candidate.rate);

                } else dp[i][d] = dp[i - 1][d];

            }
        }

        System.out.println();
        printMatrix(dp);

    }

    private static void printMatrix(int[][] mat) {
        for (int[] entry : mat)
            System.out.println(Arrays.toString(entry));
    }


}

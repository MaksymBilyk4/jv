package algos;

import java.util.Arrays;

public class Subtring {

    public static void main(String[] args) {
        calculateSubstrings("blue", "clues");
    }

    public static void calculateSubstrings(String str1, String str2) {
        char[][] substrings = new char[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < substrings.length;i++)
            for (int j = 0; j < substrings[i].length; j++)
                substrings[i][j] = '0';


        for (int i = 1; i <= str1.length(); i++)
            substrings[i][0] = str1.charAt(i - 1);

        for (int i = 1; i <= str2.length(); i++)
            substrings[0][i] = str2.charAt(i - 1);

//        printMatrix(substrings);
        for (int i = 1; i < substrings.length; i++) {
            for (int j = 1; j < substrings[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    substrings[i][j] = (char) (substrings[i - 1][j - 1] + 1);
            }
        }
        printMatrix(substrings);


    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix)
            System.out.println(Arrays.toString(arr));

    }

}

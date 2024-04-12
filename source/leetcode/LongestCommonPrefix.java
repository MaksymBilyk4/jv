package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// #14
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] words = {"flower", "apple", "banana", "flow"};
        String res1 = longestCommonPrefix(words);
        System.out.println("Max prefix -> " + res1);
        System.out.println("Max prefix -> " + longestCommonPrefixImproved(words));
    }

    public static String longestCommonPrefixImproved(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        String prefix = arr[0];

        for(String s : arr){
            int len = Math.min(s.length(), prefix.length());

            for(int i = len; i >= 0;i--){
                if(!s.substring(0, i).isEmpty() && prefix.indexOf(s.substring(0,i)) == 0){
                    prefix = s.substring(0,i);
                    break;
                }
            }

        }

        return prefix;
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) return ""; // no items to check
        if (arr.length == 1) return arr[0]; // if only one item in array, that is prefixed

        HashMap<String, Integer> foundPrefix = new HashMap<>(); // "prefix" : count

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String prefix = getPrefix(arr[i], arr[j]); // try to find prefix with every pair of word, with no duplicates
                if (!foundPrefix.containsKey(prefix)) // if we found it previously no sens to rewrite it
                    foundPrefix.put(prefix, 0);

            }
        }

        // if we did not find anything
        if (foundPrefix.isEmpty()) return "";

        foundPrefix.remove("");
        // go through every prefix
        for (String prefix : foundPrefix.keySet()) {
            for (String word : arr)
                if (word.startsWith(prefix)) // if word has current prefix increment its count in map
                    foundPrefix.put(prefix, foundPrefix.get(prefix) + 1);


        }

        // find the most common prefix
        StringBuilder maxPrefix = new StringBuilder();
        int currentMax = 0;
        for (Map.Entry<String, Integer> entry : foundPrefix.entrySet()) {
            if (entry.getValue() > currentMax) {
                currentMax = entry.getValue();
                maxPrefix.replace(0, maxPrefix.toString().length(), entry.getKey());
            }
        }

        return maxPrefix.toString();
    }

    // method to find common prefix between two strings
    private static String getPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // go until min word's size and characters will be equal
        while (i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i)) {
            sb.append(s1.charAt(i));
            i++;
        }

        return sb.toString();
    }

}



package leetcode;


import java.util.Arrays;
import java.util.HashMap;

//242. Valid Anagram
public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram2("anagram", "nagaram"));
    }


    // #1
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), 1);
            else
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);

            if (!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), 1);
            else
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
        }

        return map1.equals(map2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}

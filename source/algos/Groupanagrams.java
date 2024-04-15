package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// # 49 Group Anagrams
public class Groupanagrams {

    public static void main(String[] args) {

        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(arr);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String s : strs) {

            char[] stringArray = s.toCharArray();
            Arrays.sort(stringArray);
            String key = Arrays.toString(stringArray);

            if (groupedAnagrams.containsKey(key)) {
                groupedAnagrams.get(key).add(s);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                groupedAnagrams.put(key, anagrams);
            }

        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : groupedAnagrams.values())
            result.add(list);

        return result;
    }


}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//#1 Two Sum
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                indexes[1] = i;
                indexes[0] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }

        return indexes;
    }

}

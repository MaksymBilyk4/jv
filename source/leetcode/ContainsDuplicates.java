package leetcode;

import java.util.Arrays;

// 217. Contains Duplicate
public class ContainsDuplicates {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(arr1));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }

        return false;
    }

}

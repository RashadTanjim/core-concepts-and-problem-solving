package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

//public int[] twoSum(int[] nums, int target) {
//    // Time: O(n), Space: O(1)
//
//    for (int i = 1; i < nums.length; i++) {
//
//        for (int j = i; j < nums.length; j++) {
//
//            if (nums[j] + nums[j - i] == target) {
//                return new int[] { j - i, j };
//            }
//        }
//    }
//
//    return new int[] {};
//}
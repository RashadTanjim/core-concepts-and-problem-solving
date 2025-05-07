package leetcode;

import java.util.*;

public class Solution31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;

        // Step 1: Find first decreasing element from end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find just larger element to the right
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap
            swap(nums, i, j);
        }

        // Step 4: Reverse suffix starting from i+1
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Test
    public static void main(String[] args) {
        Solution31 solver = new Solution31();
        int[] nums = {1, 2, 3, 6, 5, 4};
        solver.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 4, 3, 5, 6]
    }
}

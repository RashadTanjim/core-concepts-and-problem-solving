package leetcode;

import java.util.Arrays;

public class Solution416 {

    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;   // Check if total is odd
        int target = total / 2;

        boolean[] dp = new boolean[target + 1]; // DP array to track achievable sums
        dp[0] = true;

        for (int num : nums) {  // Iterate through each number
            for (int i = target; i >= num; i--) {   // Update DP array in reverse order
                dp[i] |= dp[i - num];   // If we can achieve sum i - num, then we can achieve sum i
            }
        }

        return dp[target];  // Return whether we can achieve the target sum
    }

    public static void main(String[] args) {
        Solution416 solver = new Solution416();

        int[] nums1 = {1, 5, 11, 5};
        System.out.println(solver.canPartition(nums1)); // true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solver.canPartition(nums2)); // false
    }
}

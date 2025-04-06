package leetcode;

public class Solution198 {

    public int rob(int[] nums) {     // Optimized DP Approach
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0, prev1 = 0;
        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Solution198 solution = new Solution198();
        int[] nums = {2, 7, 9, 3, 1};

        // Maximum money that can be robbed: 12 (2 + 9 + 1 = 12)
        System.out.println("Maximum money that can be robbed: " + solution.rob(nums));
    }
}

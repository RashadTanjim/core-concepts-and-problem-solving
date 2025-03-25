package leetcode;

public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums); // Case 1: Max sum without wrapping

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; // Invert numbers to find the min subarray sum
        }

        int minKadane = kadane(nums); // Case 2: Min subarray sum
        int maxCircular = totalSum + minKadane; // Circular max subarray

        // Edge case: If all numbers are negative, return maxKadane
        if (maxCircular == 0) return maxKadane;

        return Math.max(maxKadane, maxCircular);
    }

    private int kadane(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for (int num : nums) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution918 solution = new Solution918();

        int[] nums1 = {1, -2, 3, -2};
        System.out.println(solution.maxSubarraySumCircular(nums1)); // Output: 3

        int[] nums2 = {5, -3, 5};
        System.out.println(solution.maxSubarraySumCircular(nums2)); // Output: 10

        int[] nums3 = {-3, -2, -3};
        System.out.println(solution.maxSubarraySumCircular(nums3)); // Output: -2
    }
}


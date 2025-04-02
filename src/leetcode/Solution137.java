package leetcode;

public class Solution137 {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;  // Add new number or remove it if seen twice
            twos = (twos ^ num) & ~ones;  // Track numbers that appear twice
        }

        return ones;  // Only the single number remains
    }

    public static void main(String[] args) {
        Solution137 sol = new Solution137();
        int[] nums = {2, 2, 3, 2};
        System.out.println("Single Number: " + sol.singleNumber(nums));  // Output: 3
    }
}

package leetcode;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;  // XOR all elements
        }

        return result;
    }

    public static void main(String[] args) {
        Solution136 sol = new Solution136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single Number: " + sol.singleNumber(nums));  // Output: 4
    }
}

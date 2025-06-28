package leetcode;

public class Solution303 {

    private final int[] prefixSum;

    public Solution303(int[] nums) {
        prefixSum = new int[nums.length + 1]; // Initialize prefixSum with size nums.length + 1
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution303 solution = new Solution303(nums);
        System.out.println(solution.sumRange(0, 2)); // Output: 1
        System.out.println(solution.sumRange(2, 5)); // Output: -1
        System.out.println(solution.sumRange(0, 5)); // Output: -3
    }
}

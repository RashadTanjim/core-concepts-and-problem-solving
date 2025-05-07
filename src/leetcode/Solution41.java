package leetcode;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Place nums[i] at its correct position if it's in [1, n]
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Find first index where the number is not i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution41 sol = new Solution41();
        int[] nums1 = {3, 4, -1, 1};
        int[] nums2 = {1, 2, 0};
        int[] nums3 = {7, 8, 9, 11, 12};

        System.out.println(sol.firstMissingPositive(nums1)); // 2
        System.out.println(sol.firstMissingPositive(nums2)); // 3
        System.out.println(sol.firstMissingPositive(nums3)); // 1
    }
}

package leetcode;

import java.util.Arrays;

public class Solution1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution1679 solver = new Solution1679();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solver.maxOperations(nums1, 5)); // 2

        int[] nums2 = {3, 1, 3, 4, 3};
        System.out.println(solver.maxOperations(nums2, 6)); // 1
    }
}

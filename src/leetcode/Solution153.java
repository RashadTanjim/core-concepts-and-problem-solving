package leetcode;

public class Solution153 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;  // Avoid overflow

            if (nums[mid] > nums[right]) {
                // The minimum must be in the right half
                left = mid + 1;
            } else {
                // The minimum must be in the left half (including mid)
                right = mid;
            }
        }

        return nums[left];  // The left index will point to the minimum element
    }

    public static void main(String[] args) {
        Solution153 solution = new Solution153();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums)); // Output: 1

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums)); // Output: 0
    }
}

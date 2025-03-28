package leetcode;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // Prevents overflow

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;  // Peak must be on the right
            } else {
                high = mid - 1;  // Peak must be on the left
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Solution162 solution = new Solution162();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak index: " + solution.findPeakElement(nums1)); // Expected: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak index: " + solution.findPeakElement(nums2)); // Expected: 1 or 5
    }
}

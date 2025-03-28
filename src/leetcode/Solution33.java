package leetcode;

public class Solution33 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // Prevents overflow

            if (nums[mid] == target) {
                return mid; // base case
            }

            // Determine the sorted half
            if (nums[low] <= nums[mid]) { // Left half is sorted

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }

            } else {  // Right half is sorted

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution = new Solution33();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums1, 0)); // Output: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums2, 3)); // Output: -1

        int[] nums3 = {1};
        System.out.println(solution.search(nums3, 0)); // Output: -1

        int[] nums4 = {3, 1};
        System.out.println(solution.search(nums4, 1)); // Output: 1
    }
}

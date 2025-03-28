package leetcode;

public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // Insert position
    }

    public static void main(String[] args) {
        Solution35 solution = new Solution35();

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums1, 5)); // Output: 2
        System.out.println(solution.searchInsert(nums1, 2)); // Output: 1
        System.out.println(solution.searchInsert(nums1, 7)); // Output: 4
        System.out.println(solution.searchInsert(nums1, 0)); // Output: 0
    }
}

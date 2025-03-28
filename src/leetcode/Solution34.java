package leetcode;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            // Check if we found the target
            if (nums[mid] == target) {
                // Find the first occurrence
                int left = mid;
                while (left - 1 >= low && nums[left - 1] == target) {
                    left--;
                }
                result[0] = left;

                // Find the last occurrence
                int right = mid;
                while (right + 1 <= high && nums[right + 1] == target) {
                    right++;
                }
                result[1] = right;
                break; // No need to continue once we've found both first and last occurrence
            }

            // Standard binary search logic
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution34 solution = new Solution34();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        printArray(solution.searchRange(nums1, 8)); // Output: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        printArray(solution.searchRange(nums2, 6)); // Output: [-1, -1]

        int[] nums3 = {};
        printArray(solution.searchRange(nums3, 0)); // Output: [-1, -1]

        int[] nums4 = {2, 2};
        printArray(solution.searchRange(nums4, 2)); // Output: [0, 1]
    }

    private static void printArray(int[] arr) {
        System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }

}
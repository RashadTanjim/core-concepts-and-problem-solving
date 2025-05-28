package leetcode;

public class Solution152 {

    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                // Swap currentMax and currentMin when a negative number is encountered
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]); // Calculate the maximum product ending at index i
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Solution152 solver = new Solution152();
        int[] nums1 = {2, 3, -2, 4};
        System.out.println(solver.maxProduct(nums1)); // Output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println(solver.maxProduct(nums2)); // Output: 0

        int[] nums3 = {-2, 3, -4};
        System.out.println(solver.maxProduct(nums3)); // Output: 24
    }
}

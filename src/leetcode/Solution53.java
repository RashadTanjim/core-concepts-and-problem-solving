package leetcode;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) currSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums));  // Output: 6
    }
}

//class Solution {
//    public int[] maxSubArray(int[] nums) {
//        int maxSum = Integer.MIN_VALUE;
//        int currSum = 0;
//        int start = 0, end = 0, tempStart = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            currSum += nums[i];
//
//            if (currSum > maxSum) {
//                maxSum = currSum;
//                start = tempStart;
//                end = i;
//            }
//
//            if (currSum < 0) {
//                currSum = 0;
//                tempStart = i + 1;
//            }
//        }
//
//        int[] result = new int[end - start + 1];
//        System.arraycopy(nums, start, result, 0, end - start + 1);
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//
//        int[] subarray = solution.maxSubArray(nums);
//        System.out.print("Maximum Subarray: ");
//        for (int num : subarray) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//    }
//}
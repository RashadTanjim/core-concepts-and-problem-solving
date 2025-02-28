package leetcode;

import java.util.*;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sorting the array (O(n log n))

        for (int i = 0; i < nums.length - 2; i++) { // Avoid unnecessary iterations
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for `i`

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--; // Reduce sum by moving `k` left
                } else if (sum < 0) {
                    j++; // Increase sum by moving `j` right
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move pointers to avoid duplicates
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++; // Skip duplicate `j`
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--; // Skip duplicate `k`
                    }

                    j++;
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 sol = new Solution15();
        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSum(new int[]{0, 1, 1}));             // []
        System.out.println(sol.threeSum(new int[]{0, 0, 0, 0}));          // [[0,0,0]]
    }
}

package leetcode;

import java.util.*;

public class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        // Sort descending by nums2 (so we treat it as the minimum in selection)
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxScore = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            int currNum1 = pairs[i][1];
            int currNum2 = pairs[i][0]; // This is the "min" we're trying

            sum += currNum1;
            minHeap.add(currNum1);

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * currNum2);
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution2542 sol = new Solution2542();
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;

        System.out.println("Max Score = " + sol.maxScore(nums1, nums2, k));  // Output: 12
    }
}

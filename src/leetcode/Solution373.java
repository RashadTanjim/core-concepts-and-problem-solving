package leetcode;

import java.util.*;

public class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: If either array is empty, return empty result
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        // Min-Heap to store (sum, i, j) where i is index in nums1 and j is index in nums2
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the heap with the first element of each row
        for (int i = 0; i < nums1.length; i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});  // Store (sum, i, j)
        }

        // Extract the k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1], j = current[2];

            // Add the current pair to the result
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums2 for the current i, push it to the heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});  // PriorityQueue is managing the smallest to poll 1st
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution373 sol = new Solution373();

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> result = sol.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}

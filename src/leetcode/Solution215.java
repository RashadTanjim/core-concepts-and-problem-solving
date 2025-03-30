package leetcode;

import java.util.*;

public class Solution215 {

    // --- Approach 1: Sorting ---
    public int findKthLargest_sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // --- Approach 2: Min-Heap ---
    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }

    // --- Approach 3: QuickSelect ---
    public int findKthLargest_quickSelect(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right)
            return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (kSmallest == pivotIndex)
            return nums[kSmallest];
        else if (kSmallest < pivotIndex)
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        else
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) {
        Solution215 sol = new Solution215();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

       // System.out.println("Sorting Approach: " + sol.findKthLargest_sorting(nums.clone(), k));
        System.out.println("Heap Approach: " + sol.findKthLargest_heap(nums.clone(), k));
       // System.out.println("QuickSelect Approach: " + sol.findKthLargest_quickSelect(nums.clone(), k));
    }
}

package leetcode;

import java.util.*;

public class Solution1438 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain maxDeque (decreasing)
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain minDeque (increasing)
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // Shrink window if invalid
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution1438 sol = new Solution1438();
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(sol.longestSubarray(nums, limit)); // Output: 2
    }
}

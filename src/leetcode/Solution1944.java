package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1944 {

    // Optimal O(n) using Monotonic Stack
    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }

            if (!stack.isEmpty()) count++; // taller or equal person
            res[i] = count;
            stack.push(heights[i]);
        }

        return res;
    }

    // Brute Force O(n^2)
    public static int[] canSeePersonsCountBruteForce(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                res[i]++;
                if (heights[j] >= heights[i]) break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};

        System.out.println("Optimal Stack Approach:");
        System.out.println(Arrays.toString(canSeePersonsCount(heights)));

        System.out.println("\nBrute Force Approach:");
        System.out.println(Arrays.toString(canSeePersonsCountBruteForce(heights)));
    }
}

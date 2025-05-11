package leetcode;

import java.util.*;

public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < newHeights.length; i++) {

            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;  // width between current and new top
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // Main for testing
    public static void main(String[] args) {
        Solution84 solution = new Solution84();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));  // Output: 10
    }
}

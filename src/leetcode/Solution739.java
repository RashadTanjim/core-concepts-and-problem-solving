package leetcode;

import java.util.*;

public class Solution739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();  // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    // Main for testing
    public static void main(String[] args) {
        Solution739 solver = new Solution739();
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solver.dailyTemperatures(input);
        System.out.println(Arrays.toString(result)); // [1, 1, 4, 2, 1, 1, 0, 0]
    }

}

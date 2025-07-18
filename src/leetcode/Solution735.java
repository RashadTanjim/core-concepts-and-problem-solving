package leetcode;

import java.util.*;

public class Solution735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -a) {
                    stack.pop();  // top explodes
                } else if (top == -a) {
                    stack.pop();  // both explode
                    alive = false;
                } else {
                    alive = false;  // current asteroid explodes
                }
            }

            if (alive) {
                stack.push(a);
            }
        }

        // Stack is reversed, so we convert to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {5, 10, -5};
        int[] input2 = {8, -8};
        int[] input3 = {10, 2, -5};
        int[] input4 = {-2, -1, 1, 2};

        System.out.println(Arrays.toString(asteroidCollision(input1))); // [5, 10]
        System.out.println(Arrays.toString(asteroidCollision(input2))); // []
        System.out.println(Arrays.toString(asteroidCollision(input3))); // [10]
        System.out.println(Arrays.toString(asteroidCollision(input4))); // [-2, -1, 1, 2]
    }
}

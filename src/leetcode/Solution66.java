package leetcode;

import java.util.*;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;  // No carry propagation needed
            }
            digits[i] = 0;  // Set current digit to 0 and continue
        }

        // If we reach here, all digits were 9. We need a new array.
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;  // Set first digit as 1, rest are already 0 by default
        return newDigits;
    }

    public static void main(String[] args) {
        Solution66 sol = new Solution66();

        int[] input1 = {1, 2, 3};
        System.out.println("Output: " + Arrays.toString(sol.plusOne(input1)));  // [1, 2, 4]

        int[] input2 = {9};
        System.out.println("Output: " + Arrays.toString(sol.plusOne(input2)));  // [1, 0]

        int[] input3 = {9, 9, 9};
        System.out.println("Output: " + Arrays.toString(sol.plusOne(input3)));  // [1, 0, 0, 0]

        int[] input4 = {4, 3, 2, 1};
        System.out.println("Output: " + Arrays.toString(sol.plusOne(input4)));  // [4, 3, 2, 2]

        int[] input5 = {0};
        System.out.println("Output: " + Arrays.toString(sol.plusOne(input5)));  // [1]
    }
}

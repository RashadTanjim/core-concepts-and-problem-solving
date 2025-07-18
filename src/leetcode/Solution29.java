package leetcode;

public class Solution29 {
    public static int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Use long to prevent overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) { // Check if b fits into the current bit position of a
                result += 1 << i; // Add the corresponding power of two to the result
                a -= b << i; // Subtract the value of b shifted left by i from a
            }
        }

        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));        // 3
        System.out.println(divide(7, -3));        // -2
        System.out.println(divide(-2147483648, -1)); // 2147483647
        System.out.println(divide(-2147483648, 2));  // -1073741824
    }
}

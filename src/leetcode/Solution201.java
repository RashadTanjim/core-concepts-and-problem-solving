package leetcode;

public class Solution201 {

    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0; // Count how many times we need to shift left and right until they become equal

        // Keep shifting left and right until they are the same
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        // After shifting left and right to be the same, shift back the result
        return left << shiftCount;
    }

    public static void main(String[] args) {
        Solution201 solution = new Solution201();

        // Test cases
        int left = 5, right = 7;
        int result = solution.rangeBitwiseAnd(left, right);
        System.out.println("The bitwise AND of range [" + left + ", " + right + "] is: " + result);
        // Expected output: 4 (because 5 = 101, 6 = 110, 7 = 111, the common prefix is 100)

        left = 0;
        right = 1;
        result = solution.rangeBitwiseAnd(left, right);
        System.out.println("The bitwise AND of range [" + left + ", " + right + "] is: " + result);
        // Expected output: 0 (since the range includes 0)
    }
}
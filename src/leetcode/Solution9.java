package leetcode;

public class Solution9 {

    public boolean isPalindrome(int x) {
        // Negative numbers or numbers ending in 0 (except 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Compare the first half (x) with the reversed second half
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution9 solution = new Solution9();

        // Test cases
        int[] testCases = {121, -121, 10, 12321, 0, 1221, 123};

        for (int x : testCases) {
            System.out.println("Is " + x + " a palindrome? " + solution.isPalindrome(x));
        }
    }
}

package leetcode;

public class Solution172 {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution172 sol = new Solution172();

        System.out.println(sol.trailingZeroes(5));   // Output: 1
        System.out.println(sol.trailingZeroes(10));  // Output: 2
        System.out.println(sol.trailingZeroes(25));  // Output: 6
        System.out.println(sol.trailingZeroes(100)); // Output: 24
    }
}

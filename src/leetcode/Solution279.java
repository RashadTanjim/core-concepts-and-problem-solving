package leetcode;

public class Solution279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {  // dp[i] will hold the minimum number of perfect squares that sum to i
            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {  // Check all perfect squares less than or equal to i
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // Update dp[i] with the minimum count found
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution279 solver = new Solution279();
        System.out.println(solver.numSquares(12)); // Output: 3 (4 + 4 + 4)
        System.out.println(solver.numSquares(13)); // Output: 2 (4 + 9)
    }
}

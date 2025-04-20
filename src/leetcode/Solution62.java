package leetcode;

import java.util.Arrays;

public class Solution62 {

    public int uniquePaths(int m, int n) {  // Combinatorics
        long res = 1;

        for (int i = 1; i <= m - 1; i++) { // The total number of unique ways = C(m+n-2, m-1)
            res = res * (n - 1 + i) / i;
        }
        return (int) res;
    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//
//        for (int i = 0; i < m; i++) dp[i][0] = 1;
//        for (int j = 0; j < n; j++) dp[0][j] = 1;
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//
//        return dp[m - 1][n - 1];
//    }

//    public int uniquePaths(int m, int n) {
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1); // First row
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[j] += dp[j - 1];
//            }
//        }
//
//        return dp[n - 1];
//    }


    public static void main(String[] args) {
        Solution62 sol = new Solution62();
        int m = 3, n = 7;
        System.out.println("Unique Paths: " + sol.uniquePaths(m, n)); // Output: 28
    }
}

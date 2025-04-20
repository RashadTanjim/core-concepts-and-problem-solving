package leetcode;

public class Solution63 {

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//
//        int[][] dp = new int[m][n];
//
//        // Starting cell
//        if (obstacleGrid[0][0] == 1) return 0;
//        dp[0][0] = 1;
//
//        // Fill first column
//        for (int i = 1; i < m; i++) {
//            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
//        }
//
//        // Fill first row
//        for (int j = 1; j < n; j++) {
//            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
//        }
//
//        // Fill rest of grid
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (obstacleGrid[i][j] == 0) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                } else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//
//        return dp[m - 1][n - 1];
//    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int[] row : obstacleGrid) {
            for (int col = 0; col < obstacleGrid[0].length; col++) {

                if (row[col] == 1) {
                    dp[col] = 0;
                } else if (col > 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }

        return dp[obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution63 sol = new Solution63();
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Unique Paths II: " + sol.uniquePathsWithObstacles(grid)); // Output: 2
    }
}

package leetcode;

public class Solution72 {

//    public int minDistance(String word1, String word2) {
//        int m = word1.length(), n = word2.length();
//        int[] prev = new int[n + 1];
//        int[] curr = new int[n + 1];
//
//        for (int j = 0; j <= n; j++) {
//            prev[j] = j;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            curr[0] = i;
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    curr[j] = prev[j - 1];
//                } else {
//                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
//                }
//            }
//            int[] temp = prev;
//            prev = curr;
//            curr = temp;
//        }
//
//        return prev[n];
//    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        Integer[][] memo = new Integer[m + 1][n + 1];

        return dp(word1, word2, m, n, memo);
    }

    private int dp(String word1, String word2, int i, int j, Integer[][] memo) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (memo[i][j] != null) return memo[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = dp(word1, word2, i - 1, j - 1, memo);

        } else {
            int insert = dp(word1, word2, i, j - 1, memo);
            int delete = dp(word1, word2, i - 1, j, memo);
            int replace = dp(word1, word2, i - 1, j - 1, memo);

            memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution72 sol = new Solution72();
        System.out.println(sol.minDistance("horse", "ros"));   // Output: 3
        System.out.println(sol.minDistance("intention", "execution")); // Output: 5
    }

}

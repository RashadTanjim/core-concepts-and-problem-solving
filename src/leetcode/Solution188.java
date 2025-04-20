package leetcode;

public class Solution188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        if (k >= n / 2) {
            int maxProfit = 0;

            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]){
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];

            for (int d = 1; d < n; d++) {
                curr[d] = Math.max(curr[d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1];
    }

//    public int maxProfit(int k, int[] prices) {
//        int n = prices.length;
//        if (n == 0) return 0;
//
//        // Optimization: Unlimited transactions
//        if (k >= n / 2) {
//            int maxProfit = 0;
//
//            for (int i = 1; i < n; i++) {
//                if (prices[i] > prices[i - 1])
//                    maxProfit += prices[i] - prices[i - 1];
//            }
//            return maxProfit;
//        }
//
//        int[][] dp = new int[k + 1][n];
//
//        for (int t = 1; t <= k; t++) {
//            int maxDiff = -prices[0];
//
//            for (int d = 1; d < n; d++) {
//                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
//                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
//            }
//        }
//
//        return dp[k][n - 1];
//    }

    public static void main(String[] args) {
        Solution188 sol = new Solution188();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(sol.maxProfit(k, prices)); // Output: 7
    }
}

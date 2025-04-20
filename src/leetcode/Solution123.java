package leetcode;

public class Solution123 {

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);         // Buy first
            sell1 = Math.max(sell1, buy1 + price); // Sell first
            buy2 = Math.max(buy2, sell1 - price);  // Buy second
            sell2 = Math.max(sell2, buy2 + price); // Sell second
        }

        return sell2;
    }

    public static void main(String[] args) {
        Solution123 sol = new Solution123();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(sol.maxProfit(prices)); // Output: 6
    }
}

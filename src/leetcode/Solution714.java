package leetcode;

public class Solution714 {

    public static int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Sell
            hold = Math.max(hold, cash - prices[i]);       // Buy
        }

        return cash;
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;

        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;

        System.out.println("Max profit 1: " + maxProfit(prices1, fee1)); // 8
        System.out.println("Max profit 2: " + maxProfit(prices2, fee2)); // 6
    }
}

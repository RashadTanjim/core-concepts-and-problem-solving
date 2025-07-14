package leetcode;

import java.util.Arrays;

public class Solution338 {

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        System.out.println("Counting bits up to " + n + ": " + Arrays.toString(result));
    }
}

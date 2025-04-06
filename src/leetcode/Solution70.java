package leetcode;

public class Solution70 {     // Optimized DP Approach

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int prev2 = 1, prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs: " + solution.climbStairs(n)); // Ways to climb 5 stairs: 8
    }
}

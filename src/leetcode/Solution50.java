package leetcode;

public class Solution50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        long power = n;
        if (n < 0) {
            x = 1 / x; // Handle negative exponent
            power = -power; // Convert to positive
        }

        double result = 1.0;
        while (power > 0) {

            if ((power & 1) == 1) { // If current bit is set, multiply
                result *= x;
            }
            x *= x;  // Square x
            power >>= 1;  // Divide power by 2
        }

        return result;
    }

    public static void main(String[] args) {
        Solution50 sol = new Solution50();
        System.out.println(sol.myPow(2.00000, 10));  // Output: 1024.00000
        System.out.println(sol.myPow(2.10000, 3));   // Output: 9.26100
        System.out.println(sol.myPow(2.00000, -2));  // Output: 0.25000
    }
}

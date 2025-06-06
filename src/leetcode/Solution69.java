package leetcode;

public class Solution69 {

    public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int mid, low = 2, high = x / 2;

        while (low <= high) {
            mid = low + high >>> 1;
            num = (long) mid * mid;

            if (num > x) {
                high = mid - 1;
            } else if (num < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        Solution69 sol = new Solution69();

        System.out.println(sol.mySqrt(8));   // Output: 2
        System.out.println(sol.mySqrt(16));  // Output: 4
        System.out.println(sol.mySqrt(1));   // Output: 1
        System.out.println(sol.mySqrt(0));   // Output: 0
    }
}

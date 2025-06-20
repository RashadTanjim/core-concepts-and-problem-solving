package leetcode;

public class Solution334 {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // smallest so far
            } else if (num <= second) {
                second = num; // second smallest
            } else {
                // Found num > second ⇒ triplet exists
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution334 sol = new Solution334();

        System.out.println(sol.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(sol.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(sol.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // true
        System.out.println(sol.increasingTriplet(new int[]{1, 1, 1, 1, 1})); // false
    }
}

package leetcode;

public class Solution287 {

    public int findDuplicate(int[] nums) { // Approach 1: Floyd's Tortoise and Hare (Cycle Detection)
        int slow = nums[0];
        int fast = nums[0];

        // First part: find the intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Second part: find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution287 s = new Solution287();
        System.out.println(s.findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(s.findDuplicate(new int[]{3, 1, 3, 4, 2})); // 3
        System.out.println(s.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1})); // 9
    }
}

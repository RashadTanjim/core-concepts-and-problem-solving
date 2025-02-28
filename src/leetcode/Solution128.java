package leetcode;

import java.util.HashSet;

public class Solution128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longestSeq = 0;
        for (int num : set) {

            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSeq = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentSeq++;
                }

                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }

        return longestSeq;
    }
}


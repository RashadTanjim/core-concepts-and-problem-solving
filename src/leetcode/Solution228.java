package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})); //  ["0->2","4->5","7"]
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int i = 0, n = nums.length;

        while (i < n) {
            int start = i;

            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            result.add(formatRange(nums[start], nums[i]));
            i++;
        }

        return result;
    }

    private static String formatRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }
}

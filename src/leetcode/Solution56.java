package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        // ans: [[1,6],[8,10],[15,18]]
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Sort intervals based on start time

        int index = 0; // Position to store merged intervals

        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[index][1] >= intervals[i][0]) {
                // Merge overlapping intervals
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // Move to the next position and store non-overlapping interval
                index++;
                intervals[index] = intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals, 0, index + 1);
    }
}

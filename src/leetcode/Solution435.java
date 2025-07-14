package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;  // first interval is always included
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
        int[][] intervals3 = {{1,2}, {2,3}};

        System.out.println("Intervals to remove: " + eraseOverlapIntervals(intervals1)); // 1
        System.out.println("Intervals to remove: " + eraseOverlapIntervals(intervals2)); // 2
        System.out.println("Intervals to remove: " + eraseOverlapIntervals(intervals3)); // 0
    }
}

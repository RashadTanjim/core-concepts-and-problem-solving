package leetcode;

import java.util.Arrays;

public class Solution57 {
    public static void main(String[] args) {
      //  System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,5}}, new int[]{6, 8})));
        // ans: [[1,5],[6,9]]
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        int n = intervals.length;
        int index = 0;

        // Step 1: Find where newInterval fits without overlap
        while (index < n && intervals[index][1] < newInterval[0]) {
            index++;
        }

        // Step 2: Merge overlapping intervals in place
        int start = newInterval[0], end = newInterval[1];
        int i = index;
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        // Step 3: Shift elements to accommodate new merged interval
        int shiftIndex = index + 1;
        for (int j = i; j < n; j++, shiftIndex++) {
            intervals[shiftIndex] = intervals[j];
        }

        // Step 4: Replace the merged interval in place
        intervals = Arrays.copyOf(intervals, shiftIndex + 1);

        // Return the valid portion of intervals
        return Arrays.copyOf(intervals, shiftIndex);
    }

}

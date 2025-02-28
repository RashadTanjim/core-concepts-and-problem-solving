package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}})); // 2
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPosition) {
                arrowPosition = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }
}

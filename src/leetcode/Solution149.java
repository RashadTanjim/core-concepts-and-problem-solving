package leetcode;

import java.util.*;

public class Solution149 {

    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;

        int maxPoints = 1; // Minimum answer is at least 1

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0, localMax = 1;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // If the points are identical
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                // Normalize the slope by reducing (dy/dx) to lowest terms
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Ensure a consistent representation
                String slope = dx + "/" + dy;

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            // Add duplicate points to max count
            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    // Compute GCD to normalize slope representation
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Main function for testing
    public static void main(String[] args) {
        Solution149 sol = new Solution149();
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(sol.maxPoints(points1)); // Output: 3

        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(sol.maxPoints(points2)); // Output: 3
    }
}

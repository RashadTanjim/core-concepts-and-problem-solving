package leetcode;

import java.util.*;

public class Solution994 {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;


        // Populate queue with all rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS to spread the rotten oranges to adjacent fresh oranges
        while (!queue.isEmpty() && freshCount >= 1) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                for (int[] d : directions) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR, newC});
                        freshCount--;
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(new Solution994().orangesRotting(grid)); // Output: 4
    }
}

package leetcode;

import java.util.Arrays;

public class Solution289 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println(Arrays.deepToString(gameOfLife(matrix))); // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    }

    public static int[][] gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for 8 neighbors
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Step 1: Encode changes in-place
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d], nj = j + dy[d];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && Math.abs(board[ni][nj]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply rules using encoded values
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Alive → Dead
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Dead → Alive
                }
            }
        }

        // Step 2: Decode the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == -1)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

        return board;
    }
}

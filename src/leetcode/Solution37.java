package leetcode;

import java.util.Arrays;

public class Solution37 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Base case: if the board is filled,
        // Find the first empty cell
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {
                // If we find an empty cell
                if (board[row][col] == '.') {
                    // Try digits from '1' to '9'
                    for (char d = '1'; d <= '9'; d++) {
                        // Check if placing digit d is valid
                        if (isValid(board, row, col, d)) {
                            board[row][col] = d; // place the digit
                            if (solve(board)) return true;
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char d) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d) return false; // check row
            if (board[i][col] == d) return false; // check col
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == d) return false; // check box
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution37 solver = new Solution37();
        solver.solveSudoku(board);

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

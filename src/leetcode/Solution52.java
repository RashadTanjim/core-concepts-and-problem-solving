package leetcode;

import java.util.*;

public class Solution52 {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, 0, 0, 0);
        return count;
    }

    private void backtrack(int row, int n, int cols, int diagonals, int antiDiagonals) {
        if (row == n) {
            count++;
            return;
        }

        int availablePositions = ((1 << n) - 1) & ~(cols | diagonals | antiDiagonals);

        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions; // Get rightmost available position
            availablePositions -= position; // Remove this position

            backtrack(row + 1, n, cols | position, (diagonals | position) << 1, (antiDiagonals | position) >> 1);
        }
    }


//    public int totalNQueens(int n) {
//        Set<Integer> cols = new HashSet<>();
//        Set<Integer> diagonals = new HashSet<>();
//        Set<Integer> antiDiagonals = new HashSet<>();
//
//        backtrack(0, n, cols, diagonals, antiDiagonals);
//        return count;
//    }
//
//    private void backtrack(int row, int n, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
//        if (row == n) {
//            count++;
//            return;
//        }
//
//        for (int col = 0; col < n; col++) {
//
//            if (cols.contains(col) || diagonals.contains(row - col) || antiDiagonals.contains(row + col)) {
//                continue;
//            }
//
//            cols.add(col);
//            diagonals.add(row - col);
//            antiDiagonals.add(row + col);
//
//            backtrack(row + 1, n, cols, diagonals, antiDiagonals);
//
//            cols.remove(col);
//            diagonals.remove(row - col);
//            antiDiagonals.remove(row + col);
//        }
//    }

    public static void main(String[] args) {
        Solution52 sol = new Solution52();
        System.out.println(sol.totalNQueens(4));  // Output: 2
    }
}

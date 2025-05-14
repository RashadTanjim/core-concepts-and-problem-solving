package leetcode;

import java.util.*;

public class Solution240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value > target) {
                col--;  // Eliminate column
            } else {
                row++;  // Eliminate row
            }
        }

        return false;
    }


//    public static boolean searchMatrix(int[][] matrix, int target) {
//        for (int[] row : matrix) {
//            int idx = Arrays.binarySearch(row, target);
//            if (idx >= 0) return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));  // true
    }
}

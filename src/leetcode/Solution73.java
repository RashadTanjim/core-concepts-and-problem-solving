package leetcode;

import java.util.Arrays;

public class Solution73 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };

        System.out.println(Arrays.deepToString(setZeroes(matrix))); // [[1,0,1],[0,0,0],[1,0,1]]
    }

    public static int[][] setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Step 1: Check if first row/column should be zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Mark zeroes using first row/column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: Set zeroes using first row/column markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Handle first row & column separately
        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        return matrix;
    }
}

//Input:
//        [
//        [1, 1, 1],
//        [1, 0, 1],
//        [1, 1, 1]
//        ]
//
//Output:
//        [
//        [1, 0, 1],
//        [0, 0, 0],
//        [1, 0, 1]
//        ]

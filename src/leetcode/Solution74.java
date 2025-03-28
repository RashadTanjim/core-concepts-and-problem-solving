package leetcode;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // Prevents overflow
            int midValue = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D

            if (midValue == target) return true;
            else if (midValue < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution74 solution = new Solution74();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;
        System.out.println("Target " + target + " found: " + solution.searchMatrix(matrix, target)); // true

        target = 13;
        System.out.println("Target " + target + " found: " + solution.searchMatrix(matrix, target)); // false
    }
}

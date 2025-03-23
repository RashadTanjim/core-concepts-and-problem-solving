package leetcode;

import leetcode.helper.QuadTree;

public class Solution427 {

    public QuadTree construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private QuadTree buildQuadTree(int[][] grid, int row, int col, int size) {
        // Base Case: If the sub-grid contains only 1s or 0s, return a leaf node
        if (isUniform(grid, row, col, size)) {
            return new QuadTree(grid[row][col] == 1, true);
        }

        // Recursive Case: Divide into four quadrants
        int half = size / 2;
        QuadTree topLeft = buildQuadTree(grid, row, col, half);
        QuadTree topRight = buildQuadTree(grid, row, col + half, half);
        QuadTree bottomLeft = buildQuadTree(grid, row + half, col, half);
        QuadTree bottomRight = buildQuadTree(grid, row + half, col + half, half);

        // Return internal node with children
        return new QuadTree(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) return false;
            }
        }

        return true;
    }

    // Utility function to print QuadTree (For debugging)
    private void printQuadTree(QuadTree node) {
        if (node == null) return;
        if (node.isLeaf) {
            System.out.println("Leaf: " + (node.val ? 1 : 0));
        } else {
            System.out.println("Internal Node");
            printQuadTree(node.topLeft);
            printQuadTree(node.topRight);
            printQuadTree(node.bottomLeft);
            printQuadTree(node.bottomRight);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Solution427 sol = new Solution427();
        int[][] grid = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };

        QuadTree root = sol.construct(grid);
        sol.printQuadTree(root); // Debugging output
    }
}

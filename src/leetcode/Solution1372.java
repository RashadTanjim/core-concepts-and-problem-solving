package leetcode;

import leetcode.common.TreeNode;

public class Solution1372 {

    int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return maxZigZag;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            dfs(node.right, length + 1, false); // turn right
            dfs(node.left, 1, true);            // reset
        } else {
            dfs(node.left, length + 1, true);   // turn left
            dfs(node.right, 1, false);          // reset
        }
    }

    // Simple test case
    public static void main(String[] args) {
        Solution1372 sol = new Solution1372();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);

        System.out.println("Longest ZigZag: " + sol.longestZigZag(root)); // Output: 3
    }
}

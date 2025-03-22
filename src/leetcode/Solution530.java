package leetcode;

import leetcode.helper.TreeNode;

public class Solution530 {
    private static int minDiff = Integer.MAX_VALUE;
    private static Integer prev = null;

    public static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Minimum Absolute Difference: " + getMinimumDifference(root));
    }
}

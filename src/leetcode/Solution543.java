package leetcode;

import leetcode.helper.TreeNode;

public class Solution543 {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    // Helper method to calculate height
    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        // Update diameter at this node
        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution543 solution = new Solution543();

        // Build the tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree = " + result); // Output: 3
    }
}

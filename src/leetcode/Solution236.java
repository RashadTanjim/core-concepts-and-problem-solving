package leetcode;

import leetcode.common.TreeNode;

public class Solution236 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If root is null, or if we find either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Search in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return whichever side is non-null
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Sample binary tree creation
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        // Find LCA of node 5 and node 1
        TreeNode lca = lowestCommonAncestor(root, node5, node1);

        // Output the result
        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}

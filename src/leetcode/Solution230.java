package leetcode;

import leetcode.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution230 {

    public static int kthSmallest(TreeNode root, int k) {
        int leftSize = countNodes(root.left);

        if (k == leftSize + 1) return root.val;
        else if (k <= leftSize) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - leftSize - 1);
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Helper function to insert a node into the BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Function to build a BST from a level-order array with `null` values
    public static TreeNode buildBST(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        // Example BST: [3, 1, 4, null, 2]
        Integer[] values = {3, 1, 4, null, 2};
        TreeNode root = buildBST(values);

        // Test cases
        System.out.println("3rd smallest element: " + kthSmallest(root, 3)); // Output: 3
        System.out.println("1st smallest element: " + kthSmallest(root, 1)); // Output: 1
        System.out.println("2nd smallest element: " + kthSmallest(root, 2)); // Output: 2
    }
}

package leetcode;

import leetcode.helper.TreeNode;

public class Solution98 {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null){
            return true;
        }

        // If the node violates the min/max range, return false
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        // Check left subtree (max is updated)
        if (!validate(node.left, min, node.value)){
            return false;
        }

        // Check right subtree (min is updated)
        if (!validate(node.right, node.value, max)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root)); // Output: true
        /*
         *         2
         *        / \
         *       1   3
         */
    }

}
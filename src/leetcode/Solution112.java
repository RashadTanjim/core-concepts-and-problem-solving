package leetcode;

import leetcode.helper.TreeNode;
import leetcode.helper.Pair;

import java.util.Stack;

class Solution112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, targetSum - root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int remainingSum = pair.getValue();

            if (node.left == null && node.right == null && remainingSum == 0) {
                return true;
            }

            if (node.right != null) {
                stack.push(new Pair<>(node.right, remainingSum - node.right.val));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, remainingSum - node.left.val));
            }
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum)); // Expected Output: true
    }
}
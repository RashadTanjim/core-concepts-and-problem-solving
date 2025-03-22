package leetcode;

import leetcode.helper.TreeNode;

import java.util.*;

public class Solution124 {

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> maxGain = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // If left & right children are processed, calculate max gain
            if ((node.left == null || visited.contains(node.left)) &&
                    (node.right == null || visited.contains(node.right))) {
                stack.pop();

                int leftGain = Math.max(0, maxGain.getOrDefault(node.left, 0));
                int rightGain = Math.max(0, maxGain.getOrDefault(node.right, 0));

                // Compute max path sum at this node
                int currentPathSum = leftGain + rightGain + node.val;
                maxSum = Math.max(maxSum, currentPathSum);

                // Store the max gain from this node
                maxGain.put(node, Math.max(leftGain, rightGain) + node.val);
                visited.add(node);
            } else {
                // Push children onto stack if they are not visited
                if (node.right != null && !visited.contains(node.right)) {
                    stack.push(node.right);
                }
                if (node.left != null && !visited.contains(node.left)) {
                    stack.push(node.left);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int maxPathSum = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
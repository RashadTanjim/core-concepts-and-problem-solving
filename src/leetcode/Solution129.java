package leetcode;

import leetcode.helper.TreeNode;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class Solution129 {

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int totalSum = 0;
        Stack<Map.Entry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 0));

        while (!stack.isEmpty()) {

            Map.Entry<TreeNode, Integer> entry = stack.pop();
            TreeNode node = entry.getKey();
            int val = entry.getValue() * 10 + node.value;

            if (node.left == null && node.right == null) {
                totalSum += val;
            }

            if (node.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.right, val));
            }

            if (node.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.left, val));
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root)); // Expected Output: 25
    }
}

package leetcode;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;

        if (depth == result.size()) {
            result.add(node.value);
        }

        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}

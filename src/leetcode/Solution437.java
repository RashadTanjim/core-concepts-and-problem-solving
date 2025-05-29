package leetcode;

import leetcode.common.TreeNode;

import java.util.*;

public class Solution437 {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1); // Base case: one path with sum 0

        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        currSum += node.val;
        int count = map.getOrDefault(currSum - target, 0);

        // Update prefix sum map
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // Recurse left and right
        count += dfs(node.left, currSum, target, map);
        count += dfs(node.right, currSum, target, map);

        // Backtrack to not affect other paths
        map.put(currSum, map.get(currSum) - 1);

        return count;
    }

    public static void main(String[] args) {
        Solution437 solution = new Solution437();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println("Total paths = " + solution.pathSum(root, 8)); // Output: 3
    }
}

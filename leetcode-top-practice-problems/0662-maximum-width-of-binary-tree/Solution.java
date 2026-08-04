// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<IndexedNode> queue = new ArrayDeque<>();
        queue.offer(new IndexedNode(root, 0));
        int ans = 0;
        while (!queue.isEmpty()) {
            long levelStart = queue.peekFirst().index;
            long levelEnd = queue.peekLast().index;
            ans = Math.max(ans, (int) (levelEnd - levelStart + 1));
            for (int n = queue.size(); n > 0; --n) {
                IndexedNode current = queue.pollFirst();
                root = current.node;
                long index = current.index - levelStart;
                if (root.left != null) {
                    queue.offer(new IndexedNode(root.left, index * 2));
                }
                if (root.right != null) {
                    queue.offer(new IndexedNode(root.right, index * 2 + 1));
                }
            }
        }
        return ans;
    }

    private static class IndexedNode {
        private final TreeNode node;
        private final long index;

        private IndexedNode(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
}

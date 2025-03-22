package leetcode;

import leetcode.helper.TreeNode;

import java.util.Stack;

public class Solution173 {

    static class BSTIterator {
        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftNodes(root);
        }

        // Returns the next smallest number
        public int next() {
            TreeNode node = stack.pop();
            pushLeftNodes(node.right);
            return node.val;
        }

        // Returns whether we have a next smallest number
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Helper function to push all left children into stack
        private void pushLeftNodes(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    /*
     * Input
     * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
     * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
     * Output
     * [null, 3, 7, true, 9, true, 15, true, 20, false]
     * <p>
     * Explanation
     * BSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
     * bSTIterator.next();    // return 3
     * bSTIterator.next();    // return 7
     * bSTIterator.hasNext(); // return True
     * bSTIterator.next();    // return 9
     * bSTIterator.hasNext(); // return True
     * bSTIterator.next();    // return 15
     * bSTIterator.hasNext(); // return True
     * bSTIterator.next();    // return 20
     * bSTIterator.hasNext(); // return False
     */
}


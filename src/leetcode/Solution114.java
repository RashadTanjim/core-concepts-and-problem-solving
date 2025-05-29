package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution114 {
    public static void flatten(TreeNode root) {

        while (root != null) {

            if (root.left != null) {
                TreeNode rightmost = root.left;

                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }

    public static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6))
        );

        System.out.println("Original Tree:");
        printTree(root);

        flatten(root);

        System.out.println("Flattened Tree:");
        printList(root);
    }

    public static void printTree(TreeNode root) {

        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}
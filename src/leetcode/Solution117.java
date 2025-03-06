package leetcode;

import leetcode.helper.Node2;

public class Solution117 {

    public static Node2 connect(Node2 root) {
        if (root == null) return null;

        Node2 dummy = new Node2(0);
        Node2 prev = dummy;
        Node2 curr = root;

        while (curr != null) {

            if (curr.getLeft() != null) {
                prev.setNext(curr.getLeft()); // Link previous node’s next to current node’s left child
                prev = prev.getNext(); // Move prev pointer forward
            }

            if (curr.getRight() != null) {
                prev.setNext(curr.getRight()); // Link previous node’s next to current node’s right child
                prev = prev.getNext(); // Move prev pointer forward
            }

            curr = curr.getNext(); // Move to the next node in the current level

            if (curr == null) { // If we reach the end of the current level
                curr = dummy.getNext(); // Move to the first node of the next level
                dummy.setNext(null); // Reset dummy's next pointer
                prev = dummy; // Reset prev to dummy
            }
        }

        return root;
    }

    public static void printTreeWithNext(Node2 root) {
        Node2 levelStart = root;
        while (levelStart != null) {
            Node2 current = levelStart;
            while (current != null) {
                System.out.print(current.getValue() + " -> ");
                current = current.getNext();
            }
            System.out.println("NULL");
            levelStart = levelStart.getLeft();
        }
    }

    public static void main(String[] args) {
        // Creating a perfect binary tree:
        Node2 root = new Node2(1);
        root.setLeft(new Node2(2));
        root.setRight(new Node2(3));
        root.getLeft().setLeft(new Node2(4));
        root.getLeft().setRight(new Node2(5));
        //root.getRight().setLeft(new Node2(6));
        root.getRight().setRight(new Node2(7));

        // Print tree levels with next pointers
        System.out.println("Tree with next pointers:");
        printTreeWithNext(connect(root));
    }
}

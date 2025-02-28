package leetcode;

import leetcode.helper.ListNode;

public class Solution25 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head; // Edge cases

        // Step 1: Check if there are at least `k` nodes
        ListNode temp = head;
        int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count < k) return head; // If fewer than `k` nodes, return as is

        // Step 2: Reverse `k` nodes
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Recursively reverse remaining list and connect
        head.next = reverseKGroup(curr, k);

        // `prev` is the new head after reversal
        return prev;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;

        ListNode newHead = reverseKGroup(head, k);

        System.out.println("List after reversing in groups of " + k + ":");
        printList(newHead);
    }
}
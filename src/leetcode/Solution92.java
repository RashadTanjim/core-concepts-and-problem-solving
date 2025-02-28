package leetcode;

import leetcode.helper.ListNode;

public class Solution92 {

    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));

        System.out.println("Original List:");
        printList(head);

        int left = 2, right = 4;

        ListNode newHead = reverseBetween(head, left, right);

        System.out.println("List after reversing between " + left + " and " + right + ":");
        printList(newHead);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getVal() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;  // Edge case

        ListNode dummy = new ListNode(0);  // Dummy node to handle edge cases
        dummy.setNext(head);
        ListNode prev = dummy;

        // Step 1: Move `prev` to just before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.getNext();
        }

        // Step 2: Reverse sublist from `left` to `right`
        ListNode curr = prev.getNext();
        ListNode next;
        ListNode prevSublist = null;

        for (int i = left; i <= right; i++) {
            next = curr.getNext();
            curr.setNext(prevSublist);
            prevSublist = curr;
            curr = next;
        }

        // Step 3: Reconnect the reversed part
        prev.getNext().setNext(curr);  // Connect end of reversed list to remaining list
        prev.setNext(prevSublist); // Connect start of reversed list to prev node

        return dummy.getNext();
    }
}


package leetcode;

import leetcode.helper.ListNode;

public class Solution86 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greaterHead;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }

    // Helper functions to create and print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        int[] inputArray = {1, 4, 3, 2, 5, 2};
        ListNode head = createLinkedList(inputArray);

        System.out.println("Original List:");
        printList(head);

        head = partition(head, 3);

        System.out.println("After Partition:");
        printList(head);
    }
}
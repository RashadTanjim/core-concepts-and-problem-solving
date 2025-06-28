package leetcode;

//import leetcode.helper.ListNode2;

// LeetCode 156: Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/
// This code defines a method to reverse a portion of a linked list between two given positions.
// The method takes the head of the linked list and two integers, left and right, indicating the positions to reverse.
// It returns the head of the modified linked list after the reversal.
// The main method demonstrates the usage of the reverseBetween method by creating a linked list and reversing a portion of it.
// The ListNode2 class is assumed to be defined in the leetcode.helper package.

public class Solution156 {
//    public ListNode2 reverseBetween(ListNode2 head, int left, int right) {
//        if (head == null || left == right) return head;
//
//        ListNode2 dummy = new ListNode2(0);
//        dummy.next(head);
//        ListNode2 prev = dummy;
//
//        // Move prev to the node before the left position
//        for (int i = 0; i < left - 1; i++) {
//            prev = prev.getNext();
//        }
//
//        // Start reversing
//        ListNode2 current = prev.getNext();
//        ListNode2 next = null;
//        ListNode2 tail = current;
//
//        for (int i = 0; i < right - left + 1; i++) {
//            next = current.getNext();
//            current.setNext(prev.getNext());
//            prev.setNext(current);
//            current = next;
//        }
//
//        tail.setNext(current); // Connect the tail to the remaining part of the list
//
//        return dummy.getNext(); // Return the new head
//    }
//
//    public static void main(String[] args) {
//        Solution156 solver = new Solution156();
//        ListNode2 head = new ListNode2(1,
//                new ListNode2(2,
//                        new ListNode2(3,
//                                new ListNode2(4,
//                                        new ListNode2(5)))));
//
//        ListNode2 result = solver.reverseBetween(head, 2, 4);
//
//        // Print the reversed list
//        while (result != null) {
//            System.out.print(result.getValue() + " ");
//            result = result.getNext();
//        }
//    }
}

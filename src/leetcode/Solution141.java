package leetcode;

import leetcode.helper.ListNode;

public class Solution141 {

    public static void main(String[] args) {

        // Creating a cycle: head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second); // Creating a cycle at position 1

        System.out.println(hasCycle(head)); // Expected output: true
    }

    // Detects if a cycle exists using Floyd’s Algorithm (Two Pointers)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}

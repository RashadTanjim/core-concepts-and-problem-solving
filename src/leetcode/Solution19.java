package leetcode;

import leetcode.common.ListNode;

public class Solution19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        return dummy.next; // Return updated head
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
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
        // Example test case: [1,2,3,4,5] with n = 2
        int[] inputArray = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = createLinkedList(inputArray);

        System.out.println("Original List:");
        printList(head);

        head = removeNthFromEnd(head, n);

        System.out.println("After Removing " + n + "th Node From End:");
        printList(head);
    }
}

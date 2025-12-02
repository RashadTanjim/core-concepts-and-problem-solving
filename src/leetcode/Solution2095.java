package leetcode;

import leetcode.common.ListNode;

public class Solution2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    // Utility method for testing
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution2095 sol = new Solution2095();
        ListNode updatedHead = sol.deleteMiddle(head);

        System.out.print("After deleting middle node: ");
        printList(updatedHead); // Expected: 1 2 4 5
    }
}
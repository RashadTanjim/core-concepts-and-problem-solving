package leetcode;

import leetcode.common.ListNode;

public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;     // Link to next odd
            odd = odd.next;

            even.next = odd.next;     // Link to next even
            even = even.next;
        }

        odd.next = evenHead; // Combine odd and even parts
        return head;
    }

    // Helper to print list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution328 solver = new Solution328();

        // Example: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);                        // Original
        ListNode result = solver.oddEvenList(head);
        printList(result);                      // Output: 1 -> 3 -> 5 -> 2 -> 4
    }
}

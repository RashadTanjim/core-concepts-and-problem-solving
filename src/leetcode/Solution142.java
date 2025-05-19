package leetcode;

import leetcode.helper.ListNode;

public class Solution142 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find entry point
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Create linked list with a cycle:
        // 3 → 2 → 0 → -4
        //      ↑         ↓
        //      └─────────┘

        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeNeg4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2; // Creates the cycle at node2

        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println("Cycle detected at node with value: " + result.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

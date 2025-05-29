package leetcode;

import leetcode.common.ListNode;

public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null; // Break into two parts

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Step 3: Merge the sorted halves using two pointers
        return mergeTwoLists(left, right);
    }

    // Finds the middle of the linked list using two pointers (slow & fast)
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }

    // Merges two sorted linked lists using the two-pointer technique
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }

    // Utility function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Driver Code
    public static void main(String[] args) {
        Solution148 sol = new Solution148();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        System.out.print("Original List: ");
        printList(head);

        ListNode sorted = sol.sortList(head);

        System.out.print("Sorted List: ");
        printList(sorted);
    }
}

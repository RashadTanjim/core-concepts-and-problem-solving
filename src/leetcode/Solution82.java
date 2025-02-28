package leetcode;

import leetcode.helper.ListNode;

public class Solution82 {

    public static class RemoveDuplicatesSortedList {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;

            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode current = head;

            while (current != null) {
                boolean isDuplicate = false;

                while (current.next != null && current.val == current.next.val) {
                    isDuplicate = true;
                    current = current.next;
                }

                if (isDuplicate) {
                    prev.next = current.next;
                } else {
                    prev = prev.next;
                }

                current = current.next;
            }

            return dummy.next;
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
            RemoveDuplicatesSortedList solution = new RemoveDuplicatesSortedList();

            // Example test case: [1,2,3,3,4,4,5]
            int[] inputArray = {1, 2, 3, 3, 4, 4, 5};
            ListNode head = createLinkedList(inputArray);

            System.out.println("Original List:");
            printList(head);

            head = solution.deleteDuplicates(head);

            System.out.println("After Removing Duplicates:");
            printList(head);
        }
    }
}
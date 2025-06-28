package leetcode;

import leetcode.common.ListNode;

public class Solution725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode current = root;

        // First, calculate the length of the linked list
        while (current != null) {
            length++;
            current = current.next;
        }

        // Calculate the size of each part and the number of longer parts
        int partSize = length / k;
        int longerParts = length % k;

        current = root;
        for (int i = 0; i < k; i++) {
            result[i] = current;
            // Determine the size of the current part
            int currentPartSize = partSize + (i < longerParts ? 1 : 0);

            // Move to the end of the current part
            for (int j = 0; j < currentPartSize - 1 && current != null; j++) {
                current = current.next;
            }

            // Disconnect the current part from the next part
            if (current != null) {
                ListNode nextPartHead = current.next;
                current.next = null;
                current = nextPartHead;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution725 solution = new Solution725();
        ListNode[] parts = solution.splitListToParts(head, 3);

        for (ListNode part : parts) {
            while (part != null) {
                System.out.print(part.val + " ");
                part = part.next;
            }
            System.out.println();
        }
    }
}

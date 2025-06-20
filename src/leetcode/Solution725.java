package leetcode;

import leetcode.common.ListNode;

public class Solution725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int n = 0;
        ListNode curr = root;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int width = n / k;
        int extra = n % k;

        ListNode node = root;
        for (int i = 0; i < k; i++) {
            ListNode head = node;
            int partSize = width + (i < extra ? 1 : 0);

            for (int j = 0; j < partSize - 1; j++) {
                if (node != null) node = node.next;
            }

            if (node != null) {
                ListNode next = node.next;
                node.next = null;
                node = next;
            }

            result[i] = head;
        }

        return result;
    }

    public static void printParts(ListNode[] parts) {
        for (ListNode part : parts) {
            while (part != null) {
                System.out.print(part.val + " ");
                part = part.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        Solution725 solver = new Solution725();
        ListNode[] parts = solver.splitListToParts(head, 3);
        printParts(parts);
    }
}

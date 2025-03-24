package others;

import leetcode.helper.ListNode;

import java.util.*;

class Solution {
    private static final int CHUNK_SIZE = 10000; // Process in batches

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        List<ListNode> chunkedLists = new ArrayList<>();
        for (int i = 0; i < lists.length; i += CHUNK_SIZE) {
            int end = Math.min(i + CHUNK_SIZE, lists.length);
            chunkedLists.add(mergeChunk(lists, i, end - 1));
        }

        return mergeChunk(chunkedLists.toArray(new ListNode[0]), 0, chunkedLists.size() - 1);
    }

    private ListNode mergeChunk(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeChunk(lists, left, mid);
        ListNode l2 = mergeChunk(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        if (l1 != null) minHeap.add(l1);
        if (l2 != null) minHeap.add(l2);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        int count = 0;
        while (head != null && count < 50) { // Print first 50 elements only for large data
            System.out.print(head.val + " -> ");
            head = head.next;
            count++;
        }
        System.out.println("...");
    }

    public static void main(String[] args) {
        int totalLists = 1000000; // Simulating a large dataset
        ListNode[] lists = new ListNode[totalLists];

        for (int i = 0; i < totalLists; i++) {
            lists[i] = new ListNode(i, new ListNode(i + 1, new ListNode(i + 2)));
        }

        Solution solution = new Solution();
        ListNode mergedHead = solution.mergeKLists(lists);
        printList(mergedHead);
    }
}

package leetcode;

import leetcode.helper.ListNode;

public class Solution21 {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.getVal() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating first sorted list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Creating second sorted list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Merging lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Printing result
        System.out.print("Merged List: ");
        printList(mergedList); // Expected Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (list1 != null && list2 != null) {

            if (list1.getVal() <= list2.getVal()) {
                current.setNext(list1);
                list1 = list1.getNext();
            } else {
                current.setNext(list2);
                list2 = list2.getNext();
            }

            current = current.getNext();
        }

        if (list1 != null) current.setNext(list1);
        if (list2 != null) current.setNext(list2);

        return head.getNext();
    }
}

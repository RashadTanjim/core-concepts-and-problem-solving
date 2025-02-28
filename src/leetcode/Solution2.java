package leetcode;
import leetcode.helper.ListNode;

public class Solution2 {
    public static void main(String[] args) {
        // Creating first number: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // Creating second number: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        // Adding two numbers
        ListNode result = addTwoNumbers(l1, l2);

        // Printing the result
        System.out.print("Sum: ");
        printList(result); // Expected Output: 7 -> 0 -> 8 -> null
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.getVal() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.getVal() : 0;
            int y = (l2 != null) ? l2.getVal() : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.setNext(new ListNode(sum % 10));
            current = current.getNext();

            if (l1 != null) l1 = l1.getNext();
            if (l2 != null) l2 = l2.getNext();
        }

        if (carry > 0) {
            current.setNext(new ListNode(carry));
        }

        return head.getNext();
    }
}

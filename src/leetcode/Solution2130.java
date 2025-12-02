package leetcode;

import leetcode.common.ListNode;

public class Solution2130 {

    public int pairSum(ListNode head) {
        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = reverse(slow);

        // Step 3: Traverse both halves and compute max twin sum
        int maxSum = 0;
        ListNode first = head;
        while (second != null) {
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /* //Alternative solution using Stack:
     *     public int pairSum(ListNode head) {
     *         Stack<Integer> stack = new Stack<>();
     *         ListNode slow = head, fast = head;
     *
     *         // Push first half
     *         while (fast != null && fast.next != null) {
     *             stack.push(slow.val);
     *             slow = slow.next;
     *             fast = fast.next.next;
     *         }
     *
     *         int maxSum = 0;
     *         while (slow != null) {
     *             maxSum = Math.max(maxSum, stack.pop() + slow.val);
     *             slow = slow.next;
     *         }
     *
     *         return maxSum;
     *     }
     */

    public static void main(String[] args) {
        Solution2130 sol = new Solution2130();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Max Twin Sum: " + sol.pairSum(head)); // Output: 6
    }
}

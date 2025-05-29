package leetcode;

import leetcode.common.ListNode;

public class Solution234 {

    ListNode curr;

    public boolean isPalindrome(ListNode head) {
        curr = head;
        return solve(head);
    }

    public boolean solve(ListNode head) {
        if (head == null)
            return true;

        boolean ans = solve(head.next) && head.val == curr.val;
        curr = curr.next;
        return ans;
    }

    public static void main(String[] args) {
        Solution234 solution = new Solution234();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(solution.isPalindrome(head));
    }
}

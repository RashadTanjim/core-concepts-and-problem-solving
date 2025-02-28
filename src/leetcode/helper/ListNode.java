package leetcode.helper;

public class ListNode {
    public int val;    // intentionally make it public for using directly
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

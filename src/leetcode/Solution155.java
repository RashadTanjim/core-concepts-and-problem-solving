package leetcode;

import java.util.Stack;

public class Solution155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("getMin: " + minStack.getMin()); // Expected: -3

        minStack.pop();

        System.out.println("top: " + minStack.top()); // Expected: 0
        System.out.println("getMin: " + minStack.getMin()); // Expected: -2
    }

    static class MinStack {

        private int min;
        private final Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE; // Initially set min to a large value
        }

        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x

            if (x <= min) {
                stack.push(min);
                min = x;
            }

            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if (stack.pop() == min)
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}


//class MinStack2 {
//    Node head;
//
//
//    public void push(int val) {
//        if (head == null) {
//            head = new Node(val, val, null);
//        } else {
//            head = new Node(val, Math.min(val, head.min), head);
//        }
//    }
//
//    public void pop() {
//        head = head.next;
//    }
//
//    public int top() {
//        return head.data;
//    }
//
//    public int getMin() {
//        return head.min;
//    }
//
//    private static class Node {
//        int data;
//        int min;
//        Node next;
//
//
//        Node() {
//            this.data = 0;
//            this.min = 0;
//            this.next = null;
//        }
//
//        Node(int data, int min, Node next) {
//            this.data = data;
//            this.min = min;
//            this.next = next;
//        }
//    }
//}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
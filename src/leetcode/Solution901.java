package leetcode;

import java.util.ArrayDeque;
import java.util.*;

public class Solution901 { // StockSpanner

    private final Deque<int[]> stack;     // Pair of (price, span)

    Solution901() { // public StockSpanner
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        var spanner = new Solution901();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            System.out.println("Price: " + price + ", Span: " + spanner.next(price));
        }
    }
}

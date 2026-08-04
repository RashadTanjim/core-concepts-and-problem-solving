// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                stk.push(Integer.parseInt(t));
            } else {
                int y = stk.pop();
                int x = stk.pop();
                switch (t) {
                case "+":
                    stk.push(x + y);
                    break;
                case "-":
                    stk.push(x - y);
                    break;
                case "*":
                    stk.push(x * y);
                    break;
                default:
                    stk.push(x / y);
                    break;
                }
            }
        }
        return stk.pop();
    }
}

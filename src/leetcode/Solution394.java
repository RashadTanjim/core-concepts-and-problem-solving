package leetcode;

import java.util.*;

public class Solution394 {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // handle multi-digit numbers
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int repeat = countStack.pop();

                decoded.append(String.valueOf(current).repeat(repeat));
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    // Test Main
    public static void main(String[] args) {
        Solution394 solution = new Solution394();
        System.out.println(solution.decodeString("3[a]2[bc]"));         // "aaabcbc"
        System.out.println(solution.decodeString("3[a2[c]]"));         // "accaccacc"
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));    // "abcabccdcdcdef"
    }

}

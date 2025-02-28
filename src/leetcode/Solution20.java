package leetcode;

public class Solution20 {
    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
    }

    public static boolean isValid(String s) {

        char[] chars = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                top += 1;
                chars[top] = c;

            } else {

                if (top == -1) return false;
                char pop = chars[top];
                top -= 1;

                if (!((pop == '(' && c == ')') ||
                        (pop == '[' && c == ']') ||
                        (pop == '{' && c == '}'))) {
                    return false;
                }
            }
        }

        return top == -1;
    }
}

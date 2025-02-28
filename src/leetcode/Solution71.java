package leetcode;

import java.util.Stack;

public class Solution71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/")); // "/home"
        System.out.println(simplifyPath( "/.../a/../b/c/../d/./")); // "/.../b/d"
    }

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (String dir : split) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}

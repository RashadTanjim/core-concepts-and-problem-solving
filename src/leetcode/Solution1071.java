package leetcode;

public class Solution1071 {

    public String gcdOfStrings(String str1, String str2) {

        if (str1.length() < str2.length()) { // Ensure str1 is the longer string
            return gcdOfStrings(str2, str1);
        }

        if (!str1.startsWith(str2)) { // Check if str1 starts with str2
            return "";
        }

        if (str2.isEmpty()) { // If str2 is empty, return str1 as the GCD
            return str1;
        }

        return gcdOfStrings(str1.substring(str2.length()), str2);
    }

    public static void main(String[] args) {
        Solution1071 solution = new Solution1071();
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC")); // Output: "ABC"
        System.out.println(solution.gcdOfStrings("ABABAB", "ABAB")); // Output: "AB"
        System.out.println(solution.gcdOfStrings("LEET", "CODE")); // Output: ""
    }
}

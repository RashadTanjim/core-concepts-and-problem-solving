package leetcode;

public class Solution76 {
    public static void main(String[] args) {
        String s = "ADAB", t = "AB";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int count = t.length();
        int start = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        // Store character frequencies of `t` in `map`
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        // Iterate over `s` using a for loop
        for (int end = 0; end < s.length(); end++) {
            if (map[s.charAt(end)]-- > 0) {
                count--;
            }

            // When all characters in `t` are matched in `s`
            while (count == 0) {
                if (end - start + 1 < minLen) {
                    startIndex = start;
                    minLen = end - start + 1;
                }

                if (map[s.charAt(start)]++ == 0) {
                    count++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

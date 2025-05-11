package leetcode;

import java.util.*;

public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // Build frequency map for p and the first window in s
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        // Compare initial window
        if (Arrays.equals(pFreq, sFreq)) result.add(0);

        // Slide the window over s
        for (int i = p.length(); i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;                       // Add right character
            sFreq[s.charAt(i - p.length()) - 'a']--;          // Remove left character

            if (Arrays.equals(pFreq, sFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution438 solver = new Solution438();
        System.out.println(solver.findAnagrams("cbaebabacd", "abc"));  // [0, 6]
        System.out.println(solver.findAnagrams("abab", "ab"));         // [0, 1, 2]
    }
}

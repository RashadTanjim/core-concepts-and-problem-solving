package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution345 {

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return s;

        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u',
                        'A', 'E', 'I', 'O', 'U'));

        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) i++;
            while (i < j && !vowels.contains(chars[j])) j--;
            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution345 solver = new Solution345();

        System.out.println(solver.reverseVowels("leetcode")); // "leotcede"
        System.out.println(solver.reverseVowels("hello"));    // "holle"
        System.out.println(solver.reverseVowels("aA"));       // "Aa"
        System.out.println(solver.reverseVowels("bcdfg"));    // "bcdfg"
    }
}

package leetcode;

import java.util.Set;

public class Solution1456 {

    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowels = 0, currVowels = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add the new character
            if (vowels.contains(s.charAt(i))) {
                currVowels++;
            }

            // Remove the character that's sliding out of the window
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                currVowels--;
            }

            maxVowels = Math.max(maxVowels, currVowels);
        }

        return maxVowels;
    }

    public static void main(String[] args) {
        Solution1456 solver = new Solution1456();

        System.out.println(solver.maxVowels("abciiidef", 3)); // Output: 3
        System.out.println(solver.maxVowels("aeiou", 2));      // Output: 2
        System.out.println(solver.maxVowels("leetcode", 3));   // Output: 2
    }
}

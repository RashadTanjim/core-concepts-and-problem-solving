package leetcode;

public class Solution383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count occurrences of characters in the magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a'] = count[c - 'a'] + 1;
        }

        // Check if we can construct the ransomNote from the magazine
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false; // Not enough characters in magazine
            }
            count[c - 'a']--;
        }

        return true;
    }

}

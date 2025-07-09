package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution387 {

    // Brute Force Approach
    public static int firstUniqCharBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return i;
        }
        return -1;
    }

    // Optimal: HashMap Two Passes
    public static int firstUniqCharHashMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // Optimal: Array of 26 (since only lowercase)
    public static int firstUniqCharArray(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Using Brute Force:");
        System.out.println(firstUniqCharBruteForce(s1)); // 0
        System.out.println(firstUniqCharBruteForce(s2)); // 2
        System.out.println(firstUniqCharBruteForce(s3)); // -1

        System.out.println("\nUsing HashMap:");
        System.out.println(firstUniqCharHashMap(s1)); // 0
        System.out.println(firstUniqCharHashMap(s2)); // 2
        System.out.println(firstUniqCharHashMap(s3)); // -1

        System.out.println("\nUsing Array of 26:");
        System.out.println(firstUniqCharArray(s1)); // 0
        System.out.println(firstUniqCharArray(s2)); // 2
        System.out.println(firstUniqCharArray(s3)); // -1
    }
}

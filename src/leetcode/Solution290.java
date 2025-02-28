package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s)); // true
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> mappedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false; // Conflict in mapping
            } else {
                if (mappedWords.contains(word))
                    return false; // Prevent multiple mappings

                map.put(c, word);
                mappedWords.add(word);
            }
        }
        return true;
    }
}

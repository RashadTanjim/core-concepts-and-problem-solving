package leetcode;

import java.util.*;

public class Solution49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            // Count frequency of each letter in the string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}

//Map<String, List<String>> words = new HashMap<>();
//
//        for (String str : strs) {
//char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//
//String word = new String(chars);
//            if (!words.containsKey(word)) {
//        words.put(word, new ArrayList<>());
//        }
//
//        words.get(word).add(str);
//        }
//
//                return new ArrayList<>(words.values());
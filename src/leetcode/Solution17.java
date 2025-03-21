package leetcode;

import java.util.*;

public class Solution17 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        Map<Character, String> phoneMap = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

        // Backtracking (DFS)
        List<String> result = new ArrayList<>();
        backtrack(result, digits, phoneMap, new StringBuilder(), 0);
        return result;

        // BFS (Queue-based)
//        Queue<String> queue = new LinkedList<>();
//        queue.offer("");
//
//        for (char digit : digits.toCharArray()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String prefix = queue.poll();
//                for (char letter : phoneMap.get(digit).toCharArray()) {
//                    queue.offer(prefix + letter);
//                }
//            }
//        }
    }

    private static void backtrack(List<String> result,
                                  String digits,
                                  Map<Character, String> phoneMap,
                                  StringBuilder path,
                                  int index) {

        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(result, digits, phoneMap, path, index + 1);
            path.deleteCharAt(path.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(""));   // []
        System.out.println(letterCombinations("2"));  // ["a","b","c"]
    }
}

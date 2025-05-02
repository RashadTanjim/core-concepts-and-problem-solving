package leetcode;

import java.util.*;

public class Solution131 {

    public List<List<String>> partition(String s) {
        return dfs(s, 0, new HashMap<>());
    }

    private List<List<String>> dfs(String s, int start, Map<Integer, List<List<String>>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<List<String>> result = new ArrayList<>();
        if (start == s.length()) {
            result.add(new ArrayList<>());
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {
                String prefix = s.substring(start, end + 1);

                for (List<String> sub : dfs(s, end + 1, memo)) {
                    List<String> newList = new ArrayList<>();
                    newList.add(prefix);
                    newList.addAll(sub);
                    result.add(newList);
                }
            }
        }

        memo.put(start, result);
        return result;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 solution = new Solution131();
        System.out.println("Memoized partitions of 'aab': " + solution.partition("aab"));
        System.out.println("Memoized partitions of 'banana': " + solution.partition("banana"));
    }
}

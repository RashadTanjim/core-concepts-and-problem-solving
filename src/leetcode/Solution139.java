package leetcode;

import java.util.*;

public class Solution139 {

//    public boolean wordBreak(String s, List<String> wordDict) { // Bottom-Up DP (Tabulation)
//        Set<String> wordSet = new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//
//                if (dp[j] && wordSet.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return dp[s.length()];
//    }

    public boolean wordBreak(String s, List<String> wordDict) { // Top-Down DP (Memoization)
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return canBreak(s, wordSet, 0, memo);
    }

    private boolean canBreak(String s, Set<String> wordSet, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);

            if (wordSet.contains(prefix) && canBreak(s, wordSet, end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution139 solver = new Solution139();

        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        boolean canSegment = solver.wordBreak(s, dict);
        System.out.println("Can the word be segmented? " + canSegment);
    }
}

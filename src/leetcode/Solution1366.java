package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1366 {

    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) return "";

        int numPositions = votes[0].length();
        Map<Character, int[]> countMap = new HashMap<>();

        for (char c : votes[0].toCharArray()) {
            countMap.put(c, new int[numPositions]);
        }

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                countMap.get(team)[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(countMap.keySet());
        teams.sort((a, b) -> {
            for (int i = 0; i < numPositions; i++) {
                if (countMap.get(a)[i] != countMap.get(b)[i]) {
                    return countMap.get(b)[i] - countMap.get(a)[i];
                }
            }
            return Character.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1366 solver = new Solution1366();

        String[] votes1 = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(solver.rankTeams(votes1)); // Output: ACB

        String[] votes2 = {"WXYZ", "XYZW"};
        System.out.println(solver.rankTeams(votes2)); // Output: XWYZ
    }
}

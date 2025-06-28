package leetcode;

public class Solution1366 {
    public String[] rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] count = new int[n][26]; // 26 letters for each team

        // Count votes for each team
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                count[i][vote.charAt(i) - 'A']++;
            }
        }

        // Create an array of teams with their scores
        String[] teams = new String[n];
        for (int i = 0; i < n; i++) {
            teams[i] = String.valueOf((char) ('A' + i));
        }

        // Sort teams based on the counts
        java.util.Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (count[i][a.charAt(0) - 'A'] != count[i][b.charAt(0) - 'A']) {
                    return count[i][b.charAt(0) - 'A'] - count[i][a.charAt(0) - 'A'];
                }
            }
            return a.compareTo(b); // If counts are equal, sort alphabetically
        });

        return teams;
    }

    public static void main(String[] args) {
        Solution1366 solution = new Solution1366();
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String[] result = solution.rankTeams(votes);
        for (String team : result) {
            System.out.print(team + " ");
        }
        // Expected output: A B C
    }
}

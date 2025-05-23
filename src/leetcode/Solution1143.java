package leetcode;

public class Solution1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Always use smaller string for column to optimize space
        if (n > m) {
            return longestCommonSubsequence(text2, text1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, add 1 to the result from the previous characters
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1]; // LCS length increases
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]); // LCS length remains the same
                }
            }

            // Swap references (rolling arrays)
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Length of LCS: " + result);  // Output: 3
    }
}

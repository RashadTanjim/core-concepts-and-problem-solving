package leetcode;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabdcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

//        int left = 0, maxLength = 0;
//        HashSet<Character> charSet = new HashSet<>();
//
//        for (int right = 0; right < s.length(); right++) {
//
//            while (charSet.contains(s.charAt(right))) {
//                charSet.remove(s.charAt(left));
//                left++;
//            }
//
//            charSet.add(s.charAt(right));
//            maxLength = Math.max(maxLength, right - left + 1);
//        }

        int[] charIndex = new int[128]; // ASCII characters
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, charIndex[s.charAt(right)]);
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[s.charAt(right)] = right + 1;
        }

        return maxLength;
    }
}

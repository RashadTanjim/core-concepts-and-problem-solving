import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, s.length());
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 'a';
            first[letter] = Math.min(first[letter], i);
            last[letter] = i;
        }

        List<String> answer = new ArrayList<>();
        int previousEnd = -1;
        for (int start = 0; start < s.length(); start++) {
            int letter = s.charAt(start) - 'a';
            if (first[letter] != start) {
                continue;
            }

            int end = expandInterval(s, start, last, first);
            if (end == -1) {
                continue;
            }
            if (start > previousEnd) {
                answer.add(s.substring(start, end + 1));
            } else {
                answer.set(answer.size() - 1, s.substring(start, end + 1));
            }
            previousEnd = end;
        }
        return answer;
    }

    private int expandInterval(String s, int start, int[] last, int[] first) {
        int end = last[s.charAt(start) - 'a'];
        for (int i = start; i <= end; i++) {
            int letter = s.charAt(i) - 'a';
            if (first[letter] < start) {
                return -1;
            }
            end = Math.max(end, last[letter]);
        }
        return end;
    }
}

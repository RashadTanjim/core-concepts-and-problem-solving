package leetcode;

import java.util.*;

public class Solution763 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        // Step 1: Store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;

        // Step 2: Partition greedily
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);  // Update the end index of the current partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> partitions = partitionLabels(s);
        System.out.println("Partition sizes: " + partitions); // [9, 7, 8]

        // Explanation: The partitions are "ababcbaca", "defegde", "hijhklij"
        // with sizes 9, 7, and 8 respectively.
        // The first partition contains all occurrences of 'a', 'b', and 'c'.
        // The second partition contains all occurrences of 'd', 'e', 'f', and 'g'.
        // The third partition contains all occurrences of 'h', 'i', 'j', and 'k'.
        // The last partition contains all occurrences of 'l' and 'j'.
        // The output is the sizes of these partitions.
        // The expected output is [9, 7, 8].
    }
}

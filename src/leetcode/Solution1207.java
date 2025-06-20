package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> seenFrequencies = new HashSet<>();
        for (int count : freqMap.values()) {
            if (!seenFrequencies.add(count)) {
                return false; // duplicate frequency found
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution1207 solver = new Solution1207();

        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2, 2, 1, 1, 2};

        System.out.println(solver.uniqueOccurrences(arr1)); // true
        System.out.println(solver.uniqueOccurrences(arr2)); // false
    }
}

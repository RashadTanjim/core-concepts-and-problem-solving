package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        List<Integer> onlyInNums1 = new ArrayList<>();
        List<Integer> onlyInNums2 = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n)) {
                onlyInNums1.add(n);
            }
        }

        for (int n : set2) {
            if (!set1.contains(n)) {
                onlyInNums2.add(n);
            }
        }

        return List.of(onlyInNums1, onlyInNums2);
    }

    public static void main(String[] args) {
        Solution2215 solver = new Solution2215();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        System.out.println(solver.findDifference(nums1, nums2));
        // Output: [[1, 3], [4, 6]]
    }
}

package leetcode;

import java.util.*;

public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) continue;  // Skip duplicates

            if (candidates[i] > target) break; // pruning

            path.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], path, result);
            path.removeLast(); // backtrack
        }
    }

    public static void main(String[] args) {
        Solution40 solver = new Solution40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solver.combinationSum2(candidates, target);

        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }
}

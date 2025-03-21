package leetcode;

import java.util.*;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void backtrack(int start, List<Integer> path, int n, int k, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, path, n, k, result);
            path.removeLast(); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution77 sol = new Solution77();
        System.out.println(sol.combine(4, 2)); // [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
    }
}

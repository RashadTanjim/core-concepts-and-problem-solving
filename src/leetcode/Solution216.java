package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(result, tempList, k, remain - i, i + 1);
            tempList.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution216 solution = new Solution216();
        List<List<Integer>> result = solution.combinationSum3(3, 7);
        System.out.println(result); // Expected output: [[1, 2, 4]]
    }
}

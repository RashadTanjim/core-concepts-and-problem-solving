package leetcode;

import java.util.*;

public class Solution1466 {

    public int minReorder(int n, int[][] connections) {
        // Step 1: Build the graph
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];
            graph[from].add(to);    // Edge exists: from → to
            graph[to].add(-from);   // Add reverse edge as negative to track direction
        }

        // Step 2: Start DFS from node 0
        return dfs(graph, 0, -1);
    }

    private int dfs(List<Integer>[] graph, int current, int parent) {
        int reversals = 0;

        for (int neighbor : graph[current]) {
            int next = Math.abs(neighbor);

            if (next == parent) continue;

            // If neighbor is positive, it's in original direction current → next → needs reversal
            if (neighbor > 0) reversals++;

            reversals += dfs(graph, next, current);
        }

        return reversals;
    }

    public static void main(String[] args) {
        Solution1466 sol = new Solution1466();
        int n = 6;
        int[][] connections = {
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        };

        int result = sol.minReorder(n, connections);
        System.out.println("Minimum edges to reverse: " + result); // Output: 3
    }
}

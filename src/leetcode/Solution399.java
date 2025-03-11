package leetcode;

import java.util.*;

public class Solution399 {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Step 1: Build the Graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // Step 2: Process Queries using DFS
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            results[i] = dfs(start, end, new HashSet<>());
        }

        return results;
    }

    private double dfs(String start, String end, Set<String> visited) {

        // If nodes are not in graph, return -1
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;

        // If start and end are the same, return 1.0
        if (start.equals(end)) return 1.0;

        visited.add(start);
        Map<String, Double> neighbors = graph.get(start);

        for (String neighbor : neighbors.keySet()) {

            if (!visited.contains(neighbor)) {
                double weight = neighbors.get(neighbor);
                double result = dfs(neighbor, end, visited);

                if (result != -1.0) return weight * result;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Solution399 solution = new Solution399();

        // Example: a / b = 2.0, b / c = 3.0
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );

        double[] values = {2.0, 3.0};

        // Queries: a / c, b / a, a / e, a / a, x / x
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        // Calculate results
        double[] results = solution.calcEquation(equations, values, queries);

        // Print output
        System.out.println(Arrays.toString(results));
    }

//    Input: equations = [["a","b"],["b","c"]],
//    values = [2.0,3.0],
//    queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]
//
//    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
}
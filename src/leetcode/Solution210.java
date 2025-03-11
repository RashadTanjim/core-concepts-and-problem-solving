package leetcode;

import java.util.*;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Build graph and in-degree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0], prerequisite = pre[1];
            graph.putIfAbsent(prerequisite, new ArrayList<>());
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // Step 2: Find courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Step 3: Process courses in BFS order
        int[] order = new int[numCourses];
        int index = 0; // To track course order
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr; // Add course to order list

            if (graph.containsKey(curr)) {
                for (int neighbor : graph.get(curr)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) queue.offer(neighbor);
                }
            }
        }

        return index == numCourses ? order : new int[0]; // If all courses are processed, return order
    }

    public static void main(String[] args) {
        Solution210 solution = new Solution210();

        // Test Case 1: Valid order exists
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses1, prerequisites1)));
        // Output: [0,1,2,3] or [0,2,1,3]

        // Test Case 2: No valid order (cycle exists)
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses2, prerequisites2)));
        // Output: []

        // Test Case 3: No prerequisites (any order is valid)
        int numCourses3 = 3;
        int[][] prerequisites3 = {};
        System.out.println(Arrays.toString(solution.findOrder(numCourses3, prerequisites3)));
        // Output: [0,1,2] or any permutation
    }
}


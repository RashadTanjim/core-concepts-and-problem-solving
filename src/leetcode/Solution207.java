package leetcode;

import java.util.*;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph and in-degree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0], prerequisite = pre[1];
            graph.putIfAbsent(prerequisite, new ArrayList<>());
            graph.get(prerequisite).add(course);
            inDegree[course]++; // Increment in-degree for this course
        }

        // Step 2: Find courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Step 3: Process courses in BFS order
        int count = 0;  // Track how many courses we can complete
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++; // One course completed

            if (graph.containsKey(curr)) {
                for (int neighbor : graph.get(curr)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) queue.offer(neighbor);
                }
            }
        }

        return count == numCourses; // If we finished all courses, return true
    }

    public static void main(String[] args) {
        Solution207 solution = new Solution207();

        // Test Case 1: Can finish all courses
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(solution.canFinish(numCourses1, prerequisites1)); // Output: true

        // Test Case 2: Cycle detected, cannot finish all courses
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses2, prerequisites2)); // Output: false

        // Test Case 3: Multiple independent courses
        int numCourses3 = 5;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(solution.canFinish(numCourses3, prerequisites3)); // Output: true
    }
}
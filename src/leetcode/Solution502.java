package leetcode;

import java.util.*;

public class Solution502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        Project[] projects = new Project[n];

        // Create project objects and sort by capital needed
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {

            // Add all projects that can be started with current capital
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxHeap.offer(projects[projectIndex].profit);
                projectIndex++;
            }

            // If no projects can be started, break early
            if (maxHeap.isEmpty()) {
                break;
            }

            // Choose the most profitable project
            w += maxHeap.poll();
        }

        return w;
    }

    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Solution502 sol = new Solution502();

        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int finalCapital = sol.findMaximizedCapital(k, w, profits, capital);
        System.out.println("Final Capital: " + finalCapital); // Expected: 4
    }
}

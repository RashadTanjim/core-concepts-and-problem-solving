package leetcode;

import leetcode.helper.Node3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution133 {
    private final Map<Node3, Node3> clonedNodes = new HashMap<>();

    public Node3 cloneGraph(Node3 node) {
        if (node == null) return null;

        // If the node is already cloned, return the clone
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        // Clone the node and store in map
        Node3 clone = new Node3(node.val);
        clonedNodes.put(node, clone);

        // Clone all the neighbors recursively
        for (Node3 neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Node3 node1 = new Node3(1);
        Node3 node2 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node4 = new Node3(4);

        // Define the connections (undirected graph)
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Create Solution instance
        Solution133 solution = new Solution133();

        // Clone the graph
        Node3 clonedGraph = solution.cloneGraph(node1);

        // Print original and cloned graphs
        System.out.println("Original Graph:");
        printGraph(node1, new HashSet<>());

        System.out.println("\nCloned Graph:");
        printGraph(clonedGraph, new HashSet<>());
    }

    // Helper function to print graph using DFS
    public static void printGraph(Node3 node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) return;

        visited.add(node.val);
        System.out.print("Node " + node.val + " -> [");
        for (Node3 neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println("]");

        for (Node3 neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}

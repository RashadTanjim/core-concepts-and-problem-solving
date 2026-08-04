// Local stand-ins for types supplied by the LeetCode judge.

class Node {
    int val;
    java.util.List<Node> neighbors;

    Node() { this(0); }
    Node(int val) { this(val, new java.util.ArrayList<>()); }
    Node(int val, java.util.ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

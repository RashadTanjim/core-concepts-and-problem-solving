package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class Node3 {
    public int val;
    public List<Node3> neighbors;

    public Node3() {
        val = 0;
        neighbors = new ArrayList<Node3>();
    }

    public Node3(int _val) {
        val = _val;
        neighbors = new ArrayList<Node3>();
    }

    public Node3(int _val, ArrayList<Node3> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

package leetcode.helper;

public class QuadTree {  // Node
    public boolean val;
    public boolean isLeaf;
    public QuadTree topLeft;
    public QuadTree topRight;
    public QuadTree bottomLeft;
    public QuadTree bottomRight;


    public QuadTree() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTree(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTree(boolean val, boolean isLeaf, QuadTree topLeft, QuadTree topRight, QuadTree bottomLeft, QuadTree bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

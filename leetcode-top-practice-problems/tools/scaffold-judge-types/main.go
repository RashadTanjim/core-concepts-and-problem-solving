package main

import (
	"fmt"
	"os"
	"path/filepath"
	"regexp"
	"strings"
)

var packagePattern = regexp.MustCompile(`(?m)^package ([A-Za-z0-9_]+)$`)

func main() {
	entries, err := os.ReadDir(".")
	if err != nil {
		panic(err)
	}
	for _, entry := range entries {
		if !entry.IsDir() {
			continue
		}
		path := filepath.Join(entry.Name(), "solution.go")
		source, err := os.ReadFile(path)
		if err != nil {
			continue
		}
		match := packagePattern.FindSubmatch(source)
		if len(match) != 2 {
			panic(fmt.Sprintf("package declaration missing in %s", path))
		}

		definitions := make([]string, 0, 2)
		text := string(source)
		if strings.Contains(text, "ListNode") {
			definitions = append(definitions, `// ListNode is supplied by LeetCode for linked-list problems.
type ListNode struct {
	Val  int
	Next *ListNode
}`)
		}
		if strings.Contains(text, "TreeNode") {
			definitions = append(definitions, `// TreeNode is supplied by LeetCode for binary-tree problems.
type TreeNode struct {
	Val         int
	Left, Right *TreeNode
}`)
		}

		switch {
		case strings.HasPrefix(entry.Name(), "0116-"), strings.HasPrefix(entry.Name(), "0117-"):
			definitions = append(definitions, `// Node is supplied by LeetCode for next-pointer tree problems.
type Node struct {
	Val               int
	Left, Right, Next *Node
}`)
		case strings.HasPrefix(entry.Name(), "0133-"):
			definitions = append(definitions, `// Node is supplied by LeetCode for graph problems.
type Node struct {
	Val       int
	Neighbors []*Node
}`)
		case strings.HasPrefix(entry.Name(), "0138-"):
			definitions = append(definitions, `// Node is supplied by LeetCode for random-pointer list problems.
type Node struct {
	Val          int
	Next, Random *Node
}`)
		case strings.HasPrefix(entry.Name(), "0427-"):
			definitions = append(definitions, `// Node is supplied by LeetCode for quad-tree problems.
type Node struct {
	Val, IsLeaf                                      bool
	TopLeft, TopRight, BottomLeft, BottomRight *Node
}`)
		}

		switch {
		case strings.HasPrefix(entry.Name(), "0278-"):
			definitions = append(definitions, `// isBadVersion is replaced by the LeetCode judge callback during submission.
var isBadVersion = func(version int) bool { return false }`)
		case strings.HasPrefix(entry.Name(), "0374-"):
			definitions = append(definitions, `// guess is replaced by the LeetCode judge callback during submission.
var guess = func(number int) int { return 0 }`)
		}

		if len(definitions) == 0 {
			// Java may still need a judge callback even when Go uses a function value.
		} else {
			output := "package " + string(match[1]) + "\n\n" + strings.Join(definitions, "\n\n") + "\n"
			if err := os.WriteFile(filepath.Join(entry.Name(), "types.go"), []byte(output), 0o644); err != nil {
				panic(err)
			}
		}

		javaSource, err := os.ReadFile(filepath.Join(entry.Name(), "Solution.java"))
		if err != nil {
			continue
		}
		javaDefinitions := javaJudgeTypes(entry.Name(), string(javaSource))
		if len(javaDefinitions) > 0 {
			output := "// Local stand-ins for types supplied by the LeetCode judge.\n\n" + strings.Join(javaDefinitions, "\n\n") + "\n"
			if err := os.WriteFile(filepath.Join(entry.Name(), "Types.java"), []byte(output), 0o644); err != nil {
				panic(err)
			}
		}
	}
}

func javaJudgeTypes(dir, source string) []string {
	definitions := make([]string, 0, 2)
	if strings.Contains(source, "ListNode") {
		definitions = append(definitions, `class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}`)
	}
	if strings.Contains(source, "TreeNode") {
		definitions = append(definitions, `class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}`)
	}

	switch {
	case strings.HasPrefix(dir, "0116-"), strings.HasPrefix(dir, "0117-"):
		definitions = append(definitions, `class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}`)
	case strings.HasPrefix(dir, "0133-"):
		definitions = append(definitions, `class Node {
    int val;
    java.util.List<Node> neighbors;

    Node() { this(0); }
    Node(int val) { this(val, new java.util.ArrayList<>()); }
    Node(int val, java.util.ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}`)
	case strings.HasPrefix(dir, "0138-"):
		definitions = append(definitions, `class Node {
    int val;
    Node next;
    Node random;

    Node(int val) { this.val = val; }
}`)
	case strings.HasPrefix(dir, "0427-"):
		definitions = append(definitions, `class Node {
    boolean val;
    boolean isLeaf;
    Node topLeft;
    Node topRight;
    Node bottomLeft;
    Node bottomRight;

    Node() {}
    Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }
    Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}`)
	}

	switch {
	case strings.HasPrefix(dir, "0278-"):
		definitions = append(definitions, `class VersionControl {
    boolean isBadVersion(int version) { return false; }
}`)
	case strings.HasPrefix(dir, "0374-"):
		definitions = append(definitions, `class GuessGame {
    int guess(int number) { return 0; }
}`)
	}

	return definitions
}

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
			continue
		}
		output := "package " + string(match[1]) + "\n\n" + strings.Join(definitions, "\n\n") + "\n"
		if err := os.WriteFile(filepath.Join(entry.Name(), "types.go"), []byte(output), 0o644); err != nil {
			panic(err)
		}
	}
}

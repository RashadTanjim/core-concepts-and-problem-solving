package p0427

// Node is supplied by LeetCode for quad-tree problems.
type Node struct {
	Val, IsLeaf                                bool
	TopLeft, TopRight, BottomLeft, BottomRight *Node
}

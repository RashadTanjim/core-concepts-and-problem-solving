# LeetCode Top Practice Problems in Go

Complete Go coverage of the shared [LeetCode problem list](https://leetcode.com/problem-list/24s7vlue/), organized as one independently compilable package per problem.

- Total: **333**
- Easy: **85**
- Medium: **204**
- Hard: **44**

## How to use this repository

1. Open a problem directory and read `README.md` for the prompt summary.
2. Work through `solution.md` from brute force to the optimized invariant.
3. Reimplement from memory, then compare with `solution.go`.
4. Run `go test ./...` from this directory to compile every package and run repository checks.

LeetCode supplies some node types and callback APIs. Their local equivalents live in `types.go`; submit only the imports and implementation from `solution.go`.

## Problems

| List order | # | Problem | Solution | Difficulty | Approach |
|---:|---:|---|---|---|---|
| 1 | 1 | [Two Sum](./0001-two-sum/) | [Approach](./0001-two-sum/solution.md) | Easy | Hash Table |
| 2 | 2 | [Add Two Numbers](./0002-add-two-numbers/) | [Approach](./0002-add-two-numbers/solution.md) | Medium | Simulation |
| 3 | 3 | [Longest Substring Without Repeating Characters](./0003-longest-substring-without-repeating-characters/) | [Approach](./0003-longest-substring-without-repeating-characters/solution.md) | Medium | Sliding Window |
| 4 | 4 | [Median of Two Sorted Arrays](./0004-median-of-two-sorted-arrays/) | [Approach](./0004-median-of-two-sorted-arrays/solution.md) | Hard | Divide and Conquer |
| 5 | 5 | [Longest Palindromic Substring](./0005-longest-palindromic-substring/) | [Approach](./0005-longest-palindromic-substring/solution.md) | Medium | Dynamic Programming |
| 6 | 6 | [Zigzag Conversion](./0006-zigzag-conversion/) | [Approach](./0006-zigzag-conversion/solution.md) | Medium | Simulation |
| 7 | 7 | [Reverse Integer](./0007-reverse-integer/) | [Approach](./0007-reverse-integer/solution.md) | Medium | Mathematics |
| 8 | 8 | [String to Integer (atoi)](./0008-string-to-integer-atoi/) | [Approach](./0008-string-to-integer-atoi/solution.md) | Medium | Traverse the String |
| 9 | 9 | [Palindrome Number](./0009-palindrome-number/) | [Approach](./0009-palindrome-number/solution.md) | Easy | Reverse Half of the Number |
| 10 | 10 | [Regular Expression Matching](./0010-regular-expression-matching/) | [Approach](./0010-regular-expression-matching/solution.md) | Hard | Memoization Search |
| 11 | 11 | [Container With Most Water](./0011-container-with-most-water/) | [Approach](./0011-container-with-most-water/solution.md) | Medium | Two Pointers |
| 12 | 12 | [Integer to Roman](./0012-integer-to-roman/) | [Approach](./0012-integer-to-roman/solution.md) | Medium | Greedy |
| 13 | 13 | [Roman to Integer](./0013-roman-to-integer/) | [Approach](./0013-roman-to-integer/solution.md) | Easy | Hash Table + Simulation |
| 14 | 14 | [Longest Common Prefix](./0014-longest-common-prefix/) | [Approach](./0014-longest-common-prefix/solution.md) | Easy | Character Comparison |
| 15 | 15 | [3Sum](./0015-3sum/) | [Approach](./0015-3sum/solution.md) | Medium | Sort + Two Pointers |
| 16 | 17 | [Letter Combinations of a Phone Number](./0017-letter-combinations-of-a-phone-number/) | [Approach](./0017-letter-combinations-of-a-phone-number/solution.md) | Medium | Traversal |
| 17 | 18 | [4Sum](./0018-4sum/) | [Approach](./0018-4sum/solution.md) | Medium | Sorting + Double Pointers |
| 18 | 19 | [Remove Nth Node From End of List](./0019-remove-nth-node-from-end-of-list/) | [Approach](./0019-remove-nth-node-from-end-of-list/solution.md) | Medium | Fast and Slow Pointers |
| 19 | 20 | [Valid Parentheses](./0020-valid-parentheses/) | [Approach](./0020-valid-parentheses/solution.md) | Easy | Stack |
| 20 | 21 | [Merge Two Sorted Lists](./0021-merge-two-sorted-lists/) | [Approach](./0021-merge-two-sorted-lists/solution.md) | Easy | Recursion |
| 21 | 22 | [Generate Parentheses](./0022-generate-parentheses/) | [Approach](./0022-generate-parentheses/solution.md) | Medium | DFS + Pruning |
| 22 | 23 | [Merge k Sorted Lists](./0023-merge-k-sorted-lists/) | [Approach](./0023-merge-k-sorted-lists/solution.md) | Hard | Priority Queue (Min Heap) |
| 23 | 24 | [Swap Nodes in Pairs](./0024-swap-nodes-in-pairs/) | [Approach](./0024-swap-nodes-in-pairs/solution.md) | Medium | Recursion |
| 24 | 25 | [Reverse Nodes in k-Group](./0025-reverse-nodes-in-k-group/) | [Approach](./0025-reverse-nodes-in-k-group/solution.md) | Hard | Simulation |
| 25 | 26 | [Remove Duplicates from Sorted Array](./0026-remove-duplicates-from-sorted-array/) | [Approach](./0026-remove-duplicates-from-sorted-array/solution.md) | Easy | Single Pass |
| 26 | 27 | [Remove Element](./0027-remove-element/) | [Approach](./0027-remove-element/solution.md) | Easy | One Pass |
| 27 | 28 | [Find the Index of the First Occurrence in a String](./0028-find-the-index-of-the-first-occurrence-in-a-string/) | [Approach](./0028-find-the-index-of-the-first-occurrence-in-a-string/solution.md) | Easy | Traversal |
| 28 | 30 | [Substring with Concatenation of All Words](./0030-substring-with-concatenation-of-all-words/) | [Approach](./0030-substring-with-concatenation-of-all-words/solution.md) | Hard | Hash Table + Sliding Window |
| 29 | 31 | [Next Permutation](./0031-next-permutation/) | [Approach](./0031-next-permutation/solution.md) | Medium | Two traversals |
| 30 | 32 | [Longest Valid Parentheses](./0032-longest-valid-parentheses/) | [Approach](./0032-longest-valid-parentheses/solution.md) | Hard | Dynamic Programming |
| 31 | 33 | [Search in Rotated Sorted Array](./0033-search-in-rotated-sorted-array/) | [Approach](./0033-search-in-rotated-sorted-array/solution.md) | Medium | Binary Search |
| 32 | 35 | [Search Insert Position](./0035-search-insert-position/) | [Approach](./0035-search-insert-position/solution.md) | Easy | Binary Search |
| 33 | 36 | [Valid Sudoku](./0036-valid-sudoku/) | [Approach](./0036-valid-sudoku/solution.md) | Medium | Traversal once |
| 34 | 37 | [Sudoku Solver](./0037-sudoku-solver/) | [Approach](./0037-sudoku-solver/solution.md) | Hard | Backtracking |
| 35 | 38 | [Count and Say](./0038-count-and-say/) | [Approach](./0038-count-and-say/solution.md) | Medium | Simulation |
| 36 | 39 | [Combination Sum](./0039-combination-sum/) | [Approach](./0039-combination-sum/solution.md) | Medium | Sorting + Pruning + Backtracking |
| 37 | 40 | [Combination Sum II](./0040-combination-sum-ii/) | [Approach](./0040-combination-sum-ii/solution.md) | Medium | Sorting + Pruning + Backtracking |
| 38 | 41 | [First Missing Positive](./0041-first-missing-positive/) | [Approach](./0041-first-missing-positive/solution.md) | Hard | In-place Swap |
| 39 | 42 | [Trapping Rain Water](./0042-trapping-rain-water/) | [Approach](./0042-trapping-rain-water/solution.md) | Hard | Dynamic Programming |
| 40 | 43 | [Multiply Strings](./0043-multiply-strings/) | [Approach](./0043-multiply-strings/solution.md) | Medium | Simulating Mathematical Multiplication |
| 41 | 45 | [Jump Game II](./0045-jump-game-ii/) | [Approach](./0045-jump-game-ii/solution.md) | Medium | Greedy Algorithm |
| 42 | 46 | [Permutations](./0046-permutations/) | [Approach](./0046-permutations/solution.md) | Medium | DFS (Backtracking) |
| 43 | 48 | [Rotate Image](./0048-rotate-image/) | [Approach](./0048-rotate-image/solution.md) | Medium | In-place Rotation |
| 44 | 49 | [Group Anagrams](./0049-group-anagrams/) | [Approach](./0049-group-anagrams/solution.md) | Medium | Hash Table |
| 45 | 50 | [Pow(x, n)](./0050-powx-n/) | [Approach](./0050-powx-n/solution.md) | Medium | Mathematics (Fast Powering) |
| 46 | 51 | [N-Queens](./0051-n-queens/) | [Approach](./0051-n-queens/solution.md) | Hard | DFS (Backtracking) |
| 47 | 52 | [N-Queens II](./0052-n-queens-ii/) | [Approach](./0052-n-queens-ii/solution.md) | Hard | Backtracking |
| 48 | 53 | [Maximum Subarray](./0053-maximum-subarray/) | [Approach](./0053-maximum-subarray/solution.md) | Medium | Dynamic Programming |
| 49 | 54 | [Spiral Matrix](./0054-spiral-matrix/) | [Approach](./0054-spiral-matrix/solution.md) | Medium | Simulation |
| 50 | 55 | [Jump Game](./0055-jump-game/) | [Approach](./0055-jump-game/solution.md) | Medium | Greedy |
| 51 | 56 | [Merge Intervals](./0056-merge-intervals/) | [Approach](./0056-merge-intervals/solution.md) | Medium | Sorting + One-pass Traversal |
| 52 | 57 | [Insert Interval](./0057-insert-interval/) | [Approach](./0057-insert-interval/solution.md) | Medium | Sorting + Interval Merging |
| 53 | 58 | [Length of Last Word](./0058-length-of-last-word/) | [Approach](./0058-length-of-last-word/solution.md) | Easy | Reverse Traversal + Two Pointers |
| 54 | 62 | [Unique Paths](./0062-unique-paths/) | [Approach](./0062-unique-paths/solution.md) | Medium | Dynamic Programming |
| 55 | 61 | [Rotate List](./0061-rotate-list/) | [Approach](./0061-rotate-list/solution.md) | Medium | Fast and Slow Pointers + Link List Concatenation |
| 56 | 60 | [Permutation Sequence](./0060-permutation-sequence/) | [Approach](./0060-permutation-sequence/solution.md) | Hard | Enumeration |
| 57 | 63 | [Unique Paths II](./0063-unique-paths-ii/) | [Approach](./0063-unique-paths-ii/solution.md) | Medium | Memoization Search |
| 58 | 66 | [Plus One](./0066-plus-one/) | [Approach](./0066-plus-one/solution.md) | Easy | Simulation |
| 59 | 67 | [Add Binary](./0067-add-binary/) | [Approach](./0067-add-binary/solution.md) | Easy | Simulation |
| 60 | 68 | [Text Justification](./0068-text-justification/) | [Approach](./0068-text-justification/solution.md) | Hard | Simulation |
| 61 | 69 | [Sqrt(x)](./0069-sqrtx/) | [Approach](./0069-sqrtx/solution.md) | Easy | Binary Search |
| 62 | 70 | [Climbing Stairs](./0070-climbing-stairs/) | [Approach](./0070-climbing-stairs/solution.md) | Easy | Recursion |
| 63 | 71 | [Simplify Path](./0071-simplify-path/) | [Approach](./0071-simplify-path/solution.md) | Medium | Stack |
| 64 | 72 | [Edit Distance](./0072-edit-distance/) | [Approach](./0072-edit-distance/solution.md) | Medium | Dynamic Programming |
| 65 | 73 | [Set Matrix Zeroes](./0073-set-matrix-zeroes/) | [Approach](./0073-set-matrix-zeroes/solution.md) | Medium | Array Mark |
| 66 | 74 | [Search a 2D Matrix](./0074-search-a-2d-matrix/) | [Approach](./0074-search-a-2d-matrix/solution.md) | Medium | Binary Search |
| 67 | 75 | [Sort Colors](./0075-sort-colors/) | [Approach](./0075-sort-colors/solution.md) | Medium | Three Pointers |
| 68 | 76 | [Minimum Window Substring](./0076-minimum-window-substring/) | [Approach](./0076-minimum-window-substring/solution.md) | Hard | Counting + Two Pointers |
| 69 | 77 | [Combinations](./0077-combinations/) | [Approach](./0077-combinations/solution.md) | Medium | Backtracking (Two Ways) |
| 70 | 78 | [Subsets](./0078-subsets/) | [Approach](./0078-subsets/solution.md) | Medium | DFS (Backtracking) |
| 71 | 79 | [Word Search](./0079-word-search/) | [Approach](./0079-word-search/solution.md) | Medium | DFS (Backtracking) |
| 72 | 80 | [Remove Duplicates from Sorted Array II](./0080-remove-duplicates-from-sorted-array-ii/) | [Approach](./0080-remove-duplicates-from-sorted-array-ii/solution.md) | Medium | Single Pass |
| 73 | 82 | [Remove Duplicates from Sorted List II](./0082-remove-duplicates-from-sorted-list-ii/) | [Approach](./0082-remove-duplicates-from-sorted-list-ii/solution.md) | Medium | Single Pass |
| 74 | 84 | [Largest Rectangle in Histogram](./0084-largest-rectangle-in-histogram/) | [Approach](./0084-largest-rectangle-in-histogram/solution.md) | Hard | Monotonic Stack |
| 75 | 86 | [Partition List](./0086-partition-list/) | [Approach](./0086-partition-list/solution.md) | Medium | Simulation |
| 76 | 88 | [Merge Sorted Array](./0088-merge-sorted-array/) | [Approach](./0088-merge-sorted-array/solution.md) | Easy | Two Pointers |
| 77 | 90 | [Subsets II](./0090-subsets-ii/) | [Approach](./0090-subsets-ii/solution.md) | Medium | Sorting + DFS |
| 78 | 91 | [Decode Ways](./0091-decode-ways/) | [Approach](./0091-decode-ways/solution.md) | Medium | Dynamic Programming |
| 79 | 92 | [Reverse Linked List II](./0092-reverse-linked-list-ii/) | [Approach](./0092-reverse-linked-list-ii/solution.md) | Medium | Simulation |
| 80 | 94 | [Binary Tree Inorder Traversal](./0094-binary-tree-inorder-traversal/) | [Approach](./0094-binary-tree-inorder-traversal/solution.md) | Easy | Recursive Traversal |
| 81 | 97 | [Interleaving String](./0097-interleaving-string/) | [Approach](./0097-interleaving-string/solution.md) | Medium | Memoization Search |
| 82 | 98 | [Validate Binary Search Tree](./0098-validate-binary-search-tree/) | [Approach](./0098-validate-binary-search-tree/solution.md) | Medium | Recursion |
| 83 | 100 | [Same Tree](./0100-same-tree/) | [Approach](./0100-same-tree/solution.md) | Easy | DFS |
| 84 | 102 | [Binary Tree Level Order Traversal](./0102-binary-tree-level-order-traversal/) | [Approach](./0102-binary-tree-level-order-traversal/solution.md) | Medium | BFS |
| 85 | 104 | [Maximum Depth of Binary Tree](./0104-maximum-depth-of-binary-tree/) | [Approach](./0104-maximum-depth-of-binary-tree/solution.md) | Easy | Recursion |
| 86 | 105 | [Construct Binary Tree from Preorder and Inorder Traversal](./0105-construct-binary-tree-from-preorder-and-inorder-traversal/) | [Approach](./0105-construct-binary-tree-from-preorder-and-inorder-traversal/solution.md) | Medium | Hash Table + Recursion |
| 87 | 110 | [Balanced Binary Tree](./0110-balanced-binary-tree/) | [Approach](./0110-balanced-binary-tree/solution.md) | Easy | Bottom-Up Recursion |
| 88 | 115 | [Distinct Subsequences](./0115-distinct-subsequences/) | [Approach](./0115-distinct-subsequences/solution.md) | Hard | Dynamic Programming |
| 89 | 121 | [Best Time to Buy and Sell Stock](./0121-best-time-to-buy-and-sell-stock/) | [Approach](./0121-best-time-to-buy-and-sell-stock/solution.md) | Easy | Enumerate + Maintain the Minimum Value of the Prefix |
| 90 | 124 | [Binary Tree Maximum Path Sum](./0124-binary-tree-maximum-path-sum/) | [Approach](./0124-binary-tree-maximum-path-sum/solution.md) | Hard | Recursion |
| 91 | 125 | [Valid Palindrome](./0125-valid-palindrome/) | [Approach](./0125-valid-palindrome/solution.md) | Easy | Two Pointers |
| 92 | 127 | [Word Ladder](./0127-word-ladder/) | [Approach](./0127-word-ladder/solution.md) | Hard | BFS |
| 93 | 128 | [Longest Consecutive Sequence](./0128-longest-consecutive-sequence/) | [Approach](./0128-longest-consecutive-sequence/solution.md) | Medium | Hash Table |
| 94 | 130 | [Surrounded Regions](./0130-surrounded-regions/) | [Approach](./0130-surrounded-regions/solution.md) | Medium | Depth-First Search (DFS) |
| 95 | 131 | [Palindrome Partitioning](./0131-palindrome-partitioning/) | [Approach](./0131-palindrome-partitioning/solution.md) | Medium | Preprocessing + DFS (Backtracking) |
| 96 | 133 | [Clone Graph](./0133-clone-graph/) | [Approach](./0133-clone-graph/solution.md) | Medium | Hash Table + DFS |
| 97 | 134 | [Gas Station](./0134-gas-station/) | [Approach](./0134-gas-station/solution.md) | Medium | Greedy |
| 98 | 136 | [Single Number](./0136-single-number/) | [Approach](./0136-single-number/solution.md) | Easy | Bitwise Operation |
| 99 | 138 | [Copy List with Random Pointer](./0138-copy-list-with-random-pointer/) | [Approach](./0138-copy-list-with-random-pointer/solution.md) | Medium | Hash Table |
| 100 | 139 | [Word Break](./0139-word-break/) | [Approach](./0139-word-break/solution.md) | Medium | Dynamic Programming |
| 101 | 141 | [Linked List Cycle](./0141-linked-list-cycle/) | [Approach](./0141-linked-list-cycle/solution.md) | Easy | Hash Table |
| 102 | 143 | [Reorder List](./0143-reorder-list/) | [Approach](./0143-reorder-list/solution.md) | Medium | Fast and Slow Pointers + Reverse List + Merge Lists |
| 103 | 146 | [LRU Cache](./0146-lru-cache/) | [Approach](./0146-lru-cache/solution.md) | Medium | Hash Table + Doubly Linked List |
| 104 | 150 | [Evaluate Reverse Polish Notation](./0150-evaluate-reverse-polish-notation/) | [Approach](./0150-evaluate-reverse-polish-notation/solution.md) | Medium | Array Stack |
| 105 | 151 | [Reverse Words in a String](./0151-reverse-words-in-a-string/) | [Approach](./0151-reverse-words-in-a-string/solution.md) | Medium | Two Pointers |
| 106 | 153 | [Find Minimum in Rotated Sorted Array](./0153-find-minimum-in-rotated-sorted-array/) | [Approach](./0153-find-minimum-in-rotated-sorted-array/solution.md) | Medium | Binary Search |
| 107 | 152 | [Maximum Product Subarray](./0152-maximum-product-subarray/) | [Approach](./0152-maximum-product-subarray/solution.md) | Medium | Dynamic Programming |
| 108 | 155 | [Min Stack](./0155-min-stack/) | [Approach](./0155-min-stack/solution.md) | Medium | Data Structure Design |
| 109 | 167 | [Two Sum II - Input Array Is Sorted](./0167-two-sum-ii-input-array-is-sorted/) | [Approach](./0167-two-sum-ii-input-array-is-sorted/solution.md) | Medium | Binary Search |
| 110 | 190 | [Reverse Bits](./0190-reverse-bits/) | [Approach](./0190-reverse-bits/solution.md) | Easy | Bit Manipulation |
| 111 | 191 | [Number of 1 Bits](./0191-number-of-1-bits/) | [Approach](./0191-number-of-1-bits/solution.md) | Easy | Divide and Conquer |
| 112 | 198 | [House Robber](./0198-house-robber/) | [Approach](./0198-house-robber/solution.md) | Medium | Memoization Search |
| 113 | 199 | [Binary Tree Right Side View](./0199-binary-tree-right-side-view/) | [Approach](./0199-binary-tree-right-side-view/solution.md) | Medium | BFS |
| 114 | 200 | [Number of Islands](./0200-number-of-islands/) | [Approach](./0200-number-of-islands/solution.md) | Medium | DFS |
| 115 | 202 | [Happy Number](./0202-happy-number/) | [Approach](./0202-happy-number/solution.md) | Easy | Two Pointers |
| 116 | 206 | [Reverse Linked List](./0206-reverse-linked-list/) | [Approach](./0206-reverse-linked-list/solution.md) | Easy | Head Insertion Method |
| 117 | 207 | [Course Schedule](./0207-course-schedule/) | [Approach](./0207-course-schedule/solution.md) | Medium | Topological Sorting |
| 118 | 208 | [Implement Trie (Prefix Tree)](./0208-implement-trie-prefix-tree/) | [Approach](./0208-implement-trie-prefix-tree/solution.md) | Medium | Trie |
| 119 | 210 | [Course Schedule II](./0210-course-schedule-ii/) | [Approach](./0210-course-schedule-ii/solution.md) | Medium | Linear Scan |
| 120 | 211 | [Design Add and Search Words Data Structure](./0211-design-add-and-search-words-data-structure/) | [Approach](./0211-design-add-and-search-words-data-structure/solution.md) | Medium | Trie |
| 121 | 212 | [Word Search II](./0212-word-search-ii/) | [Approach](./0212-word-search-ii/solution.md) | Hard | Backtracking |
| 122 | 213 | [House Robber II](./0213-house-robber-ii/) | [Approach](./0213-house-robber-ii/solution.md) | Medium | Dynamic Programming |
| 123 | 215 | [Kth Largest Element in an Array](./0215-kth-largest-element-in-an-array/) | [Approach](./0215-kth-largest-element-in-an-array/solution.md) | Medium | Quick Select |
| 124 | 217 | [Contains Duplicate](./0217-contains-duplicate/) | [Approach](./0217-contains-duplicate/solution.md) | Easy | Sorting |
| 125 | 226 | [Invert Binary Tree](./0226-invert-binary-tree/) | [Approach](./0226-invert-binary-tree/solution.md) | Easy | Recursion |
| 126 | 230 | [Kth Smallest Element in a BST](./0230-kth-smallest-element-in-a-bst/) | [Approach](./0230-kth-smallest-element-in-a-bst/solution.md) | Medium | Tree Traversal |
| 127 | 235 | [Lowest Common Ancestor of a Binary Search Tree](./0235-lowest-common-ancestor-of-a-binary-search-tree/) | [Approach](./0235-lowest-common-ancestor-of-a-binary-search-tree/solution.md) | Medium | Iteration |
| 128 | 238 | [Product of Array Except Self](./0238-product-of-array-except-self/) | [Approach](./0238-product-of-array-except-self/solution.md) | Medium | Two Passes |
| 129 | 239 | [Sliding Window Maximum](./0239-sliding-window-maximum/) | [Approach](./0239-sliding-window-maximum/solution.md) | Hard | Priority Queue (Max-Heap) |
| 130 | 242 | [Valid Anagram](./0242-valid-anagram/) | [Approach](./0242-valid-anagram/solution.md) | Easy | Counting |
| 131 | 252 | [Meeting Rooms](./0252-meeting-rooms/) | [Approach](./0252-meeting-rooms/solution.md) | Easy | Sorting |
| 132 | 253 | [Meeting Rooms II](./0253-meeting-rooms-ii/) | [Approach](./0253-meeting-rooms-ii/solution.md) | Medium | Difference Array |
| 133 | 261 | [Graph Valid Tree](./0261-graph-valid-tree/) | [Approach](./0261-graph-valid-tree/solution.md) | Medium | Union-Find |
| 134 | 268 | [Missing Number](./0268-missing-number/) | [Approach](./0268-missing-number/solution.md) | Easy | Bitwise Operation |
| 135 | 269 | [Alien Dictionary](./0269-alien-dictionary/) | [Approach](./0269-alien-dictionary/solution.md) | Hard | String Scan |
| 136 | 271 | [Encode and Decode Strings](./0271-encode-and-decode-strings/) | [Approach](./0271-encode-and-decode-strings/solution.md) | Medium | Encode String Length |
| 137 | 286 | [Walls and Gates](./0286-walls-and-gates/) | [Approach](./0286-walls-and-gates/solution.md) | Medium | Linear Scan |
| 138 | 287 | [Find the Duplicate Number](./0287-find-the-duplicate-number/) | [Approach](./0287-find-the-duplicate-number/solution.md) | Medium | Binary Search |
| 139 | 297 | [Serialize and Deserialize Binary Tree](./0297-serialize-and-deserialize-binary-tree/) | [Approach](./0297-serialize-and-deserialize-binary-tree/solution.md) | Hard | Level Order Traversal |
| 140 | 300 | [Longest Increasing Subsequence](./0300-longest-increasing-subsequence/) | [Approach](./0300-longest-increasing-subsequence/solution.md) | Medium | Binary Search |
| 141 | 303 | [Range Sum Query - Immutable](./0303-range-sum-query-immutable/) | [Approach](./0303-range-sum-query-immutable/solution.md) | Easy | Prefix Sum |
| 142 | 312 | [Burst Balloons](./0312-burst-balloons/) | [Approach](./0312-burst-balloons/solution.md) | Hard | Dynamic Programming |
| 143 | 322 | [Coin Change](./0322-coin-change/) | [Approach](./0322-coin-change/solution.md) | Medium | Dynamic Programming (Complete Knapsack) |
| 144 | 332 | [Reconstruct Itinerary](./0332-reconstruct-itinerary/) | [Approach](./0332-reconstruct-itinerary/solution.md) | Hard | Eulerian Path |
| 145 | 387 | [First Unique Character in a String](./0387-first-unique-character-in-a-string/) | [Approach](./0387-first-unique-character-in-a-string/solution.md) | Easy | Counting |
| 146 | 518 | [Coin Change II](./0518-coin-change-ii/) | [Approach](./0518-coin-change-ii/solution.md) | Medium | Dynamic Programming (Complete Knapsack) |
| 147 | 1046 | [Last Stone Weight](./1046-last-stone-weight/) | [Approach](./1046-last-stone-weight/solution.md) | Easy | Heap (Priority Queue) |
| 148 | 1448 | [Count Good Nodes in Binary Tree](./1448-count-good-nodes-in-binary-tree/) | [Approach](./1448-count-good-nodes-in-binary-tree/solution.md) | Medium | Tree Traversal |
| 149 | 295 | [Find Median from Data Stream](./0295-find-median-from-data-stream/) | [Approach](./0295-find-median-from-data-stream/solution.md) | Hard | Min Heap and Max Heap (Priority Queue) |
| 150 | 647 | [Palindromic Substrings](./0647-palindromic-substrings/) | [Approach](./0647-palindromic-substrings/solution.md) | Medium | Expand Around Center |
| 151 | 309 | [Best Time to Buy and Sell Stock with Cooldown](./0309-best-time-to-buy-and-sell-stock-with-cooldown/) | [Approach](./0309-best-time-to-buy-and-sell-stock-with-cooldown/solution.md) | Medium | Memoization Search |
| 152 | 323 | [Number of Connected Components in an Undirected Graph](./0323-number-of-connected-components-in-an-undirected-graph/) | [Approach](./0323-number-of-connected-components-in-an-undirected-graph/solution.md) | Medium | DFS |
| 153 | 1584 | [Min Cost to Connect All Points](./1584-min-cost-to-connect-all-points/) | [Approach](./1584-min-cost-to-connect-all-points/solution.md) | Medium | Linear Scan |
| 154 | 684 | [Redundant Connection](./0684-redundant-connection/) | [Approach](./0684-redundant-connection/solution.md) | Medium | Union-Find |
| 155 | 695 | [Max Area of Island](./0695-max-area-of-island/) | [Approach](./0695-max-area-of-island/solution.md) | Medium | Linear Scan |
| 156 | 543 | [Diameter of Binary Tree](./0543-diameter-of-binary-tree/) | [Approach](./0543-diameter-of-binary-tree/solution.md) | Easy | Enumeration + DFS |
| 157 | 739 | [Daily Temperatures](./0739-daily-temperatures/) | [Approach](./0739-daily-temperatures/solution.md) | Medium | Monotonic Stack |
| 158 | 1143 | [Longest Common Subsequence](./1143-longest-common-subsequence/) | [Approach](./1143-longest-common-subsequence/solution.md) | Medium | Dynamic Programming |
| 159 | 901 | [Online Stock Span](./0901-online-stock-span/) | [Approach](./0901-online-stock-span/solution.md) | Medium | Monotonic Stack |
| 160 | 743 | [Network Delay Time](./0743-network-delay-time/) | [Approach](./0743-network-delay-time/solution.md) | Medium | Naive Dijkstra Algorithm |
| 161 | 746 | [Min Cost Climbing Stairs](./0746-min-cost-climbing-stairs/) | [Approach](./0746-min-cost-climbing-stairs/solution.md) | Easy | Memoization Search |
| 162 | 763 | [Partition Labels](./0763-partition-labels/) | [Approach](./0763-partition-labels/solution.md) | Medium | Greedy |
| 163 | 703 | [Kth Largest Element in a Stream](./0703-kth-largest-element-in-a-stream/) | [Approach](./0703-kth-largest-element-in-a-stream/solution.md) | Easy | Priority Queue (Min Heap) |
| 164 | 567 | [Permutation in String](./0567-permutation-in-string/) | [Approach](./0567-permutation-in-string/solution.md) | Medium | Sliding Window |
| 165 | 704 | [Binary Search](./0704-binary-search/) | [Approach](./0704-binary-search/solution.md) | Easy | Binary Search |
| 166 | 778 | [Swim in Rising Water](./0778-swim-in-rising-water/) | [Approach](./0778-swim-in-rising-water/solution.md) | Hard | Union Find |
| 167 | 787 | [Cheapest Flights Within K Stops](./0787-cheapest-flights-within-k-stops/) | [Approach](./0787-cheapest-flights-within-k-stops/solution.md) | Medium | Dynamic Programming |
| 168 | 2013 | [Detect Squares](./2013-detect-squares/) | [Approach](./2013-detect-squares/solution.md) | Medium | Hash Table |
| 169 | 334 | [Increasing Triplet Subsequence](./0334-increasing-triplet-subsequence/) | [Approach](./0334-increasing-triplet-subsequence/solution.md) | Medium | Greedy |
| 170 | 338 | [Counting Bits](./0338-counting-bits/) | [Approach](./0338-counting-bits/solution.md) | Easy | Dynamic Programming |
| 171 | 329 | [Longest Increasing Path in a Matrix](./0329-longest-increasing-path-in-a-matrix/) | [Approach](./0329-longest-increasing-path-in-a-matrix/solution.md) | Hard | Memoization Search |
| 172 | 347 | [Top K Frequent Elements](./0347-top-k-frequent-elements/) | [Approach](./0347-top-k-frequent-elements/solution.md) | Medium | Hash Table + Priority Queue (Min Heap) |
| 173 | 355 | [Design Twitter](./0355-design-twitter/) | [Approach](./0355-design-twitter/solution.md) | Medium | Hash Map + K-way Heap Merge |
| 174 | 846 | [Hand of Straights](./0846-hand-of-straights/) | [Approach](./0846-hand-of-straights/solution.md) | Medium | Hash Table + Sorting |
| 175 | 371 | [Sum of Two Integers](./0371-sum-of-two-integers/) | [Approach](./0371-sum-of-two-integers/solution.md) | Medium | Bit Manipulation |
| 176 | 853 | [Car Fleet](./0853-car-fleet/) | [Approach](./0853-car-fleet/solution.md) | Medium | Monotonic Stack |
| 177 | 875 | [Koko Eating Bananas](./0875-koko-eating-bananas/) | [Approach](./0875-koko-eating-bananas/solution.md) | Medium | Binary Search |
| 178 | 416 | [Partition Equal Subset Sum](./0416-partition-equal-subset-sum/) | [Approach](./0416-partition-equal-subset-sum/solution.md) | Medium | Dynamic Programming |
| 179 | 678 | [Valid Parenthesis String](./0678-valid-parenthesis-string/) | [Approach](./0678-valid-parenthesis-string/solution.md) | Medium | Dynamic Programming |
| 180 | 417 | [Pacific Atlantic Water Flow](./0417-pacific-atlantic-water-flow/) | [Approach](./0417-pacific-atlantic-water-flow/solution.md) | Medium | BFS |
| 181 | 424 | [Longest Repeating Character Replacement](./0424-longest-repeating-character-replacement/) | [Approach](./0424-longest-repeating-character-replacement/solution.md) | Medium | Two Pointers |
| 182 | 435 | [Non-overlapping Intervals](./0435-non-overlapping-intervals/) | [Approach](./0435-non-overlapping-intervals/solution.md) | Medium | Sorting + Greedy |
| 183 | 1851 | [Minimum Interval to Include Each Query](./1851-minimum-interval-to-include-each-query/) | [Approach](./1851-minimum-interval-to-include-each-query/solution.md) | Hard | Sorting + Offline Query + Priority Queue (Min Heap) |
| 184 | 1899 | [Merge Triplets to Form Target Triplet](./1899-merge-triplets-to-form-target-triplet/) | [Approach](./1899-merge-triplets-to-form-target-triplet/solution.md) | Medium | Greedy |
| 185 | 494 | [Target Sum](./0494-target-sum/) | [Approach](./0494-target-sum/solution.md) | Medium | Dynamic Programming |
| 186 | 973 | [K Closest Points to Origin](./0973-k-closest-points-to-origin/) | [Approach](./0973-k-closest-points-to-origin/solution.md) | Medium | Custom Sorting |
| 187 | 981 | [Time Based Key-Value Store](./0981-time-based-key-value-store/) | [Approach](./0981-time-based-key-value-store/solution.md) | Medium | Hash Table + Ordered Set (or Binary Search) |
| 188 | 621 | [Task Scheduler](./0621-task-scheduler/) | [Approach](./0621-task-scheduler/solution.md) | Medium | Heap (Priority Queue) |
| 189 | 1768 | [Merge Strings Alternately](./1768-merge-strings-alternately/) | [Approach](./1768-merge-strings-alternately/solution.md) | Easy | Direct Simulation |
| 190 | 1071 | [Greatest Common Divisor of Strings](./1071-greatest-common-divisor-of-strings/) | [Approach](./1071-greatest-common-divisor-of-strings/solution.md) | Easy | String Scan |
| 191 | 1431 | [Kids With the Greatest Number of Candies](./1431-kids-with-the-greatest-number-of-candies/) | [Approach](./1431-kids-with-the-greatest-number-of-candies/solution.md) | Easy | Linear Scan |
| 192 | 605 | [Can Place Flowers](./0605-can-place-flowers/) | [Approach](./0605-can-place-flowers/solution.md) | Easy | Greedy |
| 193 | 345 | [Reverse Vowels of a String](./0345-reverse-vowels-of-a-string/) | [Approach](./0345-reverse-vowels-of-a-string/solution.md) | Easy | Two Pointers |
| 194 | 443 | [String Compression](./0443-string-compression/) | [Approach](./0443-string-compression/solution.md) | Medium | Two Pointers |
| 195 | 283 | [Move Zeroes](./0283-move-zeroes/) | [Approach](./0283-move-zeroes/solution.md) | Easy | Two Pointers |
| 196 | 392 | [Is Subsequence](./0392-is-subsequence/) | [Approach](./0392-is-subsequence/solution.md) | Easy | Two Pointers |
| 197 | 1679 | [Max Number of K-Sum Pairs](./1679-max-number-of-k-sum-pairs/) | [Approach](./1679-max-number-of-k-sum-pairs/solution.md) | Medium | Sorting |
| 198 | 643 | [Maximum Average Subarray I](./0643-maximum-average-subarray-i/) | [Approach](./0643-maximum-average-subarray-i/solution.md) | Easy | Sliding Window |
| 199 | 1456 | [Maximum Number of Vowels in a Substring of Given Length](./1456-maximum-number-of-vowels-in-a-substring-of-given-length/) | [Approach](./1456-maximum-number-of-vowels-in-a-substring-of-given-length/solution.md) | Medium | Sliding Window |
| 200 | 1004 | [Max Consecutive Ones III](./1004-max-consecutive-ones-iii/) | [Approach](./1004-max-consecutive-ones-iii/solution.md) | Medium | Sliding Window |
| 201 | 1493 | [Longest Subarray of 1's After Deleting One Element](./1493-longest-subarray-of-1s-after-deleting-one-element/) | [Approach](./1493-longest-subarray-of-1s-after-deleting-one-element/solution.md) | Medium | Enumeration |
| 202 | 1732 | [Find the Highest Altitude](./1732-find-the-highest-altitude/) | [Approach](./1732-find-the-highest-altitude/solution.md) | Easy | Prefix Sum (Difference Array) |
| 203 | 724 | [Find Pivot Index](./0724-find-pivot-index/) | [Approach](./0724-find-pivot-index/solution.md) | Easy | Prefix Sum |
| 204 | 2215 | [Find the Difference of Two Arrays](./2215-find-the-difference-of-two-arrays/) | [Approach](./2215-find-the-difference-of-two-arrays/solution.md) | Easy | Hash Table |
| 205 | 1207 | [Unique Number of Occurrences](./1207-unique-number-of-occurrences/) | [Approach](./1207-unique-number-of-occurrences/solution.md) | Easy | Hash Table |
| 206 | 1657 | [Determine if Two Strings Are Close](./1657-determine-if-two-strings-are-close/) | [Approach](./1657-determine-if-two-strings-are-close/solution.md) | Medium | Counting + Sorting |
| 207 | 2352 | [Equal Row and Column Pairs](./2352-equal-row-and-column-pairs/) | [Approach](./2352-equal-row-and-column-pairs/solution.md) | Medium | Simulation |
| 208 | 2390 | [Removing Stars From a String](./2390-removing-stars-from-a-string/) | [Approach](./2390-removing-stars-from-a-string/solution.md) | Medium | Stack Simulation |
| 209 | 735 | [Asteroid Collision](./0735-asteroid-collision/) | [Approach](./0735-asteroid-collision/solution.md) | Medium | Stack |
| 210 | 394 | [Decode String](./0394-decode-string/) | [Approach](./0394-decode-string/solution.md) | Medium | Stack + String Parsing |
| 211 | 933 | [Number of Recent Calls](./0933-number-of-recent-calls/) | [Approach](./0933-number-of-recent-calls/solution.md) | Easy | Data Structure Design |
| 212 | 649 | [Dota2 Senate](./0649-dota2-senate/) | [Approach](./0649-dota2-senate/solution.md) | Medium | Queue + Simulation |
| 213 | 2095 | [Delete the Middle Node of a Linked List](./2095-delete-the-middle-node-of-a-linked-list/) | [Approach](./2095-delete-the-middle-node-of-a-linked-list/solution.md) | Medium | Fast and Slow Pointers |
| 214 | 328 | [Odd Even Linked List](./0328-odd-even-linked-list/) | [Approach](./0328-odd-even-linked-list/solution.md) | Medium | Single Pass |
| 215 | 2130 | [Maximum Twin Sum of a Linked List](./2130-maximum-twin-sum-of-a-linked-list/) | [Approach](./2130-maximum-twin-sum-of-a-linked-list/solution.md) | Medium | Simulation |
| 216 | 872 | [Leaf-Similar Trees](./0872-leaf-similar-trees/) | [Approach](./0872-leaf-similar-trees/solution.md) | Easy | DFS |
| 217 | 437 | [Path Sum III](./0437-path-sum-iii/) | [Approach](./0437-path-sum-iii/solution.md) | Medium | Hash Table + Prefix Sum + Recursion |
| 218 | 572 | [Subtree of Another Tree](./0572-subtree-of-another-tree/) | [Approach](./0572-subtree-of-another-tree/solution.md) | Easy | DFS |
| 219 | 1372 | [Longest ZigZag Path in a Binary Tree](./1372-longest-zigzag-path-in-a-binary-tree/) | [Approach](./1372-longest-zigzag-path-in-a-binary-tree/solution.md) | Medium | Dynamic Programming |
| 220 | 236 | [Lowest Common Ancestor of a Binary Tree](./0236-lowest-common-ancestor-of-a-binary-tree/) | [Approach](./0236-lowest-common-ancestor-of-a-binary-tree/solution.md) | Medium | Recursion |
| 221 | 450 | [Delete Node in a BST](./0450-delete-node-in-a-bst/) | [Approach](./0450-delete-node-in-a-bst/solution.md) | Medium | Tree Traversal |
| 222 | 841 | [Keys and Rooms](./0841-keys-and-rooms/) | [Approach](./0841-keys-and-rooms/solution.md) | Medium | Depth-First Search (DFS) |
| 223 | 547 | [Number of Provinces](./0547-number-of-provinces/) | [Approach](./0547-number-of-provinces/solution.md) | Medium | DFS |
| 224 | 1466 | [Reorder Routes to Make All Paths Lead to the City Zero](./1466-reorder-routes-to-make-all-paths-lead-to-the-city-zero/) | [Approach](./1466-reorder-routes-to-make-all-paths-lead-to-the-city-zero/solution.md) | Medium | DFS |
| 225 | 399 | [Evaluate Division](./0399-evaluate-division/) | [Approach](./0399-evaluate-division/solution.md) | Medium | String Scan |
| 226 | 1926 | [Nearest Exit from Entrance in Maze](./1926-nearest-exit-from-entrance-in-maze/) | [Approach](./1926-nearest-exit-from-entrance-in-maze/solution.md) | Medium | BFS |
| 227 | 2336 | [Smallest Number in Infinite Set](./2336-smallest-number-in-infinite-set/) | [Approach](./2336-smallest-number-in-infinite-set/solution.md) | Medium | Cursor + Min Heap |
| 228 | 2542 | [Maximum Subsequence Score](./2542-maximum-subsequence-score/) | [Approach](./2542-maximum-subsequence-score/solution.md) | Medium | Sorting + Priority Queue (Min Heap) |
| 229 | 2462 | [Total Cost to Hire K Workers](./2462-total-cost-to-hire-k-workers/) | [Approach](./2462-total-cost-to-hire-k-workers/solution.md) | Medium | Priority Queue (Min Heap) |
| 230 | 374 | [Guess Number Higher or Lower](./0374-guess-number-higher-or-lower/) | [Approach](./0374-guess-number-higher-or-lower/solution.md) | Easy | Binary Search |
| 231 | 2300 | [Successful Pairs of Spells and Potions](./2300-successful-pairs-of-spells-and-potions/) | [Approach](./2300-successful-pairs-of-spells-and-potions/solution.md) | Medium | Sorting + Binary Search |
| 232 | 162 | [Find Peak Element](./0162-find-peak-element/) | [Approach](./0162-find-peak-element/solution.md) | Medium | Binary Search |
| 233 | 216 | [Combination Sum III](./0216-combination-sum-iii/) | [Approach](./0216-combination-sum-iii/solution.md) | Medium | Pruning + Backtracking (Two Approaches) |
| 234 | 1137 | [N-th Tribonacci Number](./1137-n-th-tribonacci-number/) | [Approach](./1137-n-th-tribonacci-number/solution.md) | Easy | Dynamic Programming |
| 235 | 790 | [Domino and Tromino Tiling](./0790-domino-and-tromino-tiling/) | [Approach](./0790-domino-and-tromino-tiling/solution.md) | Medium | Dynamic Programming |
| 236 | 714 | [Best Time to Buy and Sell Stock with Transaction Fee](./0714-best-time-to-buy-and-sell-stock-with-transaction-fee/) | [Approach](./0714-best-time-to-buy-and-sell-stock-with-transaction-fee/solution.md) | Medium | Memoization |
| 237 | 1318 | [Minimum Flips to Make a OR b Equal to c](./1318-minimum-flips-to-make-a-or-b-equal-to-c/) | [Approach](./1318-minimum-flips-to-make-a-or-b-equal-to-c/solution.md) | Medium | Bit Manipulation |
| 238 | 1268 | [Search Suggestions System](./1268-search-suggestions-system/) | [Approach](./1268-search-suggestions-system/solution.md) | Medium | Sorting + Trie |
| 239 | 452 | [Minimum Number of Arrows to Burst Balloons](./0452-minimum-number-of-arrows-to-burst-balloons/) | [Approach](./0452-minimum-number-of-arrows-to-burst-balloons/solution.md) | Medium | Greedy |
| 240 | 34 | [Find First and Last Position of Element in Sorted Array](./0034-find-first-and-last-position-of-element-in-sorted-array/) | [Approach](./0034-find-first-and-last-position-of-element-in-sorted-array/solution.md) | Medium | Binary Search |
| 241 | 101 | [Symmetric Tree](./0101-symmetric-tree/) | [Approach](./0101-symmetric-tree/solution.md) | Easy | Recursion |
| 242 | 108 | [Convert Sorted Array to Binary Search Tree](./0108-convert-sorted-array-to-binary-search-tree/) | [Approach](./0108-convert-sorted-array-to-binary-search-tree/solution.md) | Easy | Binary Search + Recursion |
| 243 | 114 | [Flatten Binary Tree to Linked List](./0114-flatten-binary-tree-to-linked-list/) | [Approach](./0114-flatten-binary-tree-to-linked-list/solution.md) | Medium | Find Predecessor Node |
| 244 | 64 | [Minimum Path Sum](./0064-minimum-path-sum/) | [Approach](./0064-minimum-path-sum/solution.md) | Medium | Dynamic Programming |
| 245 | 118 | [Pascal's Triangle](./0118-pascals-triangle/) | [Approach](./0118-pascals-triangle/solution.md) | Easy | Simulation |
| 246 | 279 | [Perfect Squares](./0279-perfect-squares/) | [Approach](./0279-perfect-squares/solution.md) | Medium | Dynamic Programming |
| 247 | 560 | [Subarray Sum Equals K](./0560-subarray-sum-equals-k/) | [Approach](./0560-subarray-sum-equals-k/solution.md) | Medium | Hash Table + Prefix Sum |
| 248 | 142 | [Linked List Cycle II](./0142-linked-list-cycle-ii/) | [Approach](./0142-linked-list-cycle-ii/solution.md) | Medium | Two Pointers |
| 249 | 148 | [Sort List](./0148-sort-list/) | [Approach](./0148-sort-list/solution.md) | Medium | Merge Sort |
| 250 | 160 | [Intersection of Two Linked Lists](./0160-intersection-of-two-linked-lists/) | [Approach](./0160-intersection-of-two-linked-lists/solution.md) | Easy | Two Pointers |
| 251 | 234 | [Palindrome Linked List](./0234-palindrome-linked-list/) | [Approach](./0234-palindrome-linked-list/solution.md) | Easy | Fast and Slow Pointers |
| 252 | 240 | [Search a 2D Matrix II](./0240-search-a-2d-matrix-ii/) | [Approach](./0240-search-a-2d-matrix-ii/solution.md) | Medium | Binary Search |
| 253 | 438 | [Find All Anagrams in a String](./0438-find-all-anagrams-in-a-string/) | [Approach](./0438-find-all-anagrams-in-a-string/solution.md) | Medium | Sliding Window |
| 254 | 169 | [Majority Element](./0169-majority-element/) | [Approach](./0169-majority-element/solution.md) | Easy | Moore Voting Algorithm |
| 255 | 189 | [Rotate Array](./0189-rotate-array/) | [Approach](./0189-rotate-array/solution.md) | Medium | Reverse three times |
| 256 | 122 | [Best Time to Buy and Sell Stock II](./0122-best-time-to-buy-and-sell-stock-ii/) | [Approach](./0122-best-time-to-buy-and-sell-stock-ii/solution.md) | Medium | Greedy Algorithm |
| 257 | 274 | [H-Index](./0274-h-index/) | [Approach](./0274-h-index/solution.md) | Medium | Sorting |
| 258 | 380 | [Insert Delete GetRandom O(1)](./0380-insert-delete-getrandom-o1/) | [Approach](./0380-insert-delete-getrandom-o1/solution.md) | Medium | Hash Table + Dynamic List |
| 259 | 135 | [Candy](./0135-candy/) | [Approach](./0135-candy/solution.md) | Hard | Two traversals |
| 260 | 209 | [Minimum Size Subarray Sum](./0209-minimum-size-subarray-sum/) | [Approach](./0209-minimum-size-subarray-sum/solution.md) | Medium | Prefix Sum + Binary Search |
| 261 | 289 | [Game of Life](./0289-game-of-life/) | [Approach](./0289-game-of-life/solution.md) | Medium | In-place marking |
| 262 | 383 | [Ransom Note](./0383-ransom-note/) | [Approach](./0383-ransom-note/solution.md) | Easy | Hash Table or Array |
| 263 | 205 | [Isomorphic Strings](./0205-isomorphic-strings/) | [Approach](./0205-isomorphic-strings/solution.md) | Easy | Hash Table or Array |
| 264 | 290 | [Word Pattern](./0290-word-pattern/) | [Approach](./0290-word-pattern/solution.md) | Easy | Hash Table |
| 265 | 219 | [Contains Duplicate II](./0219-contains-duplicate-ii/) | [Approach](./0219-contains-duplicate-ii/solution.md) | Easy | Hash Table |
| 266 | 228 | [Summary Ranges](./0228-summary-ranges/) | [Approach](./0228-summary-ranges/solution.md) | Easy | Two Pointers |
| 267 | 224 | [Basic Calculator](./0224-basic-calculator/) | [Approach](./0224-basic-calculator/solution.md) | Hard | Stack |
| 268 | 106 | [Construct Binary Tree from Inorder and Postorder Traversal](./0106-construct-binary-tree-from-inorder-and-postorder-traversal/) | [Approach](./0106-construct-binary-tree-from-inorder-and-postorder-traversal/solution.md) | Medium | Hash Table + Recursion |
| 269 | 117 | [Populating Next Right Pointers in Each Node II](./0117-populating-next-right-pointers-in-each-node-ii/) | [Approach](./0117-populating-next-right-pointers-in-each-node-ii/solution.md) | Medium | BFS |
| 270 | 994 | [Rotting Oranges](./0994-rotting-oranges/) | [Approach](./0994-rotting-oranges/solution.md) | Medium | BFS |
| 271 | 112 | [Path Sum](./0112-path-sum/) | [Approach](./0112-path-sum/solution.md) | Easy | Recursion |
| 272 | 129 | [Sum Root to Leaf Numbers](./0129-sum-root-to-leaf-numbers/) | [Approach](./0129-sum-root-to-leaf-numbers/solution.md) | Medium | DFS |
| 273 | 173 | [Binary Search Tree Iterator](./0173-binary-search-tree-iterator/) | [Approach](./0173-binary-search-tree-iterator/solution.md) | Medium | Tree Traversal |
| 274 | 222 | [Count Complete Tree Nodes](./0222-count-complete-tree-nodes/) | [Approach](./0222-count-complete-tree-nodes/solution.md) | Medium | Recursion |
| 275 | 637 | [Average of Levels in Binary Tree](./0637-average-of-levels-in-binary-tree/) | [Approach](./0637-average-of-levels-in-binary-tree/solution.md) | Easy | BFS |
| 276 | 103 | [Binary Tree Zigzag Level Order Traversal](./0103-binary-tree-zigzag-level-order-traversal/) | [Approach](./0103-binary-tree-zigzag-level-order-traversal/solution.md) | Medium | BFS |
| 277 | 530 | [Minimum Absolute Difference in BST](./0530-minimum-absolute-difference-in-bst/) | [Approach](./0530-minimum-absolute-difference-in-bst/solution.md) | Easy | Inorder Traversal |
| 278 | 909 | [Snakes and Ladders](./0909-snakes-and-ladders/) | [Approach](./0909-snakes-and-ladders/solution.md) | Medium | BFS |
| 279 | 433 | [Minimum Genetic Mutation](./0433-minimum-genetic-mutation/) | [Approach](./0433-minimum-genetic-mutation/solution.md) | Medium | BFS |
| 280 | 427 | [Construct Quad Tree](./0427-construct-quad-tree/) | [Approach](./0427-construct-quad-tree/solution.md) | Medium | Divide and Conquer |
| 281 | 918 | [Maximum Sum Circular Subarray](./0918-maximum-sum-circular-subarray/) | [Approach](./0918-maximum-sum-circular-subarray/solution.md) | Medium | Maintain Prefix Maximum |
| 282 | 502 | [IPO](./0502-ipo/) | [Approach](./0502-ipo/solution.md) | Hard | Heap (Priority Queue) |
| 283 | 373 | [Find K Pairs with Smallest Sums](./0373-find-k-pairs-with-smallest-sums/) | [Approach](./0373-find-k-pairs-with-smallest-sums/solution.md) | Medium | Heap (Priority Queue) |
| 284 | 137 | [Single Number II](./0137-single-number-ii/) | [Approach](./0137-single-number-ii/solution.md) | Medium | Bitwise Operation |
| 285 | 201 | [Bitwise AND of Numbers Range](./0201-bitwise-and-of-numbers-range/) | [Approach](./0201-bitwise-and-of-numbers-range/solution.md) | Medium | Bit Manipulation |
| 286 | 172 | [Factorial Trailing Zeroes](./0172-factorial-trailing-zeroes/) | [Approach](./0172-factorial-trailing-zeroes/solution.md) | Medium | Mathematics |
| 287 | 149 | [Max Points on a Line](./0149-max-points-on-a-line/) | [Approach](./0149-max-points-on-a-line/solution.md) | Hard | Hash Table |
| 288 | 120 | [Triangle](./0120-triangle/) | [Approach](./0120-triangle/solution.md) | Medium | Dynamic Programming |
| 289 | 123 | [Best Time to Buy and Sell Stock III](./0123-best-time-to-buy-and-sell-stock-iii/) | [Approach](./0123-best-time-to-buy-and-sell-stock-iii/solution.md) | Hard | Dynamic Programming |
| 290 | 188 | [Best Time to Buy and Sell Stock IV](./0188-best-time-to-buy-and-sell-stock-iv/) | [Approach](./0188-best-time-to-buy-and-sell-stock-iv/solution.md) | Hard | Memoization Search |
| 291 | 221 | [Maximal Square](./0221-maximal-square/) | [Approach](./0221-maximal-square/solution.md) | Medium | Dynamic Programming |
| 292 | 876 | [Middle of the Linked List](./0876-middle-of-the-linked-list/) | [Approach](./0876-middle-of-the-linked-list/solution.md) | Easy | Fast and Slow Pointers |
| 293 | 278 | [First Bad Version](./0278-first-bad-version/) | [Approach](./0278-first-bad-version/solution.md) | Easy | Binary Search |
| 294 | 409 | [Longest Palindrome](./0409-longest-palindrome/) | [Approach](./0409-longest-palindrome/solution.md) | Easy | Counting |
| 295 | 542 | [01 Matrix](./0542-01-matrix/) | [Approach](./0542-01-matrix/solution.md) | Medium | BFS |
| 296 | 310 | [Minimum Height Trees](./0310-minimum-height-trees/) | [Approach](./0310-minimum-height-trees/solution.md) | Medium | Topological Sorting |
| 297 | 1235 | [Maximum Profit in Job Scheduling](./1235-maximum-profit-in-job-scheduling/) | [Approach](./1235-maximum-profit-in-job-scheduling/solution.md) | Hard | Memoization Search + Binary Search |
| 298 | 721 | [Accounts Merge](./0721-accounts-merge/) | [Approach](./0721-accounts-merge/solution.md) | Medium | Union-Find + Hash Table |
| 299 | 733 | [Flood Fill](./0733-flood-fill/) | [Approach](./0733-flood-fill/solution.md) | Easy | DFS |
| 300 | 232 | [Implement Queue using Stacks](./0232-implement-queue-using-stacks/) | [Approach](./0232-implement-queue-using-stacks/solution.md) | Easy | Double Stack |
| 301 | 987 | [Vertical Order Traversal of a Binary Tree](./0987-vertical-order-traversal-of-a-binary-tree/) | [Approach](./0987-vertical-order-traversal-of-a-binary-tree/solution.md) | Hard | DFS + Sorting |
| 302 | 1008 | [Construct Binary Search Tree from Preorder Traversal](./1008-construct-binary-search-tree-from-preorder-traversal/) | [Approach](./1008-construct-binary-search-tree-from-preorder-traversal/solution.md) | Medium | DFS + Binary Search |
| 303 | 1520 | [Maximum Number of Non-Overlapping Substrings](./1520-maximum-number-of-non-overlapping-substrings/) | [Approach](./1520-maximum-number-of-non-overlapping-substrings/solution.md) | Hard | Greedy Interval Expansion |
| 304 | 116 | [Populating Next Right Pointers in Each Node](./0116-populating-next-right-pointers-in-each-node/) | [Approach](./0116-populating-next-right-pointers-in-each-node/solution.md) | Medium | BFS |
| 305 | 645 | [Set Mismatch](./0645-set-mismatch/) | [Approach](./0645-set-mismatch/solution.md) | Easy | Mathematics |
| 306 | 1547 | [Minimum Cost to Cut a Stick](./1547-minimum-cost-to-cut-a-stick/) | [Approach](./1547-minimum-cost-to-cut-a-stick/solution.md) | Hard | Dynamic Programming (Interval DP) |
| 307 | 653 | [Two Sum IV - Input is a BST](./0653-two-sum-iv-input-is-a-bst/) | [Approach](./0653-two-sum-iv-input-is-a-bst/solution.md) | Easy | Two Pointers |
| 308 | 144 | [Binary Tree Preorder Traversal](./0144-binary-tree-preorder-traversal/) | [Approach](./0144-binary-tree-preorder-traversal/solution.md) | Easy | Recursive Traversal |
| 309 | 145 | [Binary Tree Postorder Traversal](./0145-binary-tree-postorder-traversal/) | [Approach](./0145-binary-tree-postorder-traversal/solution.md) | Easy | Recursion |
| 310 | 662 | [Maximum Width of Binary Tree](./0662-maximum-width-of-binary-tree/) | [Approach](./0662-maximum-width-of-binary-tree/solution.md) | Medium | Tree Traversal |
| 311 | 165 | [Compare Version Numbers](./0165-compare-version-numbers/) | [Approach](./0165-compare-version-numbers/solution.md) | Medium | Two Pointers |
| 312 | 686 | [Repeated String Match](./0686-repeated-string-match/) | [Approach](./0686-repeated-string-match/solution.md) | Medium | String Scan |
| 313 | 225 | [Implement Stack using Queues](./0225-implement-stack-using-queues/) | [Approach](./0225-implement-stack-using-queues/solution.md) | Easy | Two Queues |
| 314 | 229 | [Majority Element II](./0229-majority-element-ii/) | [Approach](./0229-majority-element-ii/solution.md) | Medium | Hash Table |
| 315 | 237 | [Delete Node in a Linked List](./0237-delete-node-in-a-linked-list/) | [Approach](./0237-delete-node-in-a-linked-list/solution.md) | Medium | Node assignment |
| 316 | 700 | [Search in a Binary Search Tree](./0700-search-in-a-binary-search-tree/) | [Approach](./0700-search-in-a-binary-search-tree/solution.md) | Easy | Recursion |
| 317 | 785 | [Is Graph Bipartite?](./0785-is-graph-bipartite/) | [Approach](./0785-is-graph-bipartite/solution.md) | Medium | Coloring Method to Determine Bipartite Graph |
| 318 | 1707 | [Maximum XOR With an Element From Array](./1707-maximum-xor-with-an-element-from-array/) | [Approach](./1707-maximum-xor-with-an-element-from-array/solution.md) | Hard | Offline Query + Binary Trie |
| 319 | 421 | [Maximum XOR of Two Numbers in an Array](./0421-maximum-xor-of-two-numbers-in-an-array/) | [Approach](./0421-maximum-xor-of-two-numbers-in-an-array/solution.md) | Medium | Trie |
| 320 | 1373 | [Maximum Sum BST in Binary Tree](./1373-maximum-sum-bst-in-binary-tree/) | [Approach](./1373-maximum-sum-bst-in-binary-tree/solution.md) | Hard | DFS |
| 321 | 460 | [LFU Cache](./0460-lfu-cache/) | [Approach](./0460-lfu-cache/solution.md) | Hard | Pointer Manipulation |
| 322 | 474 | [Ones and Zeroes](./0474-ones-and-zeroes/) | [Approach](./0474-ones-and-zeroes/solution.md) | Medium | Dynamic Programming |
| 323 | 485 | [Max Consecutive Ones](./0485-max-consecutive-ones/) | [Approach](./0485-max-consecutive-ones/solution.md) | Easy | Single Pass |
| 324 | 493 | [Reverse Pairs](./0493-reverse-pairs/) | [Approach](./0493-reverse-pairs/solution.md) | Hard | Binary Search |
| 325 | 496 | [Next Greater Element I](./0496-next-greater-element-i/) | [Approach](./0496-next-greater-element-i/solution.md) | Easy | Monotonic Stack |
| 326 | 1438 | [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](./1438-longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | [Approach](./1438-longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution.md) | Medium | Sliding Window + Monotonic Deques |
| 327 | 432 | [All O`one Data Structure](./0432-all-oone-data-structure/) | [Approach](./0432-all-oone-data-structure/solution.md) | Hard | Hash Map + Doubly Linked Frequency Buckets |
| 328 | 362 | [Design Hit Counter](./0362-design-hit-counter/) | [Approach](./0362-design-hit-counter/solution.md) | Medium | Binary Search |
| 329 | 725 | [Split Linked List in Parts](./0725-split-linked-list-in-parts/) | [Approach](./0725-split-linked-list-in-parts/solution.md) | Medium | Simulation |
| 330 | 1944 | [Number of Visible People in a Queue](./1944-number-of-visible-people-in-a-queue/) | [Approach](./1944-number-of-visible-people-in-a-queue/solution.md) | Hard | Monotonic Stack |
| 331 | 670 | [Maximum Swap](./0670-maximum-swap/) | [Approach](./0670-maximum-swap/solution.md) | Medium | Greedy Algorithm |
| 332 | 3481 | [Apply Substitutions](./3481-apply-substitutions/) | [Approach](./3481-apply-substitutions/solution.md) | Medium | Hash Table + Recursion |
| 333 | 1161 | [Maximum Level Sum of a Binary Tree](./1161-maximum-level-sum-of-a-binary-tree/) | [Approach](./1161-maximum-level-sum-of-a-binary-tree/solution.md) | Medium | BFS |

## Verification

```bash
go test ./...
```

See [NOTICE.md](./NOTICE.md) for source attribution.

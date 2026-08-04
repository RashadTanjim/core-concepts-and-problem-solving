# 24. Swap Nodes in Pairs - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/)

## Pattern recognition

The main signal is **Recursion**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

A tree solution starts by defining what information a subtree must return. Avoid rescanning descendants by computing that summary once per node.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Recursion**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** After a node returns, its result is correct for the entire subtree rooted at that node.

## Why it works

Null and leaf cases establish the base. Combining correct left and right subtree summaries according to the node rule proves correctness by structural induction.

## Complexity

Each node is normally visited once for `O(n)` time; space is `O(h)` for recursion or an explicit frontier, where `h` is tree height. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

## Edge cases to call out

- Empty or minimum-size input when permitted by the prompt.
- Duplicate values, repeated characters, or equal-priority states.
- Already optimal, fully sorted, or fully invalid input.
- Integer overflow and boundary indices where arithmetic is involved.
- Degenerate structures such as a one-sided tree, a cycle, or a disconnected graph when relevant.

## Go submission notes

- Submit the imports and implementation from <code>solution.go</code>.
- <code>types.go</code> exists only when this repository needs a local version of a LeetCode-provided type or callback.
- Explain the invariant before coding, use descriptive state names, and finish by testing one normal case plus one boundary case aloud.

# 973. K Closest Points to Origin - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/k-closest-points-to-origin/)

## Pattern recognition

The main signal is **Custom Sorting**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

Without ordering, candidate relationships are expensive to discover repeatedly. Sort once so relevant neighbors or monotonic boundaries become adjacent.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Custom Sorting**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** The sorted prefix has been fully resolved, and unresolved candidates appear in an order that permits safe one-way movement.

## Why it works

Sorting exposes candidates in the exact comparison order used by the algorithm. Each scan step finalizes the next candidate without invalidating earlier decisions.

## Complexity

Sorting costs `O(n log n)` and the following scan is usually linear; auxiliary space depends on the Go sorting implementation and result storage. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

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

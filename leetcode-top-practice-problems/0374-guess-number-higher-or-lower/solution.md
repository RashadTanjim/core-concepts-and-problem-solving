# 374. Guess Number Higher or Lower - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/guess-number-higher-or-lower/)

## Pattern recognition

The main signal is **Binary Search**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

A linear scan is the simplest baseline, but it ignores the monotonic ordering or monotonic feasibility condition exposed by the constraints.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Binary Search**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** The answer remains inside the current search interval; each comparison safely eliminates the half that cannot contain it.

## Why it works

Every branch follows directly from the monotonic predicate. Because the discarded half cannot contain a valid answer, termination leaves exactly the requested boundary or value.

## Complexity

Binary search contributes a logarithmic factor; include any per-check work when giving the final time bound. Iterative search uses constant auxiliary space. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

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
